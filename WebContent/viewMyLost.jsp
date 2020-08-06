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
	<br>
	<br>
	<%
		String userEmail = (String) session.getAttribute("currentSessionUser");
	%>
	<%
		String userNoPhone = (String) session.getAttribute("currentSessionUserNoPhone");
	%>
	<%
		String userName = (String) session.getAttribute("currentSessionUserName");
	%>
	<div class="mailbox-compose-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3 col-md-3 col-sm-3 col-xs-12">
					<div class="hpanel shadow-inner responsive-mg-b-30">
						<div class="panel-body">

							<h4>Reporter Details:</h4>

							<div class="form-group-inner">
								<label>Post by:</label> <br>
								<%=userName%>
							</div>

							<div class="form-group-inner">
								<label>Contact Number: </label> <br>
								<%=userNoPhone%>

							</div>


							<!-- update  account-->
							<a
								href="UserController?action=updateAccount&UserEmail=<c:out value="<%=userEmail%>" />"
								class="btn btn-success compose-btn btn-block m-b-md">Update Account Details</a>

						</div>
					</div>
				</div>
				<div class="col-md-9 col-md-9 col-sm-9 col-xs-12">
					<div class="hpanel email-compose">
						<div class="container-fluid">
							<div class="row">
								<div class="panel-heading hbuilt">
									<form action="LostController" method="post">
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
											<h4>
												<c:out value="L${lost.LItemID}" />
												Lost Item Details :
											</h4>
										</div>
										<BR>
										<div class="col-lg-12 col-md-12 ol-sm-12 col-xs-12">
											<label>Item Photo:</label> <br>
											<img src="<c:out value="${lost.photo}" />" width="300"/>

											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row">
													<div class="col-lg-6 col-md-3 col-sm-3 col-xs-12">
														<br> <label>Item ID:</label> <br>
														<c:out value="L${lost.LItemID}" />
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Item Category:</label> <br>
														<c:out value="${lost.LItemCategory}" />
													</div>
													<div class="col-lg-6 col-md-3 col-sm-3 col-xs-12">
														<br> <label>Date Lost:</label> <br>
														<c:out value="${lost.LItemDate}" />
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Time:</label> <br>
														<c:out value="${lost.LItemTime}" />
													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Item Name:</label> <br>
														<c:out value="${lost.LItemName}" />
													</div>

													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Location Lost:</label> <br>
														<c:out value="${lost.LItemLocation}" />
													</div>
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<br> <label>Description: </label> <br>
														<c:out value="${lost.LItemDescription}" />
														<br> <br>
													</div>
													<a class="btn btn-custon-two btn-primary pull-left"
														href="/lofo/LostController?action=listAllMyPost"> Back
														to My List</a> <a
														class="btn btn-custon-three btn-success pull-right"
														href="LostController?action=updateLost&LItemID=<c:out value="${lost.LItemID}" />">
														Update</a>


													
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


	<!-- JS -->
	<jsp:include page="js.jsp"></jsp:include>
</body>

</html>