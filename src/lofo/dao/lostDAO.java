package lofo.dao;


import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import lofo.model.FoundItemBean;
import lofo.model.LostItemBean;
import lofo.model.UsersBean;
import lofo.connection.ConnectionManager;

public class lostDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String LItemID, UserEmail, LItemName, LItemCategory, LItemDate, LItemTime, LItemLocation, LItemDescription;
	static InputStream LItemPhoto;

	public static LostItemBean getUser(LostItemBean bean)  {

		UserEmail = bean.getUserEmail();

		String searchQuery = "select * from users where useremail='" + UserEmail + "'";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				String UserEmail = rs.getString("UserEmail");

				bean.setUserEmail(UserEmail);
				bean.setValid(true);
			}

			else if (!more) {
				System.out.println("Sorry");
				bean.setValid(false);
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;
	}

	//get lost by ID
	public static LostItemBean getLostByID(String LItemID) throws IOException {
		LostItemBean lost = new LostItemBean();
		String base64Image = "", x = "";
		InputStream inputStream;
		Blob img;
		int bytesRead = -1;
		byte[] imageBytes;

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from LOSTitem where LITEMID =?");

			ps.setString(1, LItemID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				lost.setLItemID(rs.getString("LItemID"));
				lost.setUserEmail(rs.getString("UserEmail"));
				lost.setLItemName(rs.getString("LItemName"));
				lost.setLItemCategory(rs.getString("LItemCategory"));
				lost.setLItemDate(rs.getString("LItemDate"));
				lost.setLItemTime(rs.getString("LItemTime"));
				lost.setLItemLocation(rs.getString("LItemLocation"));
				lost.setLItemDescription(rs.getString("LItemDescription"));

				img = rs.getBlob("LItemPhoto");
				inputStream = img.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				imageBytes = outputStream.toByteArray();
				base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				x = "data:image/jpg;base64,"+base64Image;

				lost.setPhoto(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lost;
	}
	//get lost by ID join dengan user
	public static LostItemBean getLostJoin(String LItemID) throws IOException {
		LostItemBean lost = new LostItemBean();
		String base64Image = "", x = "";
		InputStream inputStream;
		Blob img;
		int bytesRead = -1;
		byte[] imageBytes;
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select u.username, u.useremail, u.usernophone,l.litemid,l.litemphoto, l.litemname,"
					+ "l.litemcategory, l.litemdate,l.LITEMTIME,l.LITEMLOCATION,l.LITEMDESCRIPTION from USERS u join LOSTITEM l on u.USEREMAIL = l.USEREMAIL where l.litemid = ?");

			ps.setString(1, LItemID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				lost.setUserName(rs.getString(1));
				lost.setUserNoPhone(rs.getString(3));
				lost.setLItemID(rs.getString("LItemID"));
				lost.setUserEmail(rs.getString("UserEmail"));
				lost.setLItemName(rs.getString("LItemName"));
				lost.setLItemCategory(rs.getString("LItemCategory"));
				lost.setLItemDate(rs.getString("LItemDate"));
				lost.setLItemTime(rs.getString("LItemTime"));
				lost.setLItemLocation(rs.getString("LItemLocation"));
				lost.setLItemDescription(rs.getString("LItemDescription"));
				img = rs.getBlob("LItemPhoto");
				inputStream = img.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				imageBytes = outputStream.toByteArray();
				base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				x = "data:image/jpg;base64,"+base64Image;

				lost.setPhoto(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lost;
	}
	//create Lost Item
	public void LostAdd (LostItemBean bean) throws NoSuchAlgorithmException {


		LItemID = bean.getLItemID();
		UserEmail = bean.getUserEmail();
		LItemName = bean.getLItemName();
		LItemCategory = bean.getLItemCategory();
		LItemDate = bean.getLItemDate();
		LItemTime = bean.getLItemTime();
		LItemLocation = bean.getLItemLocation();
		LItemDescription = bean.getLItemDescription();
		LItemPhoto = bean.getLItemPhoto();

		try {
			currentCon = ConnectionManager.getConnection(); 
			/*ps=currentCon.prepareStatement("insert into lostitem(LItemID, UserEmail, LItemName, LItemCategory, LItemDate, LItemTime, LItemLocation, LItemDescription) values "
					+ "(LOSTITEM_SEQ.nextval,?,?,?,?,?,?,?)");*/
			ps=currentCon.prepareStatement("insert into lostitem(LItemID, UserEmail, LItemName, LItemCategory, LItemDate, LItemTime, LItemLocation, LItemDescription, LItemPhoto) values (LOSTITEM_SEQ.nextval,?,?,?,?,?,?,?,?)");

			ps.setString(1,UserEmail);
			ps.setString(2,LItemName);
			ps.setString(3,LItemCategory);
			ps.setString(4,LItemDate);
			ps.setString(5,LItemTime);
			ps.setString(6,LItemLocation);
			ps.setString(7,LItemDescription);
			ps.setBinaryStream(8, LItemPhoto, LItemPhoto.available());
			ps.executeUpdate();
			System.out.println("Your FItemName is " + LItemName);
			//System.out.println("Your FItemPhoto is " + FItemPhoto);

		}

		catch (Exception ex) {
			System.out.println("failed: An Exception has occured!" + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;

			}
		}
	}

	//update lost with image
	public void updateLost(LostItemBean bean) throws NoSuchAlgorithmException, SQLException, IOException {

		LItemID = bean.getLItemID();
		LItemName = bean.getLItemName();
		LItemCategory = bean.getLItemCategory();
		LItemDate = bean.getLItemDate();
		LItemTime = bean.getLItemTime();
		LItemLocation = bean.getLItemLocation();
		LItemDescription = bean.getLItemDescription();
		LItemPhoto = bean.getLItemPhoto();

		currentCon = ConnectionManager.getConnection(); 
		ps=currentCon.prepareStatement("UPDATE lostitem SET LItemID = ? ,LItemName = ? , LItemCategory= ? , LItemDate= ? , " + 
				"LItemTime= ? , LItemLocation= ? , LItemDescription= ?, LItemPhoto=  ? WHERE LITEMID= ? ");
		try {
			ps.setString(1,LItemID);
			ps.setString(2,LItemName);
			ps.setString(3,LItemCategory);
			ps.setString(4,LItemDate);
			ps.setString(5,LItemTime);
			ps.setString(6,LItemLocation);
			ps.setString(7,LItemDescription);
			ps.setBinaryStream(8, LItemPhoto, LItemPhoto.available());
			ps.setString(9,LItemID);
			ps.executeUpdate();
			System.out.println("Your LItemName is " + LItemName);
			//System.out.println("Your FItemPhoto is " + FItemPhoto);
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occured!" + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;

			}
		}
	}
	//update lost without image
	public void updateLostNoImage(LostItemBean bean) throws NoSuchAlgorithmException, SQLException, IOException {

		LItemID = bean.getLItemID();
		LItemName = bean.getLItemName();
		LItemCategory = bean.getLItemCategory();
		LItemDate = bean.getLItemDate();
		LItemTime = bean.getLItemTime();
		LItemLocation = bean.getLItemLocation();
		LItemDescription = bean.getLItemDescription();

		currentCon = ConnectionManager.getConnection(); 
		ps=currentCon.prepareStatement("UPDATE lostitem SET LItemID = ? ,LItemName = ? , LItemCategory= ? , LItemDate= ? , " + 
				"LItemTime= ? , LItemLocation= ? , LItemDescription= ? WHERE LITEMID= ? ");
		try {
			ps.setString(1,LItemID);
			ps.setString(2,LItemName);
			ps.setString(3,LItemCategory);
			ps.setString(4,LItemDate);
			ps.setString(5,LItemTime);
			ps.setString(6,LItemLocation);
			ps.setString(7,LItemDescription);
			ps.setString(8,LItemID);
			ps.executeUpdate();
			System.out.println("Your LItemName is " + LItemName);
			//System.out.println("Your FItemPhoto is " + FItemPhoto);
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occured!" + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;

			}
		}
	}
	//getAllLost for list table
	public static List<LostItemBean> getAllLost() throws IOException {
		List<LostItemBean> losts = new ArrayList<LostItemBean>();
		String base64Image = "", x = "";
		InputStream inputStream;
		Blob img;
		int bytesRead = -1;
		byte[] imageBytes;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from lostitem";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				LostItemBean lost = new LostItemBean();

				lost.setLItemID(rs.getString("LItemID"));
				lost.setUserEmail(rs.getString("UserEmail"));
				lost.setLItemName(rs.getString("LItemName"));
				lost.setLItemCategory(rs.getString("LItemCategory"));
				lost.setLItemDate(rs.getString("LItemDate"));
				lost.setLItemTime(rs.getString("LItemTime"));
				lost.setLItemLocation(rs.getString("LItemLocation"));
				lost.setLItemDescription(rs.getString("LItemDescription"));
				img = rs.getBlob("LItemPhoto");
				inputStream = img.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				imageBytes = outputStream.toByteArray();
				base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				x = "data:image/jpg;base64,"+base64Image;

				lost.setPhoto(x);
				losts.add(lost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return losts;
	}

	// getAllLost for list table
	public static List<LostItemBean> getAllLostByEmail(String UserEmail) throws IOException {
		List<LostItemBean> losts = new ArrayList<LostItemBean>();
		String base64Image = "", x = "";
		InputStream inputStream;
		Blob img;
		int bytesRead = -1;
		byte[] imageBytes;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from lostitem where useremail = '"+ UserEmail +"'";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				LostItemBean lost = new LostItemBean();

				lost.setLItemID(rs.getString("LItemID"));
				lost.setUserEmail(rs.getString("UserEmail"));
				lost.setLItemName(rs.getString("LItemName"));
				lost.setLItemCategory(rs.getString("LItemCategory"));
				lost.setLItemDate(rs.getString("LItemDate"));
				lost.setLItemTime(rs.getString("LItemTime"));
				lost.setLItemLocation(rs.getString("LItemLocation"));
				lost.setLItemDescription(rs.getString("LItemDescription"));
				img = rs.getBlob("LItemPhoto");
				inputStream = img.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				imageBytes = outputStream.toByteArray();
				base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				x = "data:image/jpg;base64,"+base64Image;

				lost.setPhoto(x);
				losts.add(lost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return losts;
	}
	public void deleteLost(String LItemID) {
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("delete from lostitem where LItemID=?");
			ps.setString(1, LItemID);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}