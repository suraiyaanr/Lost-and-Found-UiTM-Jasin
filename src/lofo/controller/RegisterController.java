package lofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lofo.dao.UserDAO;
import lofo.model.UsersBean;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VIEW ="/lofo/viewAccount.jsp";
	private UserDAO dao;
	String forward=""; 
	String action="";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("viewAccount")) {
			forward = VIEW;
			String email = request.getParameter("UserEmail");
			UsersBean user = dao.getUserByEmail(email);
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
		action = request.getParameter("action");
		if(action.equalsIgnoreCase("registerAdmin")) {
			try {

				
				String UserPassword = request.getParameter("UserPassword");
				String UserName = request.getParameter("UserName");
				String UserNoPhone = request.getParameter("UserNoPhone");
				String UserEmail = request.getParameter("UserEmail");



				UsersBean user = new UsersBean();

				
				user.setUserPassword(UserPassword);
				user.setUserName(UserName);
				user.setUserNoPhone(UserNoPhone);
				user.setUserEmail(UserEmail);


				dao = new UserDAO();
				user = UserDAO.getUser(user);

				if(!user.isValid()) { //if librarian is not valid, means librarian is not exist, so it is for register
					try {
						dao.AdminAdd(user);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('The account has been created');");
					pw.println("window.location.href='UserController?action=listAll';");
					pw.println("</script>");
				}
				else {
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Email or Admin is already exist');");
					pw.println("window.location.href='UserController?action=listAll';");
					pw.println("</script>");

				}

				
			}
			catch (Throwable ex) {
				System.out.println(ex);
			}
		}
		else if(action.equalsIgnoreCase("registerUser")) {
			try {
				
				String UserPassword = request.getParameter("UserPassword");
				String UserName = request.getParameter("UserName");
				String UserNoPhone = request.getParameter("UserNoPhone");
				String UserEmail = request.getParameter("UserEmail");



				UsersBean user = new UsersBean();

				
				user.setUserPassword(UserPassword);
				user.setUserName(UserName);
				user.setUserNoPhone(UserNoPhone);
				user.setUserEmail(UserEmail);


				dao = new UserDAO();
				user = UserDAO.getUser(user);

				if(!user.isValid()) { //if librarian is not valid, means librarian is not exist, so it is for register
					try {
						dao.UserAdd(user);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Account created Please login to continue.');");
					pw.println("window.location.href='/lofo/index.jsp';");
					pw.println("</script>");
				}
				else {
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Email is already exist Sign in to continue');");
					pw.println("window.location.href='/lofo/index.jsp';");
					pw.println("</script>");

				}
			}
			catch (Throwable ex) {
				System.out.println(ex);
			}
		}
	}
}



