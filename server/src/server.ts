import express from "express"
import { exec } from 'child_process';
import { getRootPath } from "./utils/getRootPath";
import { execCommand } from "./utils/execCommand";
import multer from "multer";
import fs from "fs";


const PORT=9000

const app = express()

app.get('/', (req, res) => {
    res.json({ version:"0.0.1" })
})

app.get('/decompile_jadx', async (req, res) => {

    const uploadsPath = getRootPath('workers/jadx_decompile/uploads')
    const outputPath = getRootPath('workers/jadx_decompile/output')
    // TODO: get apk file from frontend (change to POST request) and the store it to the uploadPath

    // execute the commands to decompile apk
    console.log(uploadsPath);
    const command = `docker run -v ${uploadsPath}:/app/uploads -v ${outputPath}:/app/output jadx-decompile test.apk`;

    const result = await execCommand(command);

    // if the command failed, return the error message
    if (!result.success) {
      return res.status(500).send(result.message);
    }
    
    // TODO: send the generated folder from the outputPath to the frontend (you need to figure out how)

    // dummy response
    res.send(result.message);
})

app.get('/decompile_so', async (req, res) => {

    const uploadsPath = getRootPath('workers/so_decompiler/uploads');
    const outputPath = getRootPath('workers/so_decompiler/output');

    // TODO: get so file from frontend (change to POST request) and the store it to the uploadPath
    // TODO: from the request extract which decompiler to use and acordingly change the command
    // https://github.com/dev-rvk/so_decompiler refer this to know changes in the command (to change arguments in the command)

    // execute the commands to decompile so
    const command = `docker run -v ${uploadsPath}:/decompile/uploads -v ${outputPath}:/decompile/output decompiler decompile /decompile/uploads/libnativehello-lib.so /decompile/output`;

    const result = await execCommand(command);

    // if the command failed, return the error message
    if (!result.success) {
      return res.status(500).send(result.message);
    }

    // TODO: send the generated file from the outputPath to the frontend

    // dummy response
    res.send(result.message);
})


app.listen(PORT, () => {
    console.log(`Server Running on http://localhost:${PORT}`)
});