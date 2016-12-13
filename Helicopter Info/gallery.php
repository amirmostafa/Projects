<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<style>
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

header h1{
	position:absolute;
    color:#ffffff;
    font-size:30px;
	text-align:center;
	left:500px;
	margin-top:-130px;
    padding-bottom:15px;

}
header {
    background-color:   #009999;
    padding-top:30px;
    border-bottom:1px solid #f4f4f4;
}
.img1{
	margin-left:40px;
    width: 200px;
    height: 150px;
}
.img2{
    margin-left: 1100px;    
    margin-top:-360px;
	margin-bottom:20px;
    width: 200px;
    height: 150px;
}
.btn{
	text-decoration:none;
    background-color: #f4f4f4;
    color: black;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #bfbfbf	;
    cursor: pointer;
	margin-left:630px;
	margin-bottom:10px;
}
</style>
<body style="background-color:#ccffff">
<header>
    <img class="img1" src="helicopter.jpg" alt="helicpter" />
	<h1><b> 157 HELICOPTER UNIT <br><br>
    tashkrya
    </b></h1>
    <img class="img2" src="logo.png" alt="logo" />
</header>

<div class="w3-container">
</div>

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
<a href="index.php" class="btn">Homepage</a>
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

</body>
</html>

