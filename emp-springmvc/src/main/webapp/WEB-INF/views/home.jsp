<% int userId = (Integer)(request.getAttribute("userId")); %>

<html lang="en">
<head>
<title>Employee Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a href="/emp/profile"> <img alt="profile" src="profile.png"
					width="30px" height="30px"></a>
					Welcome  to the Website{{userId}}
			</div>

			<div class="col-md-3 form-group pr-0">
				<form action="/emp/search">
					<input type="text" class="form-control" id="empId" name="empId"
						placeholder="search here...">
			</div>
			
			<div class="col-md-3 pl-0">
				<button type="submit" class="btn btn-primary">Submit</button>
				</form>

			</div>
			<div class="col-md-3">
				<a href="/emp/logout">logout</a>
			</div>
		</div>
	</div>
</body>