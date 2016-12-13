<!DOCTYPE html>
<html>
<head>
<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
.mySlides {
	display:none;	
	width:80%;
	height:500px;
	padding-top:10px;
	margin-left:120px;
	border: 1px solid #00000;
    border-radius: 4px;
}

.demo{
	width:100%;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-border-red", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-border-red";
}
</script>
</head>
<body>

<h2>Modal Example</h2>

<!-- Trigger/Open The Modal -->
<button id="myBtn">Open Modal</button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">×</span>
<div class="w3-content" style="max-width:1200px">
  <img class="mySlides" src="Chrysanthemum.jpg" > <!-- the pictures you want to add must be added here in class myslides and added down in class demo also-->
  <img class="mySlides" src="Hydrangeas.jpg" >
  <img class="mySlides" src="Desert.jpg" >
  <div class="w3-row-padding w3-section">
    <div class="w3-col s2">
      <img class="demo w3-border w3-hover-shadow" src="Chrysanthemum.jpg"  onclick="currentDiv(1)">
    </div>
    <div class="w3-col s2">
      <img class="demo w3-border w3-hover-shadow" src="Hydrangeas.jpg"  onclick="currentDiv(2)">
    </div>
    <div class="w3-col s2">
      <img class="demo w3-border w3-hover-shadow" src="Desert.jpg"  onclick="currentDiv(3)">
    </div>
	
	<a class="w3-btn-floating" style="position:absolute;top:67%;left:155px" onclick="plusDivs(-1)"><</a>
<a class="w3-btn-floating" style="position:absolute;top:67%;right:155px" onclick="plusDivs(1)">></a>
  </div>
</div>
</div>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>

