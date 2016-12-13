<?php include 'database.php';
$query="Select * from shouts";
$shouts=mysqli_query($con,$query);
?>
<html>
	<head>
		<title> Shout It! </title>
		<link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>
	
	<body>
		<div id="container">
			<header>
				<h1> SHOUT IT ! shoutBox </h1>
			</header>
			
			<div id ="shouts">
				<ul>
					<?php while ($row=mysqli_fetch_array($shouts)) : ?>
						<li class="shout"> <span><?php echo $row['time'] ?> - </span><strong> <?php echo $row['user'].' : '?></strong> <?php echo $row['message']?> </li>
					<?php endwhile; ?>
				</ul>
			</div>
		
		
			<div id="input">
				<?php if(isset($_GET['error'])) : ?>
					<div class="error"> <?php echo $_GET['error']; ?> </div>
				<?php endif; ?>
				
				<form method="POST" action="process.php">
					<input type="text" name="user" placeholder="Enter your name " />
					<input type="text" name="message" placeholder="Enter A message " />
					</br> 
					<input class="shout-btn" type="submit" name="submit" value="Shout It Out" />
				</form>
			</div>
		</div>
	</body>
</html>