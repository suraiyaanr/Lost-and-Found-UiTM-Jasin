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
								<input type="text"
									class="form-control" name="UserName"
									value="<c:out value="<%=userName%>" />" readonly="readonly" />

							</div>

							<div class="form-group-inner">
								<label>Contact Number: </label> <br> 
								<input type="text"
									class="form-control" name="UserNoPhone"
									value="<c:out value="<%=userNoPhone%>" />" readonly="readonly" />

							</div>

							<div class="form-group-inner">
								<label>Email: </label> <br> 
								<input type="text"
									class="form-control" name="UserEmail"
									value="<c:out value="<%=userEmail%>" />" readonly="readonly" />
							</div>
							<!-- update  account-->
							<a
								href="UserController?action=updateAccount&UserEmail=<c:out value="<%=userEmail%>" />"
								class="btn btn-success compose-btn btn-block m-b-md">Update
								Profile</a>

						</div>
					</div>
				</div>
				<div class="col-md-9 col-md-9 col-sm-9 col-xs-12">
					<div class="hpanel email-compose">
						<div class="container-fluid">
							<div class="row">
								<div class="panel-heading hbuilt">
									<form action="FoundController" method="post">
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
											<h4>
												<c:out value="F${found.FItemID}" />
												Found Item Details :
											</h4>
										</div>
										<BR>
										<div class="col-lg-12 col-md-12 ol-sm-12 col-xs-12">
											<center>
												<img src="<c:out value="${found.photo}" />" width="300"/>
											</center>

											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="row">
													<div class="col-lg-6 col-md-3 col-sm-3 col-xs-12">
														<br> <label>Item ID:<br></label>  
														<input
															class="form-control" name="FItemID" type="text"
															value="<c:out value="${found.FItemID}" />"
															readonly="readonly" />

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Item Category:</label> <br> 
														<input
															class="form-control" name="FItemCategory" type="text"
															value="<c:out value="${found.FItemCategory}" />"
															readonly="readonly" />

													</div>
													<div class="col-lg-6 col-md-3 col-sm-3 col-xs-12">
														<br> <label>Date Found:</label> <br> 
														<input
															class="form-control" name="FItemDate" type="text"
															value="<c:out value="${found.FItemDate}" />"
															readonly="readonly" />

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Time:</label> <br> 
														<input
															class="form-control" name="FItemTime" type="text"
															value="<c:out value="${found.FItemTime}" />"
															readonly="readonly" />

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Item Name:</label> <br> 
														<input
															type="text" class="form-control" name="FItemName"
															value="<c:out value="${found.FItemName}" />"
															readonly="readonly" />

													</div>

													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<br> <label>Location Found:</label> <br> 
														<input
															type="text" class="form-control" name="FItemLocation"
															value="<c:out value="${found.FItemLocation}" />"
															readonly="readonly" />

													</div>
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<br> <label>Description: </label> <br>
														<div class="form-group edit-ta-resize res-mg-t-15">
															<textarea name="FItemDescription"
																placeholder="<c:out value="${found.FItemDescription}" />"
																readonly="readonly"></textarea>
														</div>

													</div>
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<button
															class="btn btn-custon-three btn-danger pull-right"
															type="submit" name="action" value="deleteFound"
															onclick="return confirm('Are you sure want to delete this data? \nYou can\'t recover the data if u delete it')"><i class="fa fa-times edu-danger-error"
																aria-hidden="true"></i>
															<b>Confirm Delete</b><br>
														</button>
														<br><br><a class="pull-right" href="/lofo/FoundController?action=listAllMyPost">
												Cancel</a>
														
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


	<!-- JS -->
	<jsp:include page="js.jsp"></jsp:include>
</body>

</html>