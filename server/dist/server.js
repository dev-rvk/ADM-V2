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
const getRootPath_1 = require("./utils/getRootPath");
const execCommand_1 = require("./utils/execCommand");
const PORT = 9000;
const app = (0, express_1.default)();
app.get('/', (req, res) => {
    res.json({ version: "0.0.1" });
});
app.get('/decompile_jadx', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const uploadsPath = (0, getRootPath_1.getRootPath)('workers/jadx_decompile/uploads');
    const outputPath = (0, getRootPath_1.getRootPath)('workers/jadx_decompile/output');
    console.log(uploadsPath);
    const command = `docker run -v ${uploadsPath}:/app/uploads -v ${outputPath}:/app/output jadx-decompile test.apk`;
    const result = yield (0, execCommand_1.execCommand)(command);
    if (!result.success) {
        return res.status(500).send(result.message);
    }
    res.send(result.message);
}));
app.get('/decompile_so', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const uploadsPath = (0, getRootPath_1.getRootPath)('workers/so_decompiler/uploads');
    const outputPath = (0, getRootPath_1.getRootPath)('workers/so_decompiler/output');
    const command = `docker run -v ${uploadsPath}:/decompile/uploads -v ${outputPath}:/decompile/output decompiler decompile /decompile/uploads/libnativehello-lib.so /decompile/output`;
    const result = yield (0, execCommand_1.execCommand)(command);
    if (!result.success) {
        return res.status(500).send(result.message);
    }
    res.send(result.message);
}));
app.listen(PORT, () => {
    console.log(`Server Running on http://localhost:${PORT}`);
});
