<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="lofo.model.UsersBean"%>
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
						<div class="product-status mg-b-15">
							<div class="container-fluid">
								<div class="row">
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
										<div class="product-status-wrap">
											<%
												String userEmail = (String) session.getAttribute("currentSessionUser");
											%>
											<h2>My Account</h2>
											<table>
												<tr>
													<th><b>Full Name:</b></th>
													<td><c:out value="${user.userName}" /></td>
												</tr>
												<tr>
													<th><b>No. Phone:</b></th>
													<td><c:out value="${user.userNoPhone}" /></td>
												</tr>
												<!--  <tr>
													<th>Account Status:</th>
													<%
													UsersBean user = (UsersBean) request.getAttribute("user");
													if(user.getUserStatus() == "Blocked"){
													%>
													<td><button class="ds-setting"><c:out value="${user.userStatus}" /></button></td>
													<% } else { %>
													<td><button class="pd-setting"><c:out value="${user.userStatus}" /></button></td>
													<% } %>
												</tr>-->
											</table>
											<br>
											<br>
											<a
														href="UserController?action=updateAccount&UserEmail=<c:out value="<%=userEmail%>" />"
														class="btn btn-primary pull-right" ><b>Update Account</b> </a>
											
											<br /> <br /> <br /> <br /> <br /> <br /> <br>
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