<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<jsp:include page="css.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="header.jsp" />
	<!-- Static Table Start -->
	<div class="data-table-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="widget-program-box mg-tb-30">
					<div class="container-fluid">
						<div class="row">
							<div class="widget-program-bg">
								<div class="container-fluid">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<center>
												<img src="img/image01.png" width="700" />
											</center>
										</div>
										<div class="col-lg-2 col-md-6 col-sm-6 col-xs-12"></div>
										<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
											<div
												class="hpanel shadow-inner hbgblue bg-2 responsive-mg-b-30">
												<div class="panel-body">
													<div class="text-center content-bg-pro">
														<h3>SEARCH LOST ITEM</h3>
														<small> Here you can search all registered lost
															items </small>
													</div>
												</div>
											</div>
											<div class="hpanel widget-int-shape responsive-mg-b-30">
												<div class="panel-body">
													<div class="text-center content-box">
														<div class="m icon-box">
															<img class="main-logo" src="img/kanta.png" width="50"
																alt="" />
														</div>
														<p class="small mg-t-box">
															We are very sorry that you have lost your item. There is
															a good chance that your object has been found and
															hopefully you will find it back via this website. Click
															view more to view <strong>registered lost item.</strong>
														</p>
														<a class="btn btn-info widget-btn-2 btn-sm"
															href="/lofo/LostController?action=listAll"><font
															color="white"> LOST ITEM </font></a>

													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
											<div
												class="hpanel shadow-inner hbgblue bg-2 responsive-mg-b-30">
												<div class="panel-body">
													<div class="text-center content-bg-pro">
														<h3>SEARCH FOUND ITEM</h3>
														<small> Here you can search all registered found
															items</small>
													</div>
												</div>
											</div>
											<div class="hpanel widget-int-shape responsive-mg-b-30">
												<div class="panel-body">
													<div class="text-center content-box">
														<div class="m icon-box">
															<img class="main-logo" src="img/kanta.png" width="50"
																alt="" />
														</div>
														<p class="small mg-t-box">
															How nice that you have found an item and want to place it
															on this website. Here you will find all the information
															about registered items on this website and reporter
															contact information.Click view more to view <strong>registered
																found item.</strong>
														</p>
														<a class="btn btn-info widget-btn-2 btn-sm"
															href="/lofo/FoundController?action=listAll"><font
															color="white">FOUND ITEM</font></a>

													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-2 col-md-6 col-sm-6 col-xs-12"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- Static Table End -->

	<jsp:include page="js.jsp"></jsp:include>
</body>

</html>