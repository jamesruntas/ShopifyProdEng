const express = require("express");
const app = express();

var http = require("http").createServer(app);
const port = 8080;

app.use("/static", express.static("./static/"));

app.get("/", (req, res) => {
  res.sendFile(__dirname + "/webApp.html");
});

app.listen(port, function () {
  console.log(`Server listening http://localhost:8080/`);
});