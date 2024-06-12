import express from "express"

const PORT=9000

const app = express()

app.get('/', (req, res) => {
    res.send("hello, world")
})

app.listen(PORT, () => {
    console.log(`Server Running on http://localhost:${PORT}`)
})