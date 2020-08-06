package lofo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lofo.dao.UserDAO;
import lofo.model.UsersBean;


@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO dao;
	HttpServletRequest request;
	HttpServletResponse response;
	String forward="";
	String action=""; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginController() {
		super();
		dao = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		HttpSession session = request.getSession(true);
		if (action.equalsIgnoreCase("Logout")){ //logout
			session.setAttribute("currentSessionUser", null);
			session.setAttribute("currentSessionUserRole", null);
			session.invalidate();

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('Logout Success');");
			pw.println("window.location.href='/lofo/index.jsp';");
			pw.println("</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		if(action.equalsIgnoreCase("AdminLogin")) {
			try {

				String email = request.getParameter("UserEmail");
				String password = request.getParameter("UserPassword");

				UsersBean user = new UsersBean();
				user.setUserEmail(email);
				user.setUserPassword(password);

				user = UserDAO.login(user);

				if(user.isValid())
				{
					user = UserDAO.getUserByEmail(email);
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", user.getUserEmail());
					session.setAttribute("currentSessionUserRole", user.getUserRole());
					session.setAttribute("currentSessionUserStatus", user.getUserStatus());
					session.setAttribute("currentSessionUserName", user.getUserName());
					session.setAttribute("currentSessionUserNoPhone", user.getUserNoPhone());
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Login Successful');");
					pw.println("window.location.href='/lofo/searchForm.jsp';");
					pw.println("</script>");
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Incorrect Email or Password');");
					pw.println("window.location.href='/lofo/index.jsp';");
					pw.println("</script>");
				}

			}

			catch (Throwable ex) {
				System.out.println(ex);
			}

		}
		
		
		else if(action.equalsIgnoreCase("UserLogin")) {

			try {

				String email = request.getParameter("UserEmail");
				String password = request.getParameter("UserPassword");

				UsersBean user = new UsersBean();
				user.setUserEmail(email);
				user.setUserPassword(password);

				user = UserDAO.login(user);

				if(user.isValid())
				{
					user = UserDAO.getUserByEmail(email);
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", user.getUserEmail());
					session.setAttribute("currentSessionUserRole", user.getUserRole());
					session.setAttribute("currentSessionUserStatus", user.getUserStatus());
					session.setAttribute("currentSessionUserName", user.getUserName());
					session.setAttribute("currentSessionUserNoPhone", user.getUserNoPhone());
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Login Successful');");
					pw.println("window.location.href='/lofo/searchForm.jsp';");
					pw.println("</script>");
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.println("<script>");
					pw.println("alert('Incorrect Email or Password');");
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
