<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie</title>
<link rel="stylesheet" href="https://bootswatch.com/4/cyborg/bootstrap.min.css">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style type="text/css">
.remove-item{
  display:block;
}
.items{
padding: 10px;
}
</style>
</head>
<body>
    <div class="container">
      <div class= "jumbotron">
       <h3 class ="text-center">Search for any Movie</h3>
        <input type="text" id ="searchText" placeholder="Enter The Movie Name" class="form-control">
        <button onclick="myFunction()" class="form-control">Search</button>
      </div>
    </div>
    <div class="container-fluid"> 
    <div class="row" id="output">
    </div>
    </div>
 
    <button id="submit">ADD To Cart</button>
    <div class="container-fluid">
    <div class="row" id="row1"></div>
    <div class="row" id = "mydiv"></div>
    </div>
    <button id ="but" onclick="action1()">SMovies</button>
    <div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
    <script src="main.js">
    </script>          
</body>
</html>