package lofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lofo.dao.lostDAO;
import lofo.model.LostItemBean;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/LostRegisterController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class LostRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VIEW ="/lofo/viewLost.jsp";
	private lostDAO dao;
	String forward=""; 
	String action="";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LostRegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("viewLost")) {
			forward = VIEW;
			String LItemID = request.getParameter("LItemID");
			LostItemBean lost = dao.getLostByID(LItemID);
			request.setAttribute("lost", lost);
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
		try {

			String LItemID = request.getParameter("LItemID");
			String UserEmail = request.getParameter("UserEmail");
			String LItemName = request.getParameter("LItemName");
			String LItemCategory = request.getParameter("LItemCategory");
			String LItemDate = request.getParameter("LItemDate");
			String LItemTime = request.getParameter("LItemTime");
			String LItemLocation = request.getParameter("LItemLocation");
			String LItemDescription = request.getParameter("LItemDescription");
			InputStream inputStream = null;// input stream of the upload file
			LostItemBean lost = new LostItemBean();

			lost.setLItemID(LItemID);
			lost.setUserEmail(UserEmail);
			lost.setLItemName(LItemName);
			lost.setLItemCategory(LItemCategory);
			lost.setLItemDate(LItemDate);
			lost.setLItemTime(LItemTime);
			lost.setLItemLocation(LItemLocation);
			lost.setLItemDescription(LItemDescription);
			
			Part LItemPhoto = request.getPart("LItemPhoto");
		        if (LItemPhoto != null) {
		            // prints out some information for debugging
		            System.out.println(LItemPhoto.getName());
		            System.out.println(LItemPhoto.getSize());
		            System.out.println(LItemPhoto.getContentType());

		            // obtains input stream of the upload file
		            inputStream = LItemPhoto.getInputStream();
		            lost.setLItemPhoto(inputStream);
		        }

			dao = new lostDAO();
//			lost = lostDAO.getUser(lost);

			try {
				dao.LostAdd(lost);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('The item post has been created');");
			pw.println("window.location.href='LostController?action=listAllMyPost';");
			pw.println("</script>");
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}



