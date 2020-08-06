package lofo.dao;

import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import lofo.model.UsersBean;
import lofo.connection.ConnectionManager;




public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String UserPassword, UserName, UserNoPhone, UserEmail, UserRole, UserStatus;

	//login
	public static UsersBean login(UsersBean bean) throws NoSuchAlgorithmException {

		UserEmail = bean.getUserEmail();
		UserPassword = bean.getUserPassword();

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(UserPassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String pass = sb.toString();
		String searchQuery = "select * from USERS where USEREMAIL='" + UserEmail + "' AND UserPassword='" + pass + "'";

		System.out.println("Your email is " + UserEmail);
		System.out.println("Your password is " + UserPassword);
		System.out.println("Query: " + searchQuery);

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				String email = rs.getString("USEREMAIL");

				System.out.println("Welcome " + email);
				bean.setUserEmail(email);
				bean.setValid(true);
			}

			// if user does not exist set the isValid variable to false
			else if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
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
	//get user by email
	public static UsersBean getUserByEmail(String UserEmail) {
		UsersBean user = new UsersBean();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from users where useremail=?");

			ps.setString(1, UserEmail);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {


				user.setUserPassword(rs.getString("UserPassword"));
				user.setUserName(rs.getString("UserName"));
				user.setUserNoPhone(rs.getString("UserNoPhone"));
				user.setUserEmail(rs.getString("UserEmail"));
				user.setUserRole(rs.getString("UserRole"));
				user.setUserStatus(rs.getString("UserStatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	//create User
	public void UserAdd (UsersBean bean) throws NoSuchAlgorithmException {

		UserPassword = bean.getUserPassword();
		UserName = bean.getUserName();
		UserNoPhone = bean.getUserNoPhone();
		UserEmail = bean.getUserEmail();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(UserPassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String pass = sb.toString();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into users(username, usernophone, useremail, userrole, userstatus,userpassword)values((initcap(?)),?,?,?,?,?)");

			ps.setString(1,UserName);
			ps.setString(2,UserNoPhone);
			ps.setString(3,UserEmail);
			ps.setString(4,"User");
			ps.setString(5,"Active");
			ps.setString(6,pass);
			ps.executeUpdate();

			System.out.println("Your email is " + UserEmail);
			System.out.println("Your password is " + UserPassword);

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

	//create Admin
	public void AdminAdd (UsersBean bean) throws NoSuchAlgorithmException {

		UserPassword = bean.getUserPassword();
		UserName = bean.getUserName();
		UserNoPhone = bean.getUserNoPhone();
		UserEmail = bean.getUserEmail();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(UserPassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String pass = sb.toString();

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into users(username, usernophone, useremail, userrole, userstatus,userpassword)values((initcap(?)),?,?,?,?,?)");

			ps.setString(1,UserName);
			ps.setString(2,UserNoPhone);
			ps.setString(3,UserEmail);
			ps.setString(4,"Admin");
			ps.setString(5,"Active");
			ps.setString(6,pass);
			ps.executeUpdate();

			System.out.println("Your email is " + UserEmail);
			System.out.println("Your password is " + UserPassword);

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
	//get user use to check if user is exist or not
	public static UsersBean getUser(UsersBean bean)  {

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
	/*getallaccount

    public static UsersBean getUser() {
        UsersBean user = new UsersBean();
        try {
        	currentCon = ConnectionManager.getConnection();
            ps=currentCon.prepareStatement("select * from users");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setTeacherid(rs.getInt("teacherid"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setManagerid(rs.getInt("managerid"));
               // teacher.setAddress(rs.getString("address"));
               // teacher.setPhone(rs.getString("phone"));
                //teacher.setPassword(rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }*/


	//update account
	public void updateAccount(UsersBean bean, String email) throws NoSuchAlgorithmException {

		UserName = bean.getUserName();
		UserNoPhone = bean.getUserNoPhone();
		

		String searchQuery = "";


		searchQuery = "UPDATE users SET UserName ='"+ UserName +"', UserNoPhone='" + UserNoPhone + "' WHERE UserEmail= '" + email + "'";   	   
		System.out.println(searchQuery);


		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			System.out.println(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*public static UsersBean getUser(UsersBean bean)  {

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

    	 public void deleteUser(String UserID) {
    	        try {
    	        	currentCon = ConnectionManager.getConnection();
    	        	ps=currentCon.prepareStatement("delete from users where UserEmail=?");
    	            ps.setString(1, UserEmail);
    	            ps.executeUpdate();

    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }

    	 /*allteacher
    	 public static List<TeacherBean> getAllTeacher() {
   		  List<TeacherBean> teachers = new ArrayList<TeacherBean>();

   		  try {
   		  	currentCon = ConnectionManager.getConnection();
   		  	stmt = currentCon.createStatement();

   		  	  String q = "select * from teacher";
   		      ResultSet rs = stmt.executeQuery(q);

   		      while (rs.next()) {
   		          TeacherBean teacher = new TeacherBean();


   		          teacher.setTeacherid(rs.getInt("teacherid"));
   		          teacher.setName(rs.getString("name"));
   		          teacher.setPhone(rs.getString("phone"));
   		          teacher.setEmail(rs.getString("email"));
   		          teacher.setManagerid(rs.getInt("managerid"));
   		          teacher.setRole(rs.getString("role"));
   		          teachers.add(teacher);
   		      }
   		  } catch (SQLException e) {
   		      e.printStackTrace();
   		  }

   		  return teachers;
   	}*/
	//getAllAdmin
	public static List<UsersBean> getAllAdmin() {
		List<UsersBean> users = new ArrayList<UsersBean>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from users where userrole='Admin'";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				UsersBean user = new UsersBean();

				user.setUserName(rs.getString("UserName"));
				user.setUserEmail(rs.getString("UserEmail"));
				user.setUserNoPhone(rs.getString("UserNoPhone"));
				user.setUserRole(rs.getString("UserRole"));
				user.setUserStatus(rs.getString("UserStatus"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	//Get reported User tak repair lagi ada error
	public static List<UsersBean> getReportedUser() {
		List<UsersBean> users = new ArrayList<UsersBean>();

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			String q = "select * from users where userrstatus='Reported'";
			ResultSet rs = stmt.executeQuery(q);

			while (rs.next()) {
				UsersBean user = new UsersBean();

				user.setUserName(rs.getString("UserName"));
				user.setUserEmail(rs.getString("UserEmail"));
				user.setUserNoPhone(rs.getString("UserNoPhone"));
				user.setUserRole(rs.getString("UserRole"));
				user.setUserStatus(rs.getString("UserStatus"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	//get user password pakai kat password control untuk update password
	public static UsersBean getUserPassword(UsersBean bean) throws NoSuchAlgorithmException  {

		UserEmail = bean.getUserEmail();
		UserPassword = bean.getUserPassword();
		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(UserPassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String pass = sb.toString();
		String searchQuery = "select * from USERS where useremail='" + UserEmail + "' AND userpassword='"+ pass + "'";

		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				String UserEmail = rs.getString("UserEmail");

				bean.setUserEmail(UserEmail);
				bean.setUserPassword(pass);
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
	//update pass pakai kat passwordcontroller untuk update password
	public static void updatePass(UsersBean bean) throws NoSuchAlgorithmException {


		UserEmail = bean.getUserEmail();
		UserPassword = bean.getUserPassword();


		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(UserPassword.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String pass = sb.toString();

		String searchQuery = "UPDATE users SET  userpassword='" + pass +"' WHERE useremail = '" + UserEmail + "'";

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
