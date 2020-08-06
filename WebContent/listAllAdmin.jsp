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
                                    <h1>All <span class="table-project-n">Admin</span></h1>
                                    <p>All authorized administrator will display here. If has any inquiries for respective admin, please contact their contact number or email. Thank you.  </p>
                                </div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true"  data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId"  data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
										<tr>
											<th data-field="userName" >Full Name</th>
											<th data-field="userEmail" >Email</th>
											<th data-field="userNoPhone" >No.Phone</th>
											<th data-field="userRole" >Role</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${users}">
                                            <tr>
                                                <td><c:out value="${user.userName}"/></td>
                                                <td><c:out value="${user.userEmail}"/></td>
                                                <td><c:out value="${user.userNoPhone}"/></td>
                                                <td><c:out value="${user.userRole}"/></td>
                                                <!--  <td><a href="UserController?action=updateAccount&email=<c:out value="" />">Update</a></td>
                   								<td><a href="UserController?action=deleteAccount&email=<c:out value="" />">Delete</a></td>-->
                   						  
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