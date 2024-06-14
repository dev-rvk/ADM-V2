"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const multer_1 = __importDefault(require("multer"));
const path_1 = __importDefault(require("path"));
const fs_1 = __importDefault(require("fs"));
const ghidraDecompile_1 = require("./utils/decompile/ghidraDecompile");
const PORT = 9000;
const app = (0, express_1.default)();
app.get('/', (req, res) => {
    res.json({ version: "0.0.1" });
});
const upload = (0, multer_1.default)({ dest: "uploads/" });
app.post('/decompile/ghidra', upload.single('file'), (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const file = req.file;
    if (!file) {
        return res.status(400).send("No file uploaded.");
    }
    if (path_1.default.extname(file.originalname) !== ".so") {
        fs_1.default.unlinkSync(file.path); // Remove the file
        return res.status(400).send("Filetype not valid");
    }
    try {
        const decompiledOutput = yield (0, ghidraDecompile_1.decompileWithGhidra)(file.path, file.originalname);
        res.send(decompiledOutput);
    }
    catch (error) {
        console.error(error);
        res.status(500).send(`Error during decompilation: ${error}`);
    }
}));
app.listen(PORT, () => {
    console.log(`Server Running on http://localhost:${PORT}`);
});
