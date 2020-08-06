<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<jsp:include page="css.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="header.jsp" />

	<!-- tabs & register form Start -->
	<div class="basic-form-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="sparkline8-list mt-b-30">
						<div class="sparkline8-hd">
							<div class="main-sparkline8-hd"></div>
						</div>
						<div class="sparkline8-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
										<div class="basic-login-inner">

											<h2>Register Admin</h2>
											<form action="RegisterController" method="post">
												<div class="form-group-inner">
													<label>Full Name</label><br>
													<font color="grey" size="2">Please enter your first name(This will appear on your submission)</font>
													 <input type="text"
														class="form-control" name="UserName"
														placeholder="Enter Full Name" required />
												</div>
												<div class="form-group-inner">
													<label>Phone Number</label>
													<br>
													<font color="grey" size="2">Please enter the phone number to display on your submission</font> <input type="text"
														class="form-control" name="UserNoPhone"
														placeholder="Phone Number" required />
												</div>
												<div class="form-group-inner">
													<label>Email</label>
													<br>
													<font color="grey" size="2">Please enter your email(This will appear on your submission)</font> <input type="email"
														class="form-control" name="UserEmail"
														placeholder="Enter Email" required />
												</div>
												<div class="form-group-inner">
													<label>Password</label>
													<br>
													<font color="grey" size="2">Please use a unique password</font> <input type="password"
														class="form-control" name="UserPassword"
														id="myInputRegister" placeholder="password" required />
												</div>

												<div class="login-btn-inner">
													<div class="inline-remember-me">
														<button
															class="btn btn-sm btn-primary pull-right login-submit-cs"
															type="submit" name="action" value="registerAdmin">
															<b>Register</b>
														</button>
														<label> <input type="checkbox"
															onClick="showPWRegister()"> Show Password
														</label>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
			</div>
		</div>
	</div>
	<!-- tabs & Register form End-->


	<!-- JS -->
	<jsp:include page="js.jsp"></jsp:include>

</body>

</html>