<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<!-- CSS -->
<jsp:include page="css.jsp"></jsp:include>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- Latest Found Post start-->
	<br>

	<center>
		<h1>Latest Found Post</h1>
	</center>
	<div class="courses-area">
		<div class="container-fluid">
			<div class="row">
				<!-- COUT looping START DARI SINI -->
				<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
					<div class="courses-inner res-mg-b-30">
						<div class="courses-title">
							<a href="#"><img src="img/courses/1.jpg" alt=""></a>
							<h2>Apps Development</h2>
						</div>
						<div class="courses-alaltic">
							<span class="cr-ic-r"><span class="course-icon"><i
									class="fa fa-clock"></i></span> 1 Year</span> <span class="cr-ic-r"><span
								class="course-icon"><i class="fa fa-heart"></i></span> 50</span> <span
								class="cr-ic-r"><span class="course-icon"><i
									class="fa fa-dollar"></i></span> 500</span>
						</div>
						<div class="course-des">
							<p>
								<span><i class="fa fa-clock"></i></span> <b>Duration:</b> 6
								Months
							</p>
							<p>
								<span><i class="fa fa-clock"></i></span> <b>Professor:</b> Jane
								Doe
							</p>
							<p>
								<span><i class="fa fa-clock"></i></span> <b>Students:</b> 100+
							</p>
						</div>
						<div class="product-buttons">
							<button type="button" class="button-default cart-btn">Read
								More</button>
						</div>
					</div>
				</div>
				<!-- COUT looping END KAT SINI -->
			</div>
		</div>
	</div>

	<!-- Latest Found Post End-->
	<!-- Latest lost Post start-->
	<br>

	<center>
		<h1>Latest Lost Post</h1>
	</center>
	<div class="courses-area">
		<div class="container-fluid">
			<div class="row">
				<!-- COUT START DARI SINI -->
				<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
					<div class="courses-inner res-mg-b-30">
						<div class="courses-title">
							<a href="#"><img src="img/courses/1.jpg" alt=""></a>
							<h2>Apps Development</h2>
						</div>
						<div class="courses-alaltic">
							<span class="cr-ic-r"><span class="course-icon"><i
									class="fa fa-clock"></i></span> 1 Year</span> <span class="cr-ic-r"><span
								class="course-icon"><i class="fa fa-heart"></i></span> 50</span> <span
								class="cr-ic-r"><span class="course-icon"><i
									class="fa fa-dollar"></i></span> 500</span>
						</div>
						<div class="course-des">
							<p>
								<span><i class="fa fa-clock"></i></span> <b>Duration:</b> 6
								Months
							</p>
							<p>
								<span><i class="fa fa-clock"></i></span> <b>Professor:</b> Jane
								Doe
							</p>
							<p>
								<span><i class="fa fa-clock"></i></span> <b>Students:</b> 100+
							</p>
						</div>
						<div class="product-buttons">
							<button type="button" class="button-default cart-btn">Read
								More</button>
						</div>
					</div>
				</div>
				<!-- COUT END KAT SINI -->
			</div>
		</div>
	</div>

	<!-- Latest lost Post End-->
	


	<!-- Footer -->
	<br>
	<br>
	</div>

	<!-- JS -->
	<jsp:include page="js.jsp" />
</body>

</html>