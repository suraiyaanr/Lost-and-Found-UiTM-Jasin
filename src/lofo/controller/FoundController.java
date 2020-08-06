package lofo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import lofo.dao.UserDAO;
import lofo.dao.foundDAO;
import lofo.model.FoundItemBean;
import lofo.model.UsersBean;
import javax.servlet.annotation.MultipartConfig;
/**
 * Servlet implementation class UserController
 */
@WebServlet("/FoundController")
@MultipartConfig// upload file's size up to 16MB
public class FoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VIEW ="viewMyFound.jsp";
	private String VIEWONE ="viewFound.jsp";
	private String VIEWALL ="listAllFoundItem.jsp";
	private String VIEWALLMYPOST ="listFoundItem.jsp";
	private static String UPDATE = "updateFound.jsp";
	private static String DELETE = "deleteFound.jsp";
	private static String SEARCH = "registerFoundItem.jsp";

	String forward;
	private foundDAO dao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FoundController() {
		super();
		dao = new foundDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("viewMyFound")) {
			forward = VIEW;
			String FItemID = request.getParameter("FItemID");
			FoundItemBean found = foundDAO.getFoundByID(FItemID);
			List<FoundItemBean> founds = foundDAO.getAllFound();
			request.setAttribute("founds", founds );
			request.setAttribute("found", found);
		}
		else if(action.equalsIgnoreCase("viewFound")) {
			forward = VIEWONE;
			String FItemID = request.getParameter("FItemID");
			String UserEmail = request.getParameter("UserEmail");
			UsersBean user = UserDAO.getUserByEmail(UserEmail);
			FoundItemBean found = foundDAO.getFoundJoin(FItemID);
			request.setAttribute("found", found);
		}
		else if (action.equalsIgnoreCase("listAll")) {
			forward = VIEWALL;
			request.setAttribute("founds", foundDAO.getAllFound()); 

		}
		else if (action.equalsIgnoreCase("listAllMyPost")) {
			HttpSession session = request.getSession(true);
			String UserEmail = (String) session.getAttribute("currentSessionUser");
			forward = VIEWALLMYPOST;
			request.setAttribute("founds", foundDAO.getAllFoundByEmail(UserEmail)); 

		}
		else if (action.equalsIgnoreCase("updateFound")){
			forward = UPDATE;
			String FItemID = request.getParameter("FItemID");
			FoundItemBean found = foundDAO.getFoundByID(FItemID);
			List<FoundItemBean> founds = foundDAO.getAllFound();
			request.setAttribute("founds", founds);
			request.setAttribute("found", found);
		}
		else if (action.equalsIgnoreCase("search")){
			forward = SEARCH;
			List<FoundItemBean> found = foundDAO.getAllFound();
			request.setAttribute("founds", found);
		}
		else if (action.equalsIgnoreCase("deleteFound")){
			forward = DELETE;
			String FItemID = request.getParameter("FItemID");
			FoundItemBean found = foundDAO.getFoundByID(FItemID);
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

		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("deleteFound")) {//delete
			String FItemID = request.getParameter("FItemID");
			dao = new foundDAO();
			dao.deleteFound(FItemID);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('The account has been deleted');");
			pw.println("window.location.href='/lofo/FoundController?action=listAllMyPost';");
			pw.println("</script>");
		}
		else {
			String FItemID = request.getParameter("FItemID");
			String UserEmail = request.getParameter("UserEmail");
			String FItemName = request.getParameter("FItemName");
			String FItemCategory = request.getParameter("FItemCategory");;
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
			
			if(FItemPhoto.getSubmittedFileName().equalsIgnoreCase("")) { // Without image
				try {
					dao.updateFoundNoImage(found);
				} catch (NoSuchAlgorithmException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else { // With image

				// prints out some information for debugging
				System.out.println(FItemPhoto.getName());
				System.out.println(FItemPhoto.getSize());
				System.out.println(FItemPhoto.getContentType());

				// obtains input stream of the upload file
				inputStream = FItemPhoto.getInputStream();
				found.setFItemPhoto(inputStream);
	
				try {
					dao.updateFound(found);
				} catch (NoSuchAlgorithmException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('The account is updated');");
			pw.println("window.location.href='/lofo/FoundController?action=viewMyFound&FItemID="+ FItemID +"';");
			pw.println("</script>");
		}

	}
}
