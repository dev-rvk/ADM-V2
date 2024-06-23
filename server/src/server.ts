import express from "express"
import { getRootPath } from "./utils/getRootPath";
import { execCommand } from "./utils/execCommand";
import multer from "multer";
import path from 'path';
import fs from 'fs';
import cors from 'cors';

const PORT=9000
const app = express()
app.use(cors())

function getMulterUpload(destination: string) {
  const storage = multer.diskStorage({
    destination: (req, file, cb) => {
      cb(null, destination);
    },
    filename: (req, file, cb) => {
      cb(null, file.originalname);
    }
  });

  return multer({ storage });
}


app.get('/', (req, res) => {
    res.json({ version:"0.0.1" })
})

app.post('/decompile_jadx', async (req, res) => {
  const uploadsPath = getRootPath('workers/jadx_decompile/uploads');
  const outputPath = getRootPath('workers/jadx_decompile/output');
  
  const upload = getMulterUpload(uploadsPath).single('apkfile');

  upload(req, res, async (err) => {
    if (err) {
      return res.status(500).send(`File upload failed Error ${err}`);
    }

    const apkFile = req.file;
    if (!apkFile) {
      return res.status(400).send('No file uploaded.');
    }

    // Execute the commands to decompile APK
    const command = `docker run -v ${uploadsPath}:/app/uploads -v ${outputPath}:/app/output jadx-decompile ${apkFile.filename}`;

    const result = await execCommand(command);

    // TODO: If the command failed, send files to the frontend

  })
    
});


app.post('/decompile_so', async (req, res) => {

  console.log(req.body)
  const uploadsPath = getRootPath('workers/so_decompiler/uploads');
  const outputPath = getRootPath('workers/so_decompiler/output');

  const upload = getMulterUpload(uploadsPath).single('sofile');

  upload(req, res, async (err) => {
      if (err) {
          console.error('Multer error:', err);
          return res.status(500).send(`File upload failed. Error: ${err.message}`);
      }

      const soFile = req.file;
      if (!soFile) {
          return res.status(400).send('No file uploaded.');
      }

      const selections = req.body.selections || [];
      let argument;
      if (selections.includes('angr') && selections.includes('ghidra')) {
          argument = 'decompile';
      } else if (selections.includes('angr')) {
          argument = 'angr';
      } else if (selections.includes('ghidra')) {
          argument = 'ghidra';
      } else {
          return res.status(400).send('Invalid selections.');
      }

      // Execute the commands to decompile SO file
      const command = `docker run -v ${uploadsPath}:/decompile/uploads -v ${outputPath}:/decompile/output decompiler ${argument} /decompile/uploads/${soFile.filename} /decompile/output`;

      const result = await execCommand(command);

      // if the command failed, return the error message
      if (!result.success) {
          return res.status(500).send(result.message);
      }

      // TODO: send the generated file from the outputPath to the frontend

      // dummy response
      res.send(result.message);
  })
})



app.listen(PORT, () => {
    console.log(`Server Running on http://localhost:${PORT}`)
});