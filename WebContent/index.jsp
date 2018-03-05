<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie</title>
<link rel="stylesheet" href="https://bootswatch.com/4/cyborg/bootstrap.min.css">
</head>
<body>
    <div class="container">
      <div class= "jumbotron">
       <h3 class ="text-center">Search for any Movie</h3>
        <input type="text" id ="searchText" placeholder="Enter The Movie Name" class="form-control">
        <button onclick="myFunction()" class="form-control">Search</button>
      </div>
    </div>
    <div id="output"></div>
    <div id="count">Total Movies are </div>
    <button id="submit">ADD To Cart</button>
    <div id="mydiv"></div>
    <button onclick="action1()">SMovies</button>
    <div>
    <input type="text" id="remove" name="location">
    <button onclick="remove()">Remove</button>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
    <script src="main.js">

    </script>          
</body>
</html>