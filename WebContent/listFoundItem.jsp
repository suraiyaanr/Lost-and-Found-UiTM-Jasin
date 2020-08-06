<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<jsp:include page="css.jsp"></jsp:include>
<meta charset="utf-8" />
</head>

<body>
	<jsp:include page="header.jsp" />
	<!-- Static Table Start -->
	<div class="data-table-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="sparkline13-list">
						<div class="sparkline13-hd">
							<div class="main-sparkline13-hd">
								<h1>
									All <span class="table-project-n">My Found Item Post</span>
								</h1>
							</div>
						</div>
						<%	String UserName = (String)session.getAttribute("currentSessionUserName");%>
						<%	String UserEmail = (String)session.getAttribute("currentSessionUser");%>
						<div class="sparkline13-graph">
							<div class="datatable-dashv1-list custom-datatable-overright">
								<table id="table" data-toggle="table" data-pagination="true"
									data-search="true" data-show-columns="true"
									data-show-pagination-switch="true" data-key-events="true"
									data-show-toggle="true" data-resizable="true"
									data-cookie="true" data-cookie-id-table="saveId"
									data-click-to-select="true" data-toolbar="#toolbar">
									<thead>
										<tr>
											<th data-field="Item ID">Item ID</th>
											<th data-field="Item Photo">Item Photo</th>
											<th data-field="Item Name">Item Name</th>
											<th data-field="Item Category">Item Category</th>
											<th data-field="Last Location">Last Location</th>
											<th data-field="UPDATE">UPDATE</th>
											<th data-field="IDELETE">DELETE</th>
										</tr>
									</thead>
									
									<tbody>
										<c:forEach var="found" items="${founds}">
											<tr>
												<td>F<c:out value="${found.FItemID}" /></td>
												<td style="width:200;"><img src="<c:out value="${found.photo}" />" width="200"/></td>
												<td><c:out value="${found.FItemName}" /></td>
												<td><c:out value="${found.FItemCategory}" /></td>
												<td><c:out value="${found.FItemLocation}" /></td>
												<td><a
													href="/lofo/FoundController?action=viewMyFound&FItemID=<c:out value="${found.FItemID}" />"><font
														color="red">View</font></a></td>
												<td><a
													href="FoundController?action=deleteFound&FItemID=<c:out value="${found.FItemID}" />"><font
														color="red">Delete</font></a></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
								<br>
								<br>
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