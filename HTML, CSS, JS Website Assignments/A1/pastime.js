/*
  author:  Jawadur Rahman (A00434830)

  The purpose of this file is to provide the following behaviours:
  - initially hide the pictures (setup)
  - show or hide "running" picture on demand (showOrHidePictureOne)
  - show or hide "reading" picture on demand (showOrHidePictureTwo)
  - show or hide "chatting" picture on demand (showOrHidePictureThree)
*/

// constant to represent the hidden characteristic
const HIDDEN = "hidden";
// constant to represent the visible characteristic
const VISIBLE = "visible";

/*
  The purpose of this function is to hide all three images
  when the page loads
*/
function setup() {
  document.getElementById("running").style.visibility = "hidden";
  document.getElementById("reading").style.visibility = "hidden";
  document.getElementById("chatting").style.visibility = "hidden";
}

/*
  The purpose of this function is to make the image "running" visible
  or hidden on demand
*/
function showOrHidePictureOne() {
  if (document.getElementById("running").style.visibility == VISIBLE) {
    document.getElementById("running").style.visibility = HIDDEN;
  } else {
    document.getElementById("running").style.visibility = VISIBLE;
  }
}

/*
  The purpose of this function is to make the image "reading" visible
  or hidden on demand
*/
function showOrHidePictureTwo() {
  if (document.getElementById("reading").style.visibility == VISIBLE) {
    document.getElementById("reading").style.visibility = HIDDEN;
  } else {
    document.getElementById("reading").style.visibility = VISIBLE;
  }
}

/*
  The purpose of this function is to make the image "chatting" visible
  or hidden on demand
*/
function showOrHidePictureThree() {
  if (document.getElementById("chatting").style.visibility == VISIBLE) {
    document.getElementById("chatting").style.visibility = HIDDEN;
  } else {
    document.getElementById("chatting").style.visibility = VISIBLE;
  }
}
