<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<!-- <link rel="stylesheet" href="styles/style.css"/> -->
<title>Bronco Store</title>
</head>
    <!--Navigation Bar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
	    <div class="container">
			<a class="navbar-brand" href="index.jsp">Bronco Store</a>
		
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<form class="form-inline">
						<input id="form1" class = "navbar-nav ml-auto form-control" type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="account.jsp">Account</a></li>
					<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
					<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
				</ul>
			</div>
		</div>
	</nav>
<body>
	<div class="container">
		<div class="card-header my-3">Specfic Item</div>
		<div class="row">
			<div class="card" style="width: 20rem;">
				<img class="card-img-top" src="..." alt="Picture">
				<div class="card-body">
					    <h5 class="name">Specfic Item</h5>
					    <p class="price">Price: $10</p>
					    <div class="text-center">
					    	<a href="#" class="btn btn-primary">Add to Cart</a>
					    </div>
				 </div>
			</div>

		</div>
	</div>
<body>

</body>
</html>