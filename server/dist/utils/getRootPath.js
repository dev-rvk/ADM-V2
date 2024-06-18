"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.getRootPath = void 0;
const path_1 = __importDefault(require("path"));
function getRootPath(relativePath) {
    const projectRoot = process.cwd();
    const resolvedPath = path_1.default.resolve(projectRoot, relativePath);
    return resolvedPath;
}
exports.getRootPath = getRootPath;
