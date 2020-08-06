package lofo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lofo.dao.foundDAO;
import lofo.model.FoundItemBean;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/FoundRegisterController")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class FoundRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VIEW ="/lofo/viewFound.jsp";
	private foundDAO dao;
	String forward=""; 
	String action="";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoundRegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("viewFound")) {
			forward = VIEW;
			String FItemID = request.getParameter("FItemID");
			FoundItemBean found = dao.getFoundByID(FItemID);
			request.setAttribute("found", found);
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

			String FItemID = request.getParameter("FItemID");
			String UserEmail = request.getParameter("UserEmail");
			String FItemName = request.getParameter("FItemName");
			String FItemCategory = request.getParameter("FItemCategory");
			String FItemDate = request.getParameter("FItemDate");
			String FItemTime = request.getParameter("FItemTime");
			String FItemLocation = request.getParameter("FItemLocation");
			String FItemDescription = request.getParameter("FItemDescription");
			InputStream inputStream = null;// input stream of the upload file
			FoundItemBean found = new FoundItemBean();

			found.setFItemID(FItemID);
			found.setUserEmail(UserEmail);
			found.setFItemName(FItemName);
			found.setFItemCategory(FItemCategory);
			found.setFItemDate(FItemDate);
			found.setFItemTime(FItemTime);
			found.setFItemLocation(FItemLocation);
			found.setFItemDescription(FItemDescription);
			
			Part FItemPhoto = request.getPart("FItemPhoto");
		        if (FItemPhoto != null) {
		            // prints out some information for debugging
		            System.out.println(FItemPhoto.getName());
		            System.out.println(FItemPhoto.getSize());
		            System.out.println(FItemPhoto.getContentType());

		            // obtains input stream of the upload file
		            inputStream = FItemPhoto.getInputStream();
		            found.setFItemPhoto(inputStream);
		        }

			dao = new foundDAO();
//			found = foundDAO.getUser(found);

			try {
				dao.FoundAdd(found);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('The item post has been created');");
			pw.println("window.location.href='FoundController?action=listAllMyPost';");
			pw.println("</script>");
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}



