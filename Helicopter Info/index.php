<!DOCTYPE html>
<html>
<head>
<style>
.dropbtn {
	text-decoration:none;
    font-size: 16px;
    border: none;
    cursor: pointer;
	
}

.dropdown {
	width:100%;
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 200px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
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

ul {
    list-style-type: none;
    margin-top: 10px;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
}

.ul{
    width: 200px;
    margin-left: 40px;
}
.ul2{
    width: 200px;
    margin-left: 1100px;	
	margin-top:-370px;
}
#li {
    float: left;
    width: 25%;
}

#li2 {
float : left;
width:50%;
}

li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #ddd;
}


#content{
	width:55%;
	background:#f4f4f4;
	height:400px;
	margin:20px auto;
	margin-top:-370px;
	overflow:auto;
}

#content2{
	width:55%;
	background:#f4f4f4;
	height:400px;
	margin:20px auto;
	margin-top:-370px;
	overflow:auto;
}

#content3{
	width:55%;
	background:#f4f4f4;
	height:550px;
	margin:20px auto;
	margin-top:-370px;
	overflow:auto;
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

.topbtn1 {
	text-decoration:none;
    background-color: #f4f4f4;
    color: black;
    padding: 16px;
    font-size: 16px;
    border: 1px solid #bfbfbf	;
    cursor: pointer;
	margin-left:95px;
}

.topbtn2 {
	text-decoration:none;
    background-color: #f4f4f4;
    color: black;
    padding: 16px;
    font-size: 16px;
    border: 1px solid #bfbfbf	;
    cursor: pointer;
	margin-left:980px;
}

.event{
  list-style:none;
  padding:8px;
  border-bottom: 1px #cccccc dotted;
}
label{
	
	display: inline-block;
	width:110px;
}

.day{
	padding:8px;
	border-bottom: 1px #cccccc dotted;
}

.week{
	padding:8px;
	border-bottom: 1px #cccccc dotted;
}
.dis{
	display:none;
}
.cal{
	width:100%;
	display:inline-block;
}

.mySlides {
	display:none;	
	width:95%;
	height:400px;
	margin-left:12px;
	border: 1px solid #00000;
    border-radius: 4px;
}

.demo{
	width:100%;
}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>


$(document).ready(function(){
	$(".cal").click(function(){
        var text = $(this).html();
        if (text=="Today"||text==""){
            $(".day").show();
			$(".week").hide();
			$(".day").removeClass('dis');
        }
        else if (text=="Weekly"){
            $(".week").show();
			$(".day").hide();
			$(".week").removeClass('dis');
        }
 });
    $(".menu").click(function(){
        var text = $(this).html();
		if (text!="Social Calender" && text!="Gallery" ){
			$("#content2").addClass('dis');
			$("#content3").addClass('dis');
			$("#content").removeClass('dis');
		}
		if (text=="History"){															//<--- Menu Action
			document.getElementById("content").innerHTML=" - write content here !!";    //<--- write what you want when click on history.
		}
		else if (text=="Roles"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Roles"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Operations/Exercise"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Achievements"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Gallery"){
			$("#content").addClass('dis');
			$("#content2").addClass('dis');
			$("#content3").removeClass('dis');
		}
		else if (text=="Joining Instructions"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Martyrs"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="FAV Links"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Mausam Online"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Innovations"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Social Calender"){
			$("#content3").addClass('dis');
			$("#content").addClass('dis');
			$("#content2").removeClass('dis');
			$(".dd").removeClass('dis');
			$(".day").show();
			$(".week").hide();
			$(".day").removeClass('dis');
		}
		else if (text=="Know Your City"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="URO"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
		else if (text=="Knowledge Corner"){
			document.getElementById("content").innerHTML="- write content here !!";
		}
    });
});
</script>
</head>
<body >

<header>
    <img class="img1" src="helicopter.jpg" alt="helicpter" />
	<h1> 157 HELICOPTER UNIT <br><br>
    tashkrya
    </h1>
    <img class="img2" src="logo.png" alt="logo" />
</header>
<ul>
  <li id="li"><a href="#home"><Strong>Home</Strong></a></li>
  <li id="li"><a href="#Operations"><Strong>Operations</Strong></a></li>
  <li id="li"><a href="#Maitenance"><Strong>Maitenance</Strong></a></li>
  <li id="li"><a href="#Adminstraion"><Strong>Adminstraion</Strong></a></li>
</ul>

<ul class="ul">
  <li><a class="menu" href="#history">History</a></li>
  <li><div class="dropdown">                    <!-- DROPDOWN SUBMENU EXAMPLE -->
  <a href="#roles" class="dropbtn menu">Roles</a>
  <div class="dropdown-content">
    <a href="#">role 1</a>
    <a href="#">role 2</a>
    <a href="#">role 3</a>
  </div>
</div></li>
  <li><a class="menu" href="#operations/exercise">Operations/Exercise</a></li>
  <li><a class="menu" href="#achievements">Achievements</a></li>
  <li><a class="menu" href="#">Gallery</a></li>
  <li><a class="menu" href="#joining instructions">Joining Instructions</a></li>
  <li><a class="menu" href="#martyrs">Martyrs</a></li>
</ul>

<ul class="ul2">                                 <!-- DROPDOWN SUBMENU EXAMPLE -->
  <li><div class="dropdown">
  <a href="#" class="dropbtn menu">FAV Links</a>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div></li>
  <li><a class="menu" href="#">Mausam Online</a></li>
  <li><a class="menu" href="#">Innovations</a></li>
  <li><a class="menu" href="#">Social Calender</a></li>
  <li><a class="menu" href="#">Know Your City</a></li>
  <li><a class="menu" href="#">URO</a></li>
  <li><a class="menu" href="#">Knowledge Corner</a></li>
</ul>

<div id="content"></div>
<div id="content2">
	<ul class="dd dis">
	  <li id="li2"><a href="#daily" class="cal">Today</a></li>
	  <li id="li2"><a href="#weekly" class="cal">Weekly</a></li>
	</ul>
	<!-- for Daily -->														<!-- SOCIAL MEDIA CALENDER -->
	<div class="dis day" id="events">
	  <b><label>Event Name </label>:</b> eventus
				 <br><b><label>place</label>:</b>   banana square
				 <br><b><label>Time</label>:</b>   8PM.
	</div>

	<div class="dis day" id="events">
	  <b><label>Event Name </label>:</b> eventus#2
				 <br><b><label>place</label>:</b>   apple square
				 <br><b><label>Time</label>:</b>   10PM.
	</div>

	<!--  --------- -->

	<!-- for Weekly -->
	<div class="dis week" id="events">
				 <b><label>Day </label>:</b>Sunday
				 <br><b><label>Event Name </label>:</b> eventCenter
				 <br><b><label>place</label>:</b>   orange square
				 <br><b><label>Time</label>:</b>   8PM.
				 
	</div>

	<div class="dis week" id="events">
				 <b><label>Day </label>:</b> Monday
				 <br><b><label>Event Name </label>:</b> eventCenter#2
				 <br><b><label>place</label>:</b>   nuts square
				 <br><b><label>Time</label>:</b>   8PM.
	</div>
</div>	
<div id="content3" class="dis">
	<div class="w3-content " style="max-width:100%">
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
		
	  </div>
	</div>	
</div>
<a href class="topbtn1">Go Top</a>
<a href class="topbtn2">Go Top</a>
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