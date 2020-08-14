<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();// or page Context
%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>Live Dinner Restaurant - Responsive HTML5 Template</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="<%=contextPath%>/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="<%=contextPath%>/images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<%=contextPath%>/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="<%=contextPath%>/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="<%=contextPath%>/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="<%=contextPath%>/css/custom.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- <style>
section .content {
	padding: 160px 90px;
}
</style> -->

</head>
<body>
	<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="index.html"> <img
					src="<%=contextPath%>/images/logo.png" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbars-rs-food" aria-controls="navbars-rs-food"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-rs-food">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="index.html">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="menu">Menu</a></li>
						<li class="nav-item"><a class="nav-link" href="about.html">About</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown-a"
							data-toggle="dropdown">Pages</a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<a class="dropdown-item" href="reservation.html">Reservation</a>
								<a class="dropdown-item" href="stuff.html">Stuff</a> <a
									class="dropdown-item" href="gallery.html">Gallery</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown-a"
							data-toggle="dropdown">Blog</a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<a class="dropdown-item" href="blog.html">blog</a> <a
									class="dropdown-item" href="blog-details.html">blog Single</a>
							</div></li>
						<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End header -->



	<section>
		<div class="content">
			<!-- <form action="" method="post"> way 1 . refres page come to method post  -->
			<form enctype="multipart/form-data" action="<%=contextPath %>/menu/add" method="post">
				<!-- input ctgid   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Category</label> 
					<input name="ctgid" type="text" class="form-control" placeholder="Enter menu name">
				</div>
				<!-- input muname   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Menu Name</label> 
					<input name="muname" type="text" class="form-control" placeholder="Enter menu name">
				</div>
				<!-- input intro   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Intro</label> 
					<input name="intro" type="text" class="form-control" placeholder="Enter intro">
				</div>
				<!-- input details   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Details</label> 
					<input name="details" type="text" class="form-control" placeholder="Enter details">
				</div>
				<!-- input details   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Price</label> 
					<input name="price" type="text" class="form-control" placeholder="Enter price">
				</div>
				<!-- input details   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Currency</label> 
					<input name="currency" type="text" class="form-control" placeholder="Enter currency">
				</div>
				<!-- input intro   -->
				<div class="form-group">
					<label class="text-uppercase font-weight-bold" >Image</label> 
					<input name="up_photo" type="file" class="form-control">
				</div>
				<!-- button submit   -->
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>

	</section>



	<!-- Start Footer -->
	<footer class="footer-area bg-f">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<h3>About Us</h3>
					<p>Integer cursus scelerisque ipsum id efficitur. Donec a dui
						fringilla, gravida lorem ac, semper magna. Aenean rhoncus ac
						lectus a interdum. Vivamus semper posuere dui.</p>
				</div>
				<div class="col-lg-3 col-md-6">
					<h3>Subscribe</h3>
					<div class="subscribe_form">
						<form class="subscribe_form">
							<input name="EMAIL" id="subs-email" class="form_input"
								placeholder="Email Address..." type="email">
							<button type="submit" class="submit">SUBSCRIBE</button>
							<div class="clearfix"></div>
						</form>
					</div>
					<ul class="list-inline f-social">
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-twitter" aria-hidden="true"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-linkedin" aria-hidden="true"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-google-plus" aria-hidden="true"></i></a></li>
						<li class="list-inline-item"><a href="#"><i
								class="fa fa-instagram" aria-hidden="true"></i></a></li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-6">
					<h3>Contact information</h3>
					<p class="lead">Ipsum Street, Lorem Tower, MO, Columbia, 508000</p>
					<p class="lead">
						<a href="#">+01 2000 800 9999</a>
					</p>
					<p>
						<a href="#"> info@admin.com</a>
					</p>
				</div>
				<div class="col-lg-3 col-md-6">
					<h3>Opening hours</h3>
					<p>
						<span class="text-color">Monday: </span>Closed
					</p>
					<p>
						<span class="text-color">Tue-Wed :</span> 9:Am - 10PM
					</p>
					<p>
						<span class="text-color">Thu-Fri :</span> 9:Am - 10PM
					</p>
					<p>
						<span class="text-color">Sat-Sun :</span> 5:PM - 10PM
					</p>
				</div>
			</div>
		</div>

		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<p class="company-name">
							All Rights Reserved. &copy; 2018 <a href="#">Live Dinner
								Restaurant</a> Design By : <a href="https://html.design/">html
								design</a>
						</p>
					</div>
				</div>
			</div>
		</div>

	</footer>
	<!-- End Footer -->
</body>
<!-- ALL JS FILES -->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- ALL PLUGINS -->
<script src="js/jquery.superslides.min.js"></script>
<script src="js/images-loded.min.js"></script>
<script src="js/isotope.min.js"></script>
<script src="js/baguetteBox.min.js"></script>
<script src="js/form-validator.min.js"></script>
<script src="js/contact-form-script.js"></script>
<script src="js/custom.js"></script>
</html>
