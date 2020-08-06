<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html class="no-js" lang="en">
<%
	String userEmail = (String) session.getAttribute("currentSessionUser");
%>
<head>
<jsp:include page="css.jsp"></jsp:include>
<style>
.hide{
display:none;
}
</style>
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
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
										</div>
											<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
												<div class="basic-login-inner">

											<h2>Update Account</h2>
											<form method="post" action="/lofo/PasswordController">
												
												<div class="form-group-inner">
													<label>Current Password:</label> 
													<input type="password"class="form-control" id="myInputCPW" name="currentPassword"/>
													<input type="checkbox" onClick="showCurrentPW()"> Show Password
												</div>
												<div class="form-group-inner">
													<label>New Password:</label> 
													<input type="password" class="form-control" id="myInputNPW" name="newPassword" />
													<input type="checkbox" onClick="showNewPW()"> Show Password 
												</div>
												<input type="hidden" class="hide" name="UserEmail" value="<c:out value="<%=userEmail%>" />" /> 
												
												<br> 
												<input type="submit" name="action" class="btn btn-primary" value="Submit">
												<BR>
												<BR>
												<BR>
												<BR>
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
		<!-- tabs & Register form End-->

	</div>
	<!-- JS -->
	<jsp:include page="js.jsp"></jsp:include>

</body>

</html>