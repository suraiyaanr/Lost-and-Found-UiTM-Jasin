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
import lofo.model.UsersBean;
import lofo.connection.ConnectionManager;

public class foundDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String FItemID, UserEmail, FItemName, FItemCategory, FItemDate, FItemTime, FItemLocation, FItemDescription;
	static InputStream FItemPhoto;

	 public static FoundItemBean getUser(FoundItemBean bean)  {
     	
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
	
	//get found by ID
	public static FoundItemBean getFoundByID(String FItemID) throws IOException {
		FoundItemBean found = new FoundItemBean();
		String base64Image = "", x = "";
        InputStream inputStream;
        Blob img;
        int bytesRead = -1;
        byte[] imageBytes;
        
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from founditem where FITEMID =?");

			ps.setString(1, FItemID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				found.setFItemID(rs.getString("FItemID"));
				found.setUserEmail(rs.getString("UserEmail"));
				found.setFItemName(rs.getString("FItemName"));
				found.setFItemCategory(rs.getString("FItemCategory"));
				found.setFItemDate(rs.getString("FItemDate"));
				found.setFItemTime(rs.getString("FItemTime"));
				found.setFItemLocation(rs.getString("FItemLocation"));
				found.setFItemDescription(rs.getString("FItemDescription"));
				
				img = rs.getBlob("FItemPhoto");
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
                
                found.setPhoto(x);
                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return found;
	}
	
	//get found by ID join dengan user
		public static FoundItemBean getFoundJoin(String FItemID) throws IOException {
			FoundItemBean found = new FoundItemBean();
			String base64Image = "", x = "";
	        InputStream inputStream;
	        Blob img;
	        int bytesRead = -1;
	        byte[] imageBytes;
			try {
				currentCon = ConnectionManager.getConnection();
				ps=currentCon.prepareStatement("select u.username, u.useremail, u.usernophone,f.fitemid,f.fitemphoto, f.fitemname,"
						+ "f.fitemcategory, f.fitemdate,f.FITEMTIME,f.FITEMLOCATION,f.FITEMDESCRIPTION from USERS u join FOUNDITEM f on u.USEREMAIL = f.USEREMAIL where f.fitemid = ?");

				ps.setString(1, FItemID);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					
					found.setUserName(rs.getString(1));
					found.setUserNoPhone(rs.getString(3));
					found.setFItemID(rs.getString("FItemID"));
					found.setUserEmail(rs.getString("UserEmail"));
					found.setFItemName(rs.getString("FItemName"));
					found.setFItemCategory(rs.getString("FItemCategory"));
					found.setFItemDate(rs.getString("FItemDate"));
					found.setFItemTime(rs.getString("FItemTime"));
					found.setFItemLocation(rs.getString("FItemLocation"));
					found.setFItemDescription(rs.getString("FItemDescription"));
					img = rs.getBlob("FItemPhoto");
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
	                
	                found.setPhoto(x);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return found;
		}
	

	//create Found Item
	public void FoundAdd (FoundItemBean bean) throws NoSuchAlgorithmException {


		FItemID = bean.getFItemID();
		UserEmail = bean.getUserEmail();
		FItemName = bean.getFItemName();
		FItemCategory = bean.getFItemCategory();
		FItemDate = bean.getFItemDate();
		FItemTime = bean.getFItemTime();
		FItemLocation = bean.getFItemLocation();
		FItemDescription = bean.getFItemDescription();
		FItemPhoto = bean.getFItemPhoto();

		try {
			currentCon = ConnectionManager.getConnection(); 
			//ps=currentCon.prepareStatement("insert into founditem(FItemID, UserEmail, FItemName, FItemCategory, FItemDate, FItemTime, FItemLocation, FItemDescription) values (FOUNDITEM_SEQ.nextval,?,?,?,?,?,?,?)");
			ps=currentCon.prepareStatement("insert into founditem(FItemID, UserEmail, FItemName, FItemCategory, FItemDate, FItemTime, FItemLocation, FItemDescription, FItemPhoto) values (FOUNDITEM_SEQ.nextval,?,?,?,?,?,?,?,?)");

			ps.setString(1,UserEmail);
			ps.setString(2,FItemName);
			ps.setString(3,FItemCategory);
			ps.setString(4,FItemDate);
			ps.setString(5,FItemTime);
			ps.setString(6,FItemLocation);
			ps.setString(7,FItemDescription);
			ps.setBinaryStream(8, FItemPhoto, FItemPhoto.available());
			ps.executeUpdate();
			System.out.println("Your FItemName is " + FItemName);
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

	//update found with image
	public void updateFound(FoundItemBean bean) throws NoSuchAlgorithmException, SQLException, IOException {
		
		FItemID = bean.getFItemID();
		FItemName = bean.getFItemName();
		FItemCategory = bean.getFItemCategory();
		FItemDate = bean.getFItemDate();
		FItemTime = bean.getFItemTime();
		FItemLocation = bean.getFItemLocation();
		FItemDescription = bean.getFItemDescription();
		FItemPhoto = bean.getFItemPhoto();
		
		currentCon = ConnectionManager.getConnection(); 
		ps=currentCon.prepareStatement("UPDATE founditem SET FItemID = ? ,FItemName = ? , FItemCategory= ? , FItemDate= ? , " + 
							 "FItemTime= ? , FItemLocation= ? , FItemDescription= ?, FItemPhoto=  ? WHERE FITEMID= ? ");
		try {
		ps.setString(1,FItemID);
		ps.setString(2,FItemName);
		ps.setString(3,FItemCategory);
		ps.setString(4,FItemDate);
		ps.setString(5,FItemTime);
		ps.setString(6,FItemLocation);
		ps.setString(7,FItemDescription);
		ps.setBinaryStream(8, FItemPhoto, FItemPhoto.available());
		ps.setString(9,FItemID);
		ps.executeUpdate();
		System.out.println("Your FItemName is " + FItemName);
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
	
	//update found without image
		public void updateFoundNoImage(FoundItemBean bean) throws NoSuchAlgorithmException, SQLException, IOException {
			
			FItemID = bean.getFItemID();
			FItemName = bean.getFItemName();
			FItemCategory = bean.getFItemCategory();
			FItemDate = bean.getFItemDate();
			FItemTime = bean.getFItemTime();
			FItemLocation = bean.getFItemLocation();
			FItemDescription = bean.getFItemDescription();
			
			currentCon = ConnectionManager.getConnection(); 
			ps=currentCon.prepareStatement("UPDATE founditem SET FItemID = ? ,FItemName = ? , FItemCategory= ? , FItemDate= ? , " + 
								 "FItemTime= ? , FItemLocation= ? , FItemDescription= ?  WHERE FITEMID= ? ");
			try {
			ps.setString(1,FItemID);
			ps.setString(2,FItemName);
			ps.setString(3,FItemCategory);
			ps.setString(4,FItemDate);
			ps.setString(5,FItemTime);
			ps.setString(6,FItemLocation);
			ps.setString(7,FItemDescription);
			ps.setString(8,FItemID);
			ps.executeUpdate();
			System.out.println("Your FItemName is " + FItemName);
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

	//getAllFound for list table
	public static List<FoundItemBean> getAllFound() throws IOException {
		List<FoundItemBean> founds = new ArrayList<FoundItemBean>();
		String base64Image = "", x = "";
        InputStream inputStream;
        Blob img;
        int bytesRead = -1;
        byte[] imageBytes;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from founditem";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				FoundItemBean found = new FoundItemBean();
				
				found.setFItemID(rs.getString("FItemID"));
				found.setUserEmail(rs.getString("UserEmail"));
				found.setFItemName(rs.getString("FItemName"));
				found.setFItemCategory(rs.getString("FItemCategory"));
				found.setFItemDate(rs.getString("FItemDate"));
				found.setFItemTime(rs.getString("FItemTime"));
				found.setFItemLocation(rs.getString("FItemLocation"));
				found.setFItemDescription(rs.getString("FItemDescription"));
				
				img = rs.getBlob("FItemPhoto");
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
                
                found.setPhoto(x);
				founds.add(found);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return founds;
	}
	
	// getAllFoundByEmail for list table
	public static List<FoundItemBean> getAllFoundByEmail(String UserEmail) throws IOException {
		List<FoundItemBean> founds = new ArrayList<FoundItemBean>();
		String base64Image = "", x = "";
        InputStream inputStream;
        Blob img;
        int bytesRead = -1;
        byte[] imageBytes;

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from founditem where useremail = '"+ UserEmail +"'";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				FoundItemBean found = new FoundItemBean();

				found.setFItemID(rs.getString("FItemID"));
				found.setUserEmail(rs.getString("UserEmail"));
				found.setFItemName(rs.getString("FItemName"));
				found.setFItemCategory(rs.getString("FItemCategory"));
				found.setFItemDate(rs.getString("FItemDate"));
				found.setFItemTime(rs.getString("FItemTime"));
				found.setFItemLocation(rs.getString("FItemLocation"));
				found.setFItemDescription(rs.getString("FItemDescription"));
				
				img = rs.getBlob("FItemPhoto");
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
                
                found.setPhoto(x);
				
				founds.add(found);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return founds;
	}
	 public void deleteFound(String FItemID) {
	        try {
	        	currentCon = ConnectionManager.getConnection();
	        	ps=currentCon.prepareStatement("delete from founditem where FItemID=?");
	            ps.setString(1, FItemID);
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}