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
          <a class="navbar-brand" [routerLink]="['/home']">MetHotels</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">

          <ul class="nav navbar-nav navbar-right">
            <li [routerLinkActive]="['active']"><a [routerLink]="['/home']">Home</a></li>
            <li [routerLinkActive]="['active']"><a [routerLink]="['/add']">Add Hotel</a></li>
            <li [routerLinkActive]="['active']"><a [routerLink]="['/login']">Login</a></li>
            <li [routerLinkActive]="['active']"><a [routerLink]="['/register']">Register</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class = 'lorem-ipsum'>
        <h1> Sistem za upravljanje hotelima </h1>
    </div>

    </body>
</html>