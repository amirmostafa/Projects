<?php

$con=mysqli_connect("localhost","root","1234","shoutit");

if(!$con){
	echo 'Failed to Connect : '.mysqli_connect_error();
}
