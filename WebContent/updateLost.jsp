<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="lofo.model.UsersBean"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<link href="css/select2.min.css" rel="stylesheet" />
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
				<form action="LostController?action=updateLost" method="post" enctype="multipart/form-data">
					<div class="col-md-3 col-md-3 col-sm-3 col-xs-12">
						<div class="hpanel shadow-inner responsive-mg-b-30">
							<div class="panel-body">

								<h4>Reporter Details:</h4>

								<div class="form-group-inner">
									<label>Post by:</label> <input type="text" class="form-control"
										name="UserName" value="<c:out value="<%=userName%>" />"
										readonly="readonly" />
								</div>

								<div class="form-group-inner">
									<label>Contact Number: </label><input type="text"
										class="form-control" name="UserNoPhone"
										value="<c:out value="<%=userNoPhone%>" />" readonly="readonly" />

								</div>

								<div class="form-group-inner">
									<label>Email: </label><input type="text" class="form-control"
										name="UserEmail" value="<c:out value="${lost.userEmail}" />"
										readonly="readonly" />
								</div>
								<!-- update  account-->
								<a
									href="UserController?action=updateAccount&UserEmail=<c:out value="<%=userEmail%>" />"
									class="btn btn-success compose-btn btn-block m-b-md">Update
									Account Details</a>

							</div>
						</div>
					</div>
					<div class="col-md-9 col-md-9 col-sm-9 col-xs-12">
						<div class="hpanel email-compose">
							<div class="container-fluid">
								<div class="row">
									<div class="panel-heading hbuilt">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<center>
												<h4>Update New Lost Item</h4>
											</center>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<label for="Profile Photo">Upload New Photo:</label> <input
													type='file' onchange="readURL(this);" name="LItemPhoto" accept="image/*"/> <img id="blah"
													 width="300" />
											</div>
										</div> 
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<br> <label>Current Photo:</label> <br> 
											<img src="<c:out value="${lost.photo}" />" width="500"/>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
											<br> <label>Item ID:</label> <br> <input
												class="form-control" name="LItemID" type="text"
												value="<c:out value="${lost.LItemID}" />"
												readonly="readonly" />
										</div>
										<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
											<br> <label>Date Lost:</label> <input
												class="form-control" name="LItemDate" type="date" required
												value="<c:out value="${lost.LItemDate}" />" />
										</div>
										<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
											<br> <label>Time:</label> <input class="form-control"
												name="LItemTime" type="time" required
												value="<c:out value="${lost.LItemTime}" />" />
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group-inner">
												<label><br>Item Name:</label> <input type="text"
													class="form-control" name="LItemName"
													value="<c:out value="${lost.LItemName}" />" required />
											</div>
											<div class="form-group-inner">
												<label>Item Category:</label><br> <font color="red">Please
													re-select the category</font>
												<div class="form-select-list">
													<select class="autocomplete form-control"
														name="LItemCategory" required>
														<option  disabled selected value=><c:out
																value="${lost.LItemCategory}"/></option>
														<option value="Mobile Phone">Mobile Phone</option>
														<option value="Laptop">Laptop</option>
														<option value="Keys">Keys</option>
														<option value="Cards">Cards</option>
														<option value="UiTM Matrics Card">UiTM Matrics
															Card</option>
														<option value="Other">Other..</option>
													</select>
												</div>
											</div>
											<div class="form-group-inner">
												<label>Location Lost:</label><br> <font color="red">Please
													re-select the location</font>
												<div class="form-select-list">
													<select class="autocomplete form-control"
														name="LItemLocation" required>
														<option disabled selected value=><c:out
																value="${lost.LItemLocation}" /></option>
														<option value="Kolej Tun Gemala A">Kolej Tun
															Gemala A</option>
														<option value="Kolej Tun Gemala B">Kolej Tun
															Gemala B</option>
														<option value="Kolej Tun Gemala C">Kolej Tun
															Gemala C</option>
														<option value="Kolej Tun Lanang A">Kolej Tun
															Lanang A</option>
														<option value="Kolej Tun Lanang B">Kolej Tun
															Lanang B</option>
														<option value="Pejabat Kolej">Pejabat Kolej</option>
														<option value="Cafe Kolej">Cafe Kolej</option>
														<option value="Pusat Persatuan Pelajar">Pusat
															Persatuan Pelajar</option>
														<option value="Pusat Islam Surau">Pusat Islam
															Surau</option>
														<option value="Unit Kesihatan">Unit Kesihatan</option>
														<option value="Blok Kuliah">Blok Kuliah</option>
														<option value="Lif">Lif</option>
														<option value="Cafe Kuliah">Cafe Kuliah</option>
														<option value="Bilik Tutorial 1">Bilik Tutorial 1</option>
														<option value="Bilik Tutorial 2">Bilik Tutorial 2</option>
														<option value="Bilik Tutorial 3">Bilik Tutorial 3</option>
														<option value="Bilik Tutorial 4">Bilik Tutorial 4</option>
														<option value="Bilik Tutorial 5">Bilik Tutorial 5</option>
														<option value="Bilik Tutorial 6">Bilik Tutorial 6</option>
														<option value="Bilik Tutorial 7">Bilik Tutorial 7</option>
														<option value="Bilik Tutorial 8">Bilik Tutorial 8</option>
														<option value="Bilik Kuliah 1">Bilik Kuliah 1</option>
														<option value="Bilik Kuliah 2">Bilik Kuliah 2</option>
														<option value="Bilik Kuliah 3">Bilik Kuliah 3</option>
														<option value="Bilik Kuliah 4">Bilik Kuliah 4</option>
														<option value="Bilik Kuliah 5">Bilik Kuliah 5</option>
														<option value="Bilik Kuliah 6">Bilik Kuliah 6</option>
														<option value="Bilik Kuliah 7">Bilik Kuliah 7</option>
														<option value="Bilik Kuliah 8">Bilik Kuliah 8</option>
														<option value="Bilik Kuliah 9">Bilik Kuliah 9</option>
														<option value="Bilik Kuliah 10">Bilik Kuliah 10</option>
														<option value="Bilik Kuliah 11">Bilik Kuliah 11</option>
														<option value="Bilik Kuliah 12">Bilik Kuliah 12</option>
														<option value="Bilik Kuliah 13">Bilik Kuliah 13</option>
														<option value="Bilik Kuliah 14">Bilik Kuliah 14</option>
														<option value="Bilik Kuliah 15">Bilik Kuliah 15</option>
														<option value="Bilik Kuliah 16">Bilik Kuliah 16</option>
														<option value="Bilik Kuliah 17">Bilik Kuliah 17</option>
														<option value="Bilik Kuliah 18">Bilik Kuliah 18</option>
														<option value="Bilik Kuliah 19">Bilik Kuliah 19</option>
														<option value="Bilik Kuliah 20">Bilik Kuliah 20</option>
														<option value="Dewan Seminar 1A">Dewan Seminar 1A</option>
														<option value="Dewan Seminar 1B">Dewan Seminar 1B</option>
														<option value="Dewan Seminar 2A">Dewan Seminar 2A</option>
														<option value="Dewan Seminar 2B">Dewan Seminar 2B</option>
														<option value="Dewan Seminar 3A">Dewan Seminar 3A</option>
														<option value="Dewan Seminar 3B">Dewan Seminar 3B</option>
														<option value="Dewan Seminar 4A">Dewan Seminar 4A</option>
														<option value="Dewan Seminar 4B">Dewan Seminar 4B</option>
														<option value="Dewan Seminar 5A">Dewan Seminar 5A</option>
														<option value="Dewan Seminar 5B">Dewan Seminar 5B</option>
														<option value="Dewan Seminar 6A">Dewan Seminar 6A</option>
														<option value="Dewan Seminar 6B">Dewan Seminar 6B</option>
														<option value="Dewan Kuliah A">Dewan Kuliah A</option>
														<option value="Dewan Kuliah B">Dewan Kuliah B</option>
														<option value="Auditorium">Auditorium</option>
														<option value="Blok FSKM">Blok FSKM</option>
														<option value="JMK 1">JMK 1</option>
														<option value="JMK 2">JMK 2</option>
														<option value="JMK 3">JMK 3</option>
														<option value="JMK 4">JMK 4</option>
														<option value="JMK 5">JMK 5</option>
														<option value="JMK 6">JMK 6</option>
														<option value="JMK 7">JMK 7</option>
														<option value="JMK 8">JMK 8</option>
														<option value="JMK 9">JMK 9</option>
														<option value="JMK 10">JMK 10</option>
														<option value="JMK 11">JMK 11</option>
														<option value="JMK 12">JMK 12</option>
														<option value="Blok FPA A">Blok FPA A</option>
														<option value="Blok FPA B">Blok FPA B</option>
														<option value="Blok FPA C">Blok FPA C</option>

													</select>
												</div>
											</div>
											<div class="form-group-inner">
												<label>Description: </label>
												<div class="form-group edit-ta-resize res-mg-t-15">
													<textarea name="LItemDescription"><c:out
															value="${lost.LItemDescription}" /></textarea>
												</div>
											</div>
											<button class="btn btn-custon-three btn-success pull-right"
												type="submit" name="" value=""
												onclick="return confirm('Are you sure want to UPDATE this data?')">
												<i class="fa fa-check edu-checked-pro" aria-hidden="true"></i>
												<b>Confirm Update</b><br>
											</button>
											<br><br><a class="pull-right" href="/lofo/LostController?action=listAllMyPost">
												Cancel</a>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



	<!-- JS -->
	<jsp:include page="js.jsp"></jsp:include>
	<script src="js/select2.min.js"></script>
</body>
<script>
	$(document).ready(function() {
		$('.autocomplete').select2();
		$("#sidebar").mCustomScrollbar({
			theme : "minimal"
		});
	});
</script>
</html>