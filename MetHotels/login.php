<?php
	session_start();

	//Conect to database
	$db = mysqli_connect("localhost","root","","authentication");

	if(isset($_POST['login_btn'])){

		
		$username = mysqli_real_escape_string($db,$_POST['username']);
		$password = mysqli_real_escape_string($db,$_POST['password']);
		
		$password = md5($password);
		$sql = "SELECT * FROM korisnici WHERE username = '$username' AND password = '$password'";
		$result = mysqli_query($db,$sql);

		if(mysqli_num_rows($result) == 1){

			$_SESSION['message'] = "You are now logged in";
			$_SESSION['username'] = $username;
			header("location: homeAuthorized.php");

		}else{

			$_SESSION['message'] = "Username/password combination incorrect";
		}
		


	}

?>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>MetHotels</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>

    .lorem-ipsum h1 {
        margin-left: 450px;
    }

    </style>
<body>

<nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">MetHotels</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">

          <ul class="nav navbar-nav navbar-right">
            <li><a href="home.php">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>



    <div class = 'lorem-ipsum'>
        <h1> Sistem za upravljanje hotelima </h1>
    </div>

   <form method="post" action="login.php" role="form">
    <div class="alert alert-danger" style="display: none;">

    </div>
   <div class="form-group">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" class="form-control"  name='username'>
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" name='password'>
      </div>
    </div>
    <input type="submit" name="login_btn" value="Login">
  </form>

    </body>
</html>
