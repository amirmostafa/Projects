<!DOCTYPE html>
<html>
<head>
<style>
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
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
}

li {
    float: left;
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

li a.active {
    color: white;
    background-color: #4CAF50;
}
.events{
  width:70%;
  background:#f4f4f4;
  height:400px;
  margin:20px auto;
  overflow:auto;
}

.event{
  list-style:none;
  padding:8px;
  border-bottom: 1px #cccccc dotted;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("a").click(function(){
        var text = $(this).html();
        if (text=="Today"){
            //query to fetch daily events	
        }
        else if (text=="Weekly"){
            //query to fetch weekly events
        }
 });
});
</script>
</head>
<body>
<header>
    <img class="img1" src="helicopter.jpg" alt="helicpter" />
    <h1> Social Calendar </h1>
    <img class="img2" src="logo.png" alt="logo" />
</header>
<ul>
  <li><a href="#daily">Today</a></li>
  <li><a href="#weekly">Weekly</a></li>
</ul>
<div class="events">
<?php 
for ($x = 0; $x <= 3; $x++) {  //loop on the query to fetch rows.?>
  <div class="event">
    <h3><?php echo 'event: pool party'?> </h3><h3><?php echo 'time: '.$x ?> </h3> <h3><?php echo 'place: villa #30 airport road' ?></h3>
  </div>
<?php } ?>
</div>
</body>
</html>