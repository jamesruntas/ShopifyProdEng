let addbutton = document.getElementById("add");
let btnremove = document.getElementById("remove");
let textbox = document.getElementById("box");
let checkDiv = document.getElementById("checkDiv");

let listArray = [];

let boxArray = [];
let checkbox = document.getElementById("checkbox");

function add() {
  let userinput = textbox.value;
  if (userinput.length >= 1) {
    let checkLabel = document.createElement("label");
    let newcb = document.createElement("input");
    let listItem = document.createElement("li");

    newcb.type = "checkbox";
    newcb.name = "label";
    newcb.id = userinput;

    checkLabel.htmlFor = "CBs";
    checkLabel.name = "label";
    listItem.htmlFor = "CBs";
    listItem.style = "list-style-type:none;";

    boxArray.push(listItem);
    checkLabel.appendChild(document.createTextNode(userinput));

    listItem.appendChild(newcb);
    listItem.appendChild(checkLabel);

    checkDiv.appendChild(listItem);
  }

  textbox.value = "";
}
function remove() {
  for (let i = 0; i < boxArray.length; i++) {
    var boxChildren = boxArray[i].childNodes;

    if (boxChildren[0].checked == true) {
      boxArray[i].removeChild(boxChildren[1]);
      boxArray[i].removeChild(boxChildren[0]);
    }
  }
}
function edit() {
  checkAmount();
  let userinput = textbox.value;
  if (userinput == "") {
    alert(
      "Enter something in the text field to replace current value of checked item"
    );
    return;
  }

  for (let i = 0; i < boxArray.length; i++) {
    var boxChildren = boxArray[i].childNodes;
    if (boxChildren[0].checked == true) {
      boxArray[i].removeChild(boxChildren[1]);
      boxArray[i].removeChild(boxChildren[0]);
    }
  }
  add();
}

function checkAmount() {
  let count = 0;
  for (let i = 0; i < boxArray.length; i++) {
    var boxChildren = boxArray[i].childNodes;

    if (boxChildren[0].checked == true) {
      count++;
    }
  }

  if (count != 1) {
    alert("Only select one item to edit!");
  }
}

function exportToCSV() {
  let csvArray = [];
  for (let i = 0; i < boxArray.length; i++) {
    var boxChildren = boxArray[i].childNodes;

    let newArr = ["Product"];
    newArr.push(boxChildren[0].id);

    csvArray.push(newArr);
  }

  console.log(csvArray);

  let csvContent =
    "data:text/csv;charset=utf-8," +
    csvArray.map((e) => e.join(",")).join("\n");

  var encodedUri = encodeURI(csvContent);
  window.open(encodedUri);
}
