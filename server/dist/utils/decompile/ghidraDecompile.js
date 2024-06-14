"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.decompileWithGhidra = void 0;
const child_process_1 = require("child_process");
const fs_1 = __importDefault(require("fs"));
const path_1 = __importDefault(require("path"));
const dotenv_1 = __importDefault(require("dotenv"));
dotenv_1.default.config({
    path: '../.env'
});
const ghidraPath = '/Users/dev-rvk/Desktop/Data/ghidra_11.0.3_PUBLIC/';
console.log(ghidraPath);
if (!ghidraPath) {
    throw new Error("Ghidra path not set. Please set the GHIDRA_HOME environment variable.");
}
function decompileWithGhidra(filePath, originalName) {
    return new Promise((resolve, reject) => {
        const outputFilePath = path_1.default.join(__dirname, '../../decompiled/ghidra/', `${path_1.default.basename(filePath)}.c`);
        const ghidraScript = path_1.default.join(__dirname, './Decompile.java'); // The script to run decompilation
        const env = Object.assign(Object.assign({}, process.env), { DECOMPILED_FILE: outputFilePath });
        (0, child_process_1.exec)(`${ghidraPath}/support/analyzeHeadless . tempProject -import ${filePath} -postScript ${ghidraScript} ${outputFilePath}`, { env }, (error, stdout, stderr) => {
            if (error) {
                return reject(`Decompilation error: ${stderr || error.message}`);
            }
            fs_1.default.readFile(outputFilePath, 'utf8', (err, data) => {
                if (err) {
                    return reject(`Read file error: ${err.message}`);
                }
                // Clean up the temporary files
                fs_1.default.unlinkSync(filePath);
                fs_1.default.unlinkSync(outputFilePath);
                resolve(data);
            });
        });
    });
}
exports.decompileWithGhidra = decompileWithGhidra;
// Test the function
decompileWithGhidra('../../../uploads/liborbit-jni-spotify.so', 'liborbit-jni-spotify')
    .then(data => console.log(data))
    .catch(err => console.error(err));
