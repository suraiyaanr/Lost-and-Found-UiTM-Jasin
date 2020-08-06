package lofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lofo.dao.UserDAO;
import lofo.model.UsersBean;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VIEW ="viewAccount.jsp";
	private String VIEWALL ="listAllAdmin.jsp";
	private String VIEWREPORTEDUSER ="reportUser.jsp";
	private static String UPDATE = "updateAccount.jsp";
	private static String UPDATEPASS = "updatePass.jsp";
	private static String DELETE = "deleteAccount.jsp";
	private static String SEARCH = "createTeacher.jsp";

	String forward;
	private UserDAO dao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		dao = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("viewAccount")) {
			forward = VIEW;
			String UserEmail = request.getParameter("UserEmail");
			UsersBean user = UserDAO.getUserByEmail(UserEmail);
			List<UsersBean> users = UserDAO.getAllAdmin();
			request.setAttribute("users", users );
			request.setAttribute("user", user);
		}
		else if (action.equalsIgnoreCase("listAll")) {
			forward = VIEWALL;
			request.setAttribute("users", UserDAO.getAllAdmin()); 

		}
		else if (action.equalsIgnoreCase("listReportUser")) {
			forward = VIEWREPORTEDUSER;
			request.setAttribute("users", UserDAO.getReportedUser()); 

		}
		else if (action.equalsIgnoreCase("updateAccount")){
			forward = UPDATE;
			String UserEmail = request.getParameter("UserEmail");
			UsersBean user = UserDAO.getUserByEmail(UserEmail);
			List<UsersBean> users = UserDAO.getAllAdmin();
			request.setAttribute("users", users);
			request.setAttribute("user", user);
		}
		else if (action.equalsIgnoreCase("updatePass")){
			forward = UPDATEPASS;
			String UserEmail = request.getParameter("UserEmail");
			UsersBean user = UserDAO.getUserByEmail(UserEmail);
			request.setAttribute("user", user);
		}


		else if (action.equalsIgnoreCase("search")){
			forward = SEARCH;
			List<UsersBean> user = UserDAO.getAllAdmin();
			request.setAttribute("users", user);


		}
		else if (action.equalsIgnoreCase("deleteAccount")){
			forward = DELETE;
			String UserEmail = request.getParameter("UserEmail");
			UsersBean user = UserDAO.getUserByEmail(UserEmail);
			request.setAttribute("user", user);
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("Submit")) {
			String UserEmail = request.getParameter("UserEmail");
			String UserName = request.getParameter("UserName");
			String UserNoPhone = request.getParameter("UserNoPhone");

			if(UserName.contains("'")) {
				UserName = UserName.replaceAll("'", "''");
			}

			UsersBean user = new UsersBean();

			user.setUserEmail(UserEmail);
			user.setUserName(UserName);
			user.setUserNoPhone(UserNoPhone);
			HttpSession session = request.getSession(true);
			if(String.valueOf(session.getAttribute("currentSessionUserRole")).equalsIgnoreCase("Admin")) {
				String UserRole = request.getParameter("role");
				user.setUserRole(UserRole);
			}
			
			String email = (String) session.getAttribute("currentSessionUser");


			dao = new UserDAO();
			try {
				dao.updateAccount(user, email);
//				session.setAttribute("currentSessionUser", user.getUserEmail());
				/*forward = VIEW;
			user = UserDAO.getUserByEmail(UserEmail);
			request.setAttribute("user", user); */
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.println("<script>");
				pw.println("alert('The account is updated');");
				pw.println("window.location.href='/lofo/UserController?action=viewAccount&UserEmail="+ email +"';");
				pw.println("</script>");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}
