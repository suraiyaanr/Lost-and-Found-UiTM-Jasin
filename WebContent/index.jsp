<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<!-- CSS -->
<jsp:include page="css.jsp"></jsp:include>
<style type="text/css">
.blink {
	animation: blinker 0.6s linear infinite;
	color: #1c87c9;
	font-size: 20px;
	font-weight: bold;
	font-family: sans-serif;
}

@
keyframes blinker { 50% {
	opacity: 0;
}

}
.blink-one {
	animation: blinker-one 1s linear infinite;
}

@
keyframes blinker-one { 0% {
	opacity: 0;
}

}
.blink-two {
	animation: blinker-two 1.4s linear infinite;
}

@
keyframes blinker-two { 100% {
	opacity: 0;
}

}
.img-replace {
	/* replace text with an image */
	display: inline-block;
	overflow: hidden;
	text-indent: 100%;
	color: transparent;
	white-space: nowrap;
}

.bts-popup {
	position: fixed;
	left: 0;
	top: 0;
	height: 100%;
	width: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	opacity: 0;
	visibility: hidden;
	-webkit-transition: opacity 0.3s 0s, visibility 0s 0.3s;
	-moz-transition: opacity 0.3s 0s, visibility 0s 0.3s;
	transition: opacity 0.3s 0s, visibility 0s 0.3s;
}

.bts-popup.is-visible {
	opacity: 1;
	visibility: visible;
	-webkit-transition: opacity 0.3s 0s, visibility 0s 0s;
	-moz-transition: opacity 0.3s 0s, visibility 0s 0s;
	transition: opacity 0.3s 0s, visibility 0s 0s;
}

.bts-popup-container {
	position: relative;
	width: 90%;
	max-width: 400px;
	margin: 4em auto;
	background: #fff;
	border-radius: none;
	text-align: center;
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.2);
	-webkit-transform: translateY(-40px);
	-moz-transform: translateY(-40px);
	-ms-transform: translateY(-40px);
	-o-transform: translateY(-40px);
	transform: translateY(-40px);
	/* Force Hardware Acceleration in WebKit */
	-webkit-backface-visibility: hidden;
	-webkit-transition-property: -webkit-transform;
	-moz-transition-property: -moz-transform;
	transition-property: transform;
	-webkit-transition-duration: 0.3s;
	-moz-transition-duration: 0.3s;
	transition-duration: 0.3s;
}

.bts-popup-container img {
	padding: 20px 0 0 0;
}

.bts-popup-container p {
	color: black;
	padding: 10px 40px;
}

.bts-popup-container .bts-popup-button {
	padding: 5px 25px;
	border: 2px solid #254a84;
	display: inline-block;
	margin-bottom: 10px;
}

.bts-popup-container a {
	color: black;
	text-decoration: none;
	text-transform: uppercase;
}

.bts-popup-container .bts-popup-close {
	position: absolute;
	top: 8px;
	right: 8px;
	width: 30px;
	height: 30px;
}

.bts-popup-container .bts-popup-close::before, .bts-popup-container .bts-popup-close::after
	{
	content: '';
	position: absolute;
	top: 12px;
	width: 16px;
	height: 3px;
	background-color: #254a84;
}

.bts-popup-container .bts-popup-close::before {
	-webkit-transform: rotate(45deg);
	-moz-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	-o-transform: rotate(45deg);
	transform: rotate(45deg);
	left: 8px;
}

.bts-popup-container .bts-popup-close::after {
	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	transform: rotate(-45deg);
	right: 6px;
	top: 13px;
}

.is-visible .bts-popup-container {
	-webkit-transform: translateY(0);
	-moz-transform: translateY(0);
	-ms-transform: translateY(0);
	-o-transform: translateY(0);
	transform: translateY(0);
}

@media only screen and (min-width: 1170px) {
	.bts-popup-container {
		margin: 8em auto;
	}
}
</style>

</head>


<body>
	
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
									<br>
									<br>
									<Br>
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-12"></div>
									<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">

										<a href="index.jsp"><img class="main-logo"
											src="img/logo/logo.jpg" width="300" alt="" /></a>

										<h3>LostNFound helps find your lost property</h3>
										<h4>On average people lose something once a year.</h4>
										<br>
										<h5>How does LostNFound help?</h5>
										<img class="main-logo" src="img/logo/tick.jpg" width="50"
											alt="" /> Overview of your valuables. <br> <img
											class="main-logo" src="img/logo/tick.jpg" width="50" alt="" />
										Faster searching of your valuables.<br> <img
											class="main-logo" src="img/logo/tick.jpg" width="50" alt="" />
										See more details of your valuables.<br>
										<div
											class="alert alert-warning alert-st-three alert-st-bg2 alert-st-bg13"
											role="alert">
											<i
												class="fa fa-exclamation-triangle admin-check-pro admin-check-pro-clr2 admin-check-pro-clr13"
												aria-hidden="true"></i>
											<p class="message-mg-rt">
												<strong>Warning!</strong> In order to advertise the lost and
												found item, you need to have an account. Register now!
											</p>
										</div>
										Already have an account?
										<div class="modal-bootstrap modal-login-form">
											<a class="zoomInDown mg-t" href="#" data-toggle="modal"
												data-target="#zoomInDown1">Login</a>
										</div>
										<!-- User pop out login -->
										<div id="zoomInDown1"
											class="modal modal-edu-general modal-zoomInDown fade"
											role="dialog">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-close-area modal-close-df">
														<a class="close" data-dismiss="modal" href="#"><i
															class="fa fa-close"></i></a>
													</div>
													<div class="modal-body">
														<div class="modal-login-form-inner">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="basic-login-inner modal-basic-inner">
																		<h3>User Log In</h3>
																		<form action="UserLoginController" method="post">
																			<div class="form-group-inner">
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
																						<label class="login2">Email</label>
																					</div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<input name="UserEmail" type="email"
																							class="form-control" placeholder="Enter Email" />
																					</div>
																				</div>
																			</div>
																			<div class="form-group-inner">
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
																						<label class="login2">Password</label>
																					</div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<input name="UserPassword" type="password"
																							class="form-control" id="myInputULogin"
																							placeholder="password" required />

																					</div>
																				</div>
																			</div>
																			<div class="login-btn-inner">
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<label> <input type="checkbox"
																							onClick="showPWULogin()"> Show Password
																						</label>
																					</div>
																				</div>
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<div class="login-horizental">
																							<button
																								class="btn btn-sm btn-primary login-submit-cs"
																								type="reset">Reset</button>
																							<button
																								class="btn btn-sm btn-primary login-submit-cs"
																								type="submit" name="action" name="action"
																								value="UserLogin">
																								<b>Login</b>
																							</button>

																						</div>
																					</div>
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
										</div>
										<!-- Admin pop out login -->
										<div id="zoomInDown2"
											class="modal modal-edu-general modal-zoomInDown fade"
											role="dialog">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-close-area modal-close-df">
														<a class="close" data-dismiss="modal" href="#"><i
															class="fa fa-close"></i></a>
													</div>
													<div class="modal-body">
														<div class="modal-login-form-inner">
															<div class="row">
																<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																	<div class="basic-login-inner modal-basic-inner">
																		<h3>Admin Log In</h3>
																		<form action="UserLoginController" method="post">
																			<div class="form-group-inner">
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
																						<label class="login2">Email</label>
																					</div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<input type="email" name="UserEmail"
																							class="form-control" placeholder="Enter Email" />
																					</div>
																				</div>
																			</div>
																			<div class="form-group-inner">
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
																						<label class="login2">Password</label>
																					</div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<input type="password" name="UserPassword"
																							class="form-control" id="myInputALogin"
																							placeholder="password" required />

																					</div>
																				</div>
																			</div>
																			<div class="login-btn-inner">
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<label> <input type="checkbox"
																							onClick="showPWALogin()"> Show Password
																						</label>
																					</div>
																				</div>
																				<div class="row">
																					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
																					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
																						<div class="login-horizental">
																							<button
																								class="btn btn-sm btn-primary login-submit-cs"
																								type="reset">Reset</button>
																							<button
																								class="btn btn-sm btn-primary login-submit-cs"
																								type="submit" name="action" value="AdminLogin">
																								<b>Login</b>
																							</button>

																						</div>
																					</div>
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
										</div>

									</div>
									<div class="col-lg-1 col-md-1 col-sm-1 col-xs-12"></div>
									<div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
										<div class="basic-login-inner">

											<h2>Register Account</h2>
											<form action="RegisterController" method="post">
												<div class="form-group-inner">
													<label>Full Name</label>
													<br>
													<font color="grey" size="2">Please enter your first name(This will appear on your submission)</font> <input
														style="text-transform: capitalize" type="text"
														class="form-control" name="UserName"
														placeholder="Enter Full Name" required />
												</div>
												<div class="form-group-inner">
													<label>Phone Number</label><br>
													<font color="grey" size="2">Please enter the phone number to display on your submission</font><input type="text"
														class="form-control" name="UserNoPhone"
														placeholder="Phone Number" required />
												</div>
												<div class="form-group-inner">
													<label>Email</label> <br>
													<font color="grey" size="2">Please enter your email(This will appear on your submission)</font><input type="email"
														class="form-control" name="UserEmail"
														placeholder="Enter Email" required />
												</div>
												<div class="form-group-inner">
													<label>Password</label><br>
													<font color="grey" size="2">Please use a unique password</font> <input type="password"
														class="form-control" name="UserPassword"
														id="myInputRegister" placeholder="password" required />
												</div>

												<div class="login-btn-inner">
													<div class="inline-remember-me">
														<button
															class="btn btn-sm btn-primary pull-right login-submit-cs"
															type="submit" name="action" value="registerUser">
															<b>Register</b>
														</button>
														<!--  <div class="notification-bt responsive-btn">
																<button id="basicInfoWidth" class="btn btn-info">Info</button>
																<button id="basicWarningWidth" class="btn btn-warning">Warning</button>
																<button id="basicWarningWidth" class="btn btn-danger">Error</button>
																<button id="basicSuccessWidth" class="btn btn-success">Success</button>
															</div>-->
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
						<br>
						<Br>
						<Br>
						<br>
						<Br>
						<Br>
						<Br>
						<br>
						<Br>
						<Br>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- tabs & Register form End-->

	<!-- About start
		<a id="about" /></a> <br> 
		<div class="library-book-area mg-t-30">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
						<div class="single-cards-item">
							<div class="single-product-image">
								<a href="#"><img src="img/product/profile-bg.jpg" alt=""></a>
							</div>
							<div class="single-product-text">
								<img src="img/product/pro4.jpg" alt="">
								<h4>
									<a class="cards-hd-dn" href="#">Suraiya Anuar</a>
								</h4>
								<h5>Web Designer & Developer</h5>
								<p class="ctn-cards">Working on my Final Year Project;
									Bachelor of Information Technology (Hons.) Information System
									Engineering.</p>
								<a class="follow-cards"
									href="https://www.linkedin.com/in/suraiyaanr/" target="_blank">Follow</a>

							</div>
						</div>
					</div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
						<div class="admintab-wrap edu-tab1 mg-t-30">
							<ul class="nav nav-tabs custom-menu-wrap custon-tab-menu-style1">
								<li class="active"><a data-toggle="tab" href="#TabProject">
										<span class="edu-icon edu-analytics tab-custon-ic"></span>Tab
										Project
								</a></li>
								<li><a data-toggle="tab" href="#TabDetails"><span
										class="edu-icon edu-analytics-arrow tab-custon-ic"></span>Tab
										Details</a></li>
								<li><a data-toggle="tab" href="#TabPlan"><span
										class="edu-icon edu-analytics-bridge tab-custon-ic"></span>Tab
										Plan</a></li>
							</ul>
							<div class="tab-content">
								<div id="TabProject"
									class="tab-pane in active animated flipInX custon-tab-style1">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s.</p>
									<p>when an unknown printer took a galley of type and
										scrambled it to make a type specimen book. It has survived not
										only five centuries, but also the leap into electronic
										typesetting, remaining essentially unchanged.</p>
									<p>It was popularised in the 1960s with the release of
										Letraset sheets containing Lorem Ipsum passages, and more
										recently with desktop publishing software like Aldus PageMaker
										including versions of Lorem Ipsum.</p>
								</div>
								<div id="TabDetails"
									class="tab-pane animated flipInX custon-tab-style1">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s.</p>
									<p>when an unknown printer took a galley of type and
										scrambled it to make a type specimen book. It has survived not
										only five centuries, but also the leap into electronic
										typesetting, remaining essentially unchanged.</p>
								</div>
								<div id="TabPlan"
									class="tab-pane animated flipInX custon-tab-style1">
									<p>Lorem Ipsum is simply dummy text of the printing and
										typesetting industry. Lorem Ipsum has been the industry's
										standard dummy text ever since the 1500s.</p>
									<p>when an unknown printer took a galley of type and
										scrambled it to make a type specimen book. It has survived not
										only five centuries.</p>
									<p>the leap into electronic typesetting, remaining
										essentially unchanged.</p>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- About End-->




	<!-- Help Start
		<br> <a id="help" /></a> <br> <br>
		<div class="basic-form-area mg-b-15">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="admin-pro-accordion-wrap shadow-inner">
							<div class="alert-title">
								<h1>Help</h1>
								<p>Do you have a specific question? Then please take a look
									below for our most frequently asked questions.</p>
							</div>
							<div class="panel-group edu-custon-design" id="accordion2">
								<div class="panel panel-default">
									<div class="panel-heading accordion-head">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion2"
												href="#collapse4"> Collapsible Group 2</a>
										</h4>
									</div>
									<div id="collapse4" class="panel-collapse panel-ic collapse in">
										<div class="panel-body admin-panel-content animated flash">
											<p>It was popularised in the 1960s with the release of
												Letraset sheets of the containing Lorem Ipsum passages, and
												more recently with desktop publishing software like Aldus
												PageMaker including versions.</p>
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit,sed do eiusmod tempor incididunt ut labore et dolore
												magna aliqua of Lorem Ipsum.</p>
											<p>Ut enim adminim veniam, quis nostrud exercitation
												ullamco laboris nisis ut aliquip ex ea commodo consequat
												consectetur adipisicing elit.</p>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading accordion-head">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion2"
												href="#collapse5"> Collapsible Group 2</a>
										</h4>
									</div>
									<div id="collapse5" class="panel-collapse panel-ic collapse">
										<div class="panel-body admin-panel-content animated flash">
											<p>It was popularised in the 1960s with the release of
												Letraset sheets of the containing Lorem Ipsum passages, and
												more recently with desktop publishing software like Aldus
												PageMaker including versions.</p>
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit,sed do eiusmod tempor incididunt ut labore et dolore
												magna aliqua of Lorem Ipsum.</p>
											<p>Ut enim adminim veniam, quis nostrud exercitation
												ullamco laboris nisis ut aliquip ex ea commodo consequat
												consectetur adipisicing elit.</p>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading accordion-head">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion2"
												href="#collapse6"> Collapsible Group 2</a>
										</h4>
									</div>
									<div id="collapse6" class="panel-collapse panel-ic collapse">
										<div class="panel-body admin-panel-content animated flash">
											<p>It was popularised in the 1960s with the release of
												Letraset sheets of the containing Lorem Ipsum passages, and
												more recently with desktop publishing software like Aldus
												PageMaker including versions.</p>
											<p>Lorem ipsum dolor sit amet, consectetur adipisicing
												elit,sed do eiusmod tempor incididunt ut labore et dolore
												magna aliqua of Lorem Ipsum.</p>
											<p>Ut enim adminim veniam, quis nostrud exercitation
												ullamco laboris nisis ut aliquip ex ea commodo consequat
												consectetur adipisicing elit.</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Help End -->

	<!-- Contact start 
		<a id="contact" /></a> <br> <br>
		<div class="blog-details-area mg-b-15">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="blog-details-inner">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="lead-head">
										<h1>Contact</h1>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="coment-area">
									<form id="comment" action="#" class="comment">
										<div
											class="col-lg-4 col-md-4 col-sm-4 col-xs-12 blog-res-mg-bt">
											<div class="form-group">
												<input name="name" class="responsive-mg-b-10" type="text"
													placeholder="Name" />
											</div>
										</div>
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
											<div class="form-group">
												<input name="email" type="text" placeholder="Email" />
											</div>
										</div>
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
											<div class="form-group">
												<input name="phoneNo" type="text" placeholder="Phone Number" />
											</div>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<textarea name="message" cols="30" rows="10"
													placeholder="Message"></textarea>
											</div>
											<div class="payment-adress comment-stn">
												<button type="submit"
													class="btn btn-primary waves-effect waves-light">Send</button>
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
		<!-- Contact end -->

	<!-- Footer -->
	<br>
	<br>
	<!-- JS -->
	<jsp:include page="js.jsp" />
	<script type="text/javascript">
			jQuery(document).ready(
					function($) {

						window.onload = function() {
							$(".bts-popup").delay(1000).addClass('is-visible');
						}

						//open popup
						$('.bts-popup-trigger').on('click', function(event) {
							event.preventDefault();
							$('.bts-popup').addClass('is-visible');
						});

						//close popup
						$('.bts-popup')
								.on(
										'click',
										function(event) {
											if ($(event.target).is(
													'.bts-popup-close')
													|| $(event.target).is(
															'.bts-popup')) {
												event.preventDefault();
												$(this).removeClass(
														'is-visible');
											}
										});
						//close popup when clicking the esc keyboard button
						$(document).keyup(function(event) {
							if (event.which == '27') {
								$('.bts-popup').removeClass('is-visible');
							}
						});
					});
		</script>
	<div class="bts-popup" role="alert">
		<div class="bts-popup-container">
			<img
				src="https://www.trend-transformations.com/wp-content/themes/trend-transformations/library/images/trend-logo-white.svg"
				alt="" width="50%" /> <img class="main-logo"
				src="img/logo/logo.jpg" width="300" alt="" />

			<p>
				Important notice! <i>LostNfound UiTM Jasin Melaka</i> <strong>does
					not physically hold</strong> any lost or found property. We gather all the
				advertisments about lost and found item in UiTM Jasin. The contact
				information also provided for claiming process.
			</p>
			<a href="#0" class="bts-popup-close img-replace">Close</a>

			<p>In order to advertise the lost and found item, you need to
				have an account.</p>
			<p class="blink blink-one">
				<font color="red">Register now!</font>
			</p>
			Already have an account?
			<div class="modal-bootstrap modal-login-form">
				<a class="zoomInDown mg-t" href="#" data-toggle="modal"
					data-target="#zoomInDown1">Login</a>
			</div>
			<br> <br>
		</div>
	</div>
</body>

</html>