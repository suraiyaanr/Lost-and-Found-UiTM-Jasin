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
		<jsp:include page="header.jsp"/>
			
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
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
										</div>
											<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
												<div class="basic-login-inner">

													<h2>Update Account</h2>
													<form action="UserController" method="post" >
														<div class="form-group-inner">
															<label>Full Name</label> <input type="text"
																class="form-control" name="UserName" value="<c:out value="${user.userName}" />"
																required />
														</div>
														<div class="form-group-inner">
															<label>Phone Number</label> <input type="text"
																class="form-control" name="UserNoPhone" value="${user.userNoPhone}" required />
														</div>
														<div class="form-group-inner">
															<label>Password :</label> <a href="/lofo/updatePass.jsp" class="btn btn-info">Update Password</a><br>
														</div>

														<div class="login-btn-inner">
															<div class="inline-remember-me">
																<button
																	class="btn btn-sm btn-primary pull-right login-submit-cs"
																	type="submit" name="action" value="Submit">
																	<b>Submit</b>
																</button>
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
			<!-- tabs & Register form End-->
			
	</div>
	<!-- JS -->
	<jsp:include page="js.jsp"></jsp:include>
	
</body>

</html>