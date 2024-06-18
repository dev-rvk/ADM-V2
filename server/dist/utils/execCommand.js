"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.execCommand = void 0;
// utils/execCommand.ts
const child_process_1 = require("child_process");
function execCommand(command) {
    return new Promise((resolve, reject) => {
        console.log(`Executing command: ${command}`);
        (0, child_process_1.exec)(command, (error, stdout, stderr) => {
            if (error) {
                console.error(`Error executing command: ${error.message}`);
                return resolve({
                    success: false,
                    message: "Error during decompilation",
                    output: stderr,
                });
            }
            if (stderr) {
                console.error(`Command stderr: ${stderr}`);
                return resolve({
                    success: true,
                    message: "Error during decompilation",
                    output: stderr,
                });
            }
            console.log(`Command stdout: ${stdout}`);
            resolve({
                success: true,
                message: "Successfully decompiled",
                output: stdout,
            });
        });
    });
}
exports.execCommand = execCommand;
