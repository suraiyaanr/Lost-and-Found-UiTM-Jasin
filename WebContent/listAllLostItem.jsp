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

        
        <!-- Static Table Start -->
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <div class="sparkline13-hd">
                                <div class="main-sparkline13-hd">
                                    <h1>All <span class="table-project-n">Lost Item</span></h1>
                                </div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true"  data-key-events="true"  data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId"  data-toolbar="#toolbar">
									<thead>
										<tr>
											<th data-field="Item Photo">Item Photo</th>
											<th data-field="Item Name">Item Name</th>
											<th data-field="Item Category">Item Category</th>
											<th data-field="Item Date Found">Item Date Found</th>
											<th data-field="Last Location">Last Location</th>
											<th data-field="Description">Description</th>
											<th data-field="UPDATE">MORE</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="lost" items="${losts}">
											<tr>
												<td><img src="<c:out value="${lost.photo}" />" width="100"/></td>
												<td><c:out value="${lost.LItemName}" /></td>
												<td><c:out value="${lost.LItemCategory}" /></td>
												<td><c:out value="${lost.LItemDate}" /></td>
												<td><c:out value="${lost.LItemLocation}" /></td>
												<td><c:out value="${lost.LItemDescription}" /></td>
												
												<td><a
													href="LostController?action=viewLost&LItemID=<c:out value="${lost.LItemID}" />"><font
														color="red">View</font></a></td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
                                    <br><br>
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