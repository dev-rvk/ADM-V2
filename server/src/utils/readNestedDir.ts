import fs from 'fs';
import path from 'path';

export function readNestedDir(dir: string, baseDir: string): string[] {
    const files: string[] = [];

    const readDirRecursive = (currentDir: string) => {
        const items = fs.readdirSync(currentDir);

        items.forEach(item => {
            const fullPath = path.join(currentDir, item);
            const relativePath = path.relative(baseDir, fullPath);

            const stat = fs.statSync(fullPath);
            if (stat.isDirectory()) {
                readDirRecursive(fullPath);
            } else {
                files.push(relativePath);
            }
        });
    };

    readDirRecursive(dir);
    return files;
}


