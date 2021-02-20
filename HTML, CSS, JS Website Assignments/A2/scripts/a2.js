/*
  author:  Jawadur Rahman (A00434830)

  The purpose of this file is to provide the following behaviours:
  - initially draw and hide the canvases (setup)
  - show and/or hide canvases depending on option (showImages)
  - draws the plan canvas (doPlan)
  - draws the elevation canvas (doElevation)
*/

// constant to represent the clear both canvas option
const CLEAR = "Clear";
// constant to represent the show elevation canvas only option
const SHOW_ELEVATION = "Show Elevation";
// constant to represent the show plan canvas only option
const SHOW_PLAN = "Show Plan";
// constant to represent the show both canvases option
const SHOW_BOTH = "Show Both";

/*
  The purpose of this function is to hide all canvases
  when the page loads and call the funtions that draw the canvases
*/
function setup() {
  document.getElementById("elevation").style.visibility = "hidden";
  document.getElementById("plan").style.visibility = "hidden";

  let drawBoxesObj = document.getElementById("windowPlan");
  let drawBoxesCon = drawBoxesObj.getContext("2d");

  let drawBoxesObjTwo = document.getElementById("elevation");
  let drawBoxesConTwo = drawBoxesObjTwo.getContext("2d");

  doPlan(drawBoxesObj, drawBoxesCon);
  doElevation(drawBoxesObjTwo, drawBoxesConTwo);
}

/*
  The purpose of this function is to show and/or hide canvases
  depending on the option
*/
function showImages() {
  let choice = $("#images").find(":selected").text();

  if (choice === CLEAR) {
    document.getElementById("elevation").style.visibility = "hidden";
    document.getElementById("plan").style.visibility = "hidden";
  } else if (choice === SHOW_ELEVATION) {
    document.getElementById("elevation").style.visibility = "visible";
    document.getElementById("plan").style.visibility = "hidden";
  } else if (choice === SHOW_PLAN) {
    document.getElementById("elevation").style.visibility = "hidden";
    document.getElementById("plan").style.visibility = "visible";
  } else if (choice === SHOW_BOTH) {
    document.getElementById("elevation").style.visibility = "visible";
    document.getElementById("plan").style.visibility = "visible";
  } else {
    //because formatting extentsion is messing up html if tabwidth 4
    document.getElementById("elevation").style.visibility = "visible";
    document.getElementById("plan").style.visibility = "hidden";
  }
}

/*
  The purpose of this function is to draw the plan canvas
*/
function doPlan(obj, context) {
  context.clearRect(0, 0, obj.width, obj.height);

  // filled box
  context.fillStyle = "white";
  context.fillRect(0, 0, obj.width, obj.height);

  context.strokeStyle = "black";
  context.lineWidth = 5;
  // draw a box
  context.beginPath();
  context.rect(10, 15, 400, 75);
  context.stroke();

  context.lineWidth = 1;
  // draw a box
  context.beginPath();
  context.rect(9, 90, 402, 50);
  context.stroke();

  // set line colour to blue
  context.strokeStyle = "#97dbf2";
  context.lineWidth = 7;
  // draw blue lines
  context.beginPath();
  context.moveTo(148, 15);
  context.lineTo(195, 15);
  context.stroke();

  context.beginPath();
  context.moveTo(240, 15);
  context.lineTo(310, 15);
  context.stroke();

  context.beginPath();
  context.moveTo(383, 15);
  context.lineTo(405, 15);
  context.stroke();

  context.beginPath();
  context.moveTo(272, 90);
  context.lineTo(222, 90);
  context.stroke();

  context.beginPath();
  context.moveTo(110, 90);
  context.lineTo(60, 90);
  context.stroke();
}

/*
  The purpose of this function is to draw the elevation canvas
*/
function doElevation(obj, context) {
  context.clearRect(0, 0, obj.width, obj.height);

  // filled box
  context.fillStyle = "white";
  context.fillRect(0, 0, obj.width, obj.height);

  context.fillStyle = "#8a5543";
  context.fillRect(20, 20, 409, 80);

  context.fillStyle = "black";
  context.fillRect(20, 99, 409, 41);

  context.fillStyle = "#6c7592";
  context.fillRect(20, 20, 310, 70);

  context.fillStyle = "#f3d181";
  context.fillRect(70, 30, 50, 60);

  context.fillStyle = "#f3d181";
  context.fillRect(225, 30, 50, 60);
}
