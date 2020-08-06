
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="left-sidebar-pro">
	<nav id="sidebar" class="">
		<div class="sidebar-header">
			<a href="searchForm.jsp"><img class="main-logo"
				src="img/logo/logo.jpg" width="200" alt="" /></a> <strong><a
				href="searchForm.jsp"><img src="img/logo/logosn.png" alt="" /></a></strong>
		</div>
		<div class="left-custom-menu-adp-wrap comment-scrollbar">
			<nav class="sidebar-nav left-sidebar-menu-pro">
				<ul class="metismenu" id="menu1">
					<li><a href="searchForm.jsp"> <span
							class="fa fa-search icon-wrap"></span> <span
							class="mini-click-non">Search</span>
					</a></li>
					<li><a class="has-arrow" aria-expanded="false"> <span
							class="educate-icon educate-apps"></span> <span
							class="mini-click-non">Manage Found Item<font color="white">..:</font></span></a>
						<ul class="submenu-angle" aria-expanded="false">
							<li><a title="All Found Item"
								href="/lofo/FoundController?action=listAllMyPost"><span
									class="mini-sub-pro">All My Post</span></a></li>
							<li><a title="Add Found Item" href="registerFoundItem.jsp"><span
									class="mini-sub-pro">Add Found Item</span></a></li>
						</ul></li>
					<li><a class="has-arrow" aria-expanded="false"> <span
							class="educate-icon educate-apps"></span> <span
							class="mini-click-non">Manage Lost Item<font color="white">..:</font></span></a>
						<ul class="submenu-angle" aria-expanded="false">
							<li><a title="All Lost Item"
								href="/lofo/LostController?action=listAllMyPost"><span
									class="mini-sub-pro">All My Post</span></a></li>
							<li><a title="Add Lost Item" href="registerLostItem.jsp"><span
									class="mini-sub-pro">Add Lost Item</span></a></li>
						</ul></li>
					<!-- Admin -->
					<%
						if (!String.valueOf(session.getAttribute("currentSessionUserRole")).equalsIgnoreCase("User")) {
					%>

					<li><a class="has-arrow" aria-expanded="false"> <span
							class="educate-icon educate-professor icon-wrap"></span> <span
							class="mini-click-non">Manage Admin</span></a>
						<ul class="submenu-angle" aria-expanded="false">
							<li><a title="All Found Item"
								href="/lofo/UserController?action=listAll"><span
									class="mini-sub-pro">List All Admin</span></a></li>
							<li><a title="Add Found Item" href="registerAdmin.jsp"><span
									class="mini-sub-pro">Register Admin</span></a></li>
						</ul></li>
					<!--  <li><a class="has-arrow"
						aria-expanded="false"> <span
							class="educate-icon educate-student icon-wrap"></span> <span
							class="mini-click-non">User Account</span></a>
						<ul class="submenu-angle" aria-expanded="false">
							<li><a title="All Found Item" href="/lofo/UserController?action=listReportUser"><span
									class="mini-sub-pro">Reported User</span></a></li>
						</ul></li>-->
					<%
						}
					%>
				</ul>

			</nav>
		</div>
	</nav>
</div>
<!-- End Header menu area -->

<!-- Start Welcome area -->
<div class="all-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="logo-pro">
					<a href="searchForm.jsp"><img class="main-logo"
						src="img/logo/logo.jpg" alt="" width="200" /></a>
				</div>
			</div>
		</div>
	</div>
	<div class="header-advance-area">
		<div class="header-top-area">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="header-top-wraper">
							<div class="row">
								<div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
									<div class="menu-switcher-pro">
										<button type="button" id="sidebarCollapse"
											class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
											<i class="educate-icon educate-nav"></i>
										</button>
									</div>
								</div>

								<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
									<form action="UserLoginController" method="get">
										<div class="header-right-info">
											<ul class="nav navbar-nav mai-top-nav header-right-menu">
												<li class="nav-item dropdown">
													<%
														String UserName = (String) session.getAttribute("currentSessionUserName");
													%>
													<%
														String UserEmail = (String) session.getAttribute("currentSessionUser");
													%>
												
												<li class="nav-item"><a
													href="/lofo/UserController?action=viewAccount&UserEmail=<c:out value="<%=UserEmail%>"/>"
													data-toggle="dropdown" role="button" aria-expanded="false"
													class="nav-link dropdown-toggle"> <span
														class="admin-name"><c:out value="<%=UserName%>" /></span>
														<i class="fa fa-angle-down edu-icon edu-down-arrow"></i>
												</a>
													<ul role="menu"
														class="dropdown-header-top author-log dropdown-menu animated zoomIn">
														<li><a
															href="/lofo/UserController?action=viewAccount&UserEmail=<c:out value="<%=UserEmail%>"/>"><span
																class="edu-icon edu-home-admin author-log-ic"></span>My
																Account</a></li>
														<li><a href="/lofo/UserLoginController?action=Logout"
															onclick="return confirm('Are you sure want to Logout?')">
																<span class="edu-icon edu-locked author-log-ic"></span>Log
																Out
														</a></li>
													</ul></li>
											</ul>
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

	<!-- Mobile Menu start -->
	<div class="mobile-menu-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="mobile-menu">
						<nav id="dropdown">
							<ul class="mobile-menu-nav">

								<li><a href="searchForm.jsp"> <span
										class="fa fa-search icon-wrap"></span> <span
										class="mini-click-non">Search</span>
								</a></li>
								<li><a class="has-arrow" aria-expanded="false"> <span
										class="educate-icon educate-apps"></span> <span
										class="mini-click-non">Found Item</span></a>
									<ul class="submenu-angle" aria-expanded="false">
										<li><a title="All Found Item"
											href="/lofo/FoundController?action=listAllMyPost"><span
												class="mini-sub-pro">My Post</span></a></li>
										<li><a title="Add Found Item"
											href="registerFoundItem.jsp"><span class="mini-sub-pro">Add
													Found Item</span></a></li>
									</ul></li>
								<li><a class="has-arrow" aria-expanded="false"> <span
										class="educate-icon educate-apps"></span> <span
										class="mini-click-non">Lost Item</span></a>
									<ul class="submenu-angle" aria-expanded="false">
										<li><a title="All Lost Item"
											href="/lofo/LostController?action=listAllMyPost"><span
												class="mini-sub-pro">My Post</span></a></li>
										<li><a title="Add Lost Item" href="registerLostItem.jsp"><span
												class="mini-sub-pro">Add Lost Item</span></a></li>
									</ul></li>
								<!-- Admin -->
								<%
									if (!String.valueOf(session.getAttribute("currentSessionUserRole")).equalsIgnoreCase("User")) {
								%>

								<li><a class="has-arrow" aria-expanded="false"> <span
										class="educate-icon educate-student icon-wrap"></span> <span
										class="mini-click-non">Manage Admin</span></a>
									<ul class="submenu-angle" aria-expanded="false">
										<li><a title="All Found Item"
											href="/lofo/UserController?action=listAll"><span
												class="mini-sub-pro">List Admin</span></a></li>
										<li><a title="Add Found Item" href="registerAdmin.jsp"><span
												class="mini-sub-pro">Register Admin</span></a></li>
									</ul></li>
								<!--  <li><a class="has-arrow"
						aria-expanded="false"> <span
							class="educate-icon educate-student icon-wrap"></span> <span
							class="mini-click-non">User Account</span></a>
						<ul class="submenu-angle" aria-expanded="false">
							<li><a title="All Found Item" href="/lofo/UserController?action=listReportUser"><span
									class="mini-sub-pro">Reported User</span></a></li>
						</ul></li>-->
								<%
									}
								%>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<br>
		</div>
	</div>
	<!-- Mobile Menu end -->