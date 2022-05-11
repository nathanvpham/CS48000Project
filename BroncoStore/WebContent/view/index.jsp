<%@page import="model.dataccess.*"%>
<%@page import="model.entities.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	List<Product> products = null;
    
 %>
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
			<a class="navbar-brand" href="${pageContext.request.contextPath}/view/index.jsp">Bronco Store</a>
		
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<form class="form-inline">
						<input id="form1" class = "navbar-nav ml-auto form-control" type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/view/index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/view/account.jsp">Account</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/view/orders.jsp">Orders</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/view/cart.jsp">Cart</a></li>
				</ul>
			</div>
		</div>
	</nav>
<body>
	<div class="container">
		<div class="card-header my-3">All Products</div>
			<div id="products">
				<div class="row">
					<div class="card" style="width: 20rem;">
						<div class="card-body">
							<h5 class="card-title">Product</h5>
							<p class="price">Price: $10</p>
							<div class="text-center">
								<a class="btn btn-primary" href="#">Add to Cart</a> 
							</div>
						</div>
					</div>
				<%
				if (products != null) {
					for (Product p : products) {
				%> 
					<div class="card" style="width: 20rem;">
						<div class="card-body">
							<h5 class="card-title"><%=p.getName() %></h5>
							<p class="price">Price: $<%=p.getCurrentPrice() %></p>
							<div class="text-center">
								<a class="btn btn-primary" href="#">Add to Cart</a> 
							</div>
						</div>
					</div>
				<%
				}
				} else {
				out.println();
				}
				%>
				</div>
			</div>
	</div>
<body>

</body>
</html>