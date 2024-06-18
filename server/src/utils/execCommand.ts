// utils/execCommand.ts
import { exec } from 'child_process';

interface ExecResult {
  success: boolean;
  message: string;
  output: string;
}

export function execCommand(command: string): Promise<ExecResult> {
  return new Promise((resolve, reject) => {
    console.log(`Executing command: ${command}`);
    
    exec(command, (error, stdout, stderr) => {
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
          message: "Check errors during decompilation",
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
