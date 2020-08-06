package lofo.controller;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import lofo.dao.UserDAO;
import lofo.dao.foundDAO;
import lofo.dao.lostDAO;
import lofo.model.FoundItemBean;
import lofo.model.LostItemBean;
import lofo.model.UsersBean;

/**
 * Servlet implementation class LostController
 */
@WebServlet("/LostController")
@MultipartConfig
public class LostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VIEW ="viewMyLost.jsp";
	private String VIEWONE ="viewLost.jsp";
	private String VIEWALL ="listAllLostItem.jsp";
	private String VIEWALLMYPOST ="listLostItem.jsp";
	private static String UPDATE = "updateLost.jsp";
	private static String DELETE = "deleteLost.jsp";
	private static String SEARCH = "registerLostItem.jsp";

	String forward;
	private lostDAO dao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LostController() {
		super();
		dao = new lostDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("viewMyLost")) {
			forward = VIEW;
			String LItemID = request.getParameter("LItemID");
			LostItemBean lost = lostDAO.getLostByID(LItemID);
			List<LostItemBean> losts = lostDAO.getAllLost();
			request.setAttribute("losts", losts );
			request.setAttribute("lost", lost);
		}
		else if(action.equalsIgnoreCase("viewLost")) {
			forward = VIEWONE;
			String LItemID = request.getParameter("LItemID");
			String UserEmail = request.getParameter("UserEmail");
			UsersBean user = UserDAO.getUserByEmail(UserEmail);
			LostItemBean lost = lostDAO.getLostJoin(LItemID);
			request.setAttribute("lost", lost);
		}
		else if (action.equalsIgnoreCase("listAll")) {
			forward = VIEWALL;
			request.setAttribute("losts", lostDAO.getAllLost()); 

		}
		else if (action.equalsIgnoreCase("listAllMyPost")) {
			HttpSession session = request.getSession(true);
			String UserEmail = (String) session.getAttribute("currentSessionUser");
			forward = VIEWALLMYPOST;
			request.setAttribute("losts", lostDAO.getAllLostByEmail(UserEmail)); 

		}
		else if (action.equalsIgnoreCase("updateLost")){
			forward = UPDATE;
			String LItemID = request.getParameter("LItemID");
			LostItemBean lost = lostDAO.getLostByID(LItemID);
			List<LostItemBean> losts = lostDAO.getAllLost();
			request.setAttribute("losts", losts);
			request.setAttribute("lost", lost);
		}
		else if (action.equalsIgnoreCase("search")){
			forward = SEARCH;
			List<LostItemBean> lost = lostDAO.getAllLost();
			request.setAttribute("losts", lost);
		}
		else if (action.equalsIgnoreCase("deleteLost")){
			forward = DELETE;
			String LItemID = request.getParameter("LItemID");
			LostItemBean lost = lostDAO.getLostByID(LItemID);
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
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("updateLost")) {
			String LItemID = request.getParameter("LItemID");
			String UserEmail = request.getParameter("UserEmail");
			String LItemName = request.getParameter("LItemName");
			String LItemCategory = request.getParameter("LItemCategory");;
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
			if(LItemPhoto.getSubmittedFileName().equalsIgnoreCase("")) { // Without image
				try {
					dao.updateLostNoImage(lost);
				} catch (NoSuchAlgorithmException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else { // With image

				// prints out some information for debugging
				System.out.println(LItemPhoto.getName());
				System.out.println(LItemPhoto.getSize());
				System.out.println(LItemPhoto.getContentType());

				// obtains input stream of the upload file
				inputStream = LItemPhoto.getInputStream();
				lost.setLItemPhoto(inputStream);
	
				try {
					dao.updateLost(lost);
				} catch (NoSuchAlgorithmException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('The account is updated');");
			pw.println("window.location.href='/lofo/LostController?action=viewMyLost&LItemID="+ LItemID +"';");
			pw.println("</script>");
		}

	}
}
