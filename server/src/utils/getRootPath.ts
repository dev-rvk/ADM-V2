import path from "path";

export function getRootPath(relativePath: string): string {
  const projectRoot = process.cwd();
  const resolvedPath = path.resolve(projectRoot, relativePath);
  return resolvedPath;
}
