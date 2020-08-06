package lofo.model;

public class UsersBean 
{
	
	private String UserPassword;
	private String UserName;
	private String UserNoPhone;
	private String UserEmail;
	private String UserRole;
	private String UserStatus; 
	public boolean valid;
	
	
	
	public String getUserPassword() 
	{
		return UserPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.UserPassword = userPassword;
	}
	public String getUserName() 
	{
		return UserName;
	}
	public void setUserName(String userName) 
	{
		this.UserName = userName;
	}
	public String getUserNoPhone() 
	{
		return UserNoPhone;
	}
	public void setUserNoPhone(String string) 
	{
		this.UserNoPhone = string;
	}
	public String getUserEmail() 
	{
		return UserEmail;
	}
	public void setUserEmail(String userEmail) 
	{
		this.UserEmail = userEmail;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		this.UserRole = userRole;
	}
	public String getUserStatus() {
		return UserStatus;
	}
	public void setUserStatus(String userStatus) {
		this.UserStatus = userStatus;
	}
	public boolean isValid() 
	{
		return valid;
	}
	public void setValid(boolean valid) 
	{
		this.valid = valid;
	}
	
	
	
	

}
