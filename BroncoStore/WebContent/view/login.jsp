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
<title>Bronco Store</title>
</head>
<body>
<script type="text/javascript">
    document.getElementById("submit").onclick = function () {
        location.href = "view/index.jsp";
    };
</script>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Log in to Cal Poly Pomona</div>
			<div class="card-body">
				<%--<form action="user-login" method="post">--%>
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="login-email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<a href="view/index.jsp"><button id="submit" class="btn btn-primary">Login</button></a>
					</div>
				<%--</form>--%>
			</div>
		</div>
	</div>

</body>
	
</html>