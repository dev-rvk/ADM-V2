import express from "express"
import multer from "multer";
import path from "path";
import fs from "fs";

//import { decompileWithGhidra } from "./utils/decompile/ghidraDecompile";

const PORT=9000

const app = express()

app.get('/', (req, res) => {
    res.json({ version:"0.0.1" })
})

const upload = multer({ dest: "uploads/" });



app.listen(PORT, () => {
    console.log(`Server Running on http://localhost:${PORT}`)
});