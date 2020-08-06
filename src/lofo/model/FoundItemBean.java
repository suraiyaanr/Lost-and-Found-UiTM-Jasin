package lofo.model;
import java.io.InputStream;


public class FoundItemBean extends UsersBean
{
	private String FItemID;
	private String UserEmail;
	private String FItemName;
	private String FItemCategory;
	private String FItemDate;
	private String FItemTime;
	private String FItemLocation;
	private String FItemDescription;
	private InputStream FItemPhoto;
	private String photo;
	public boolean valid;
	
	public String getFItemID() 
	{
		return FItemID;
	}
	public void setFItemID(String fItemID) 
	{
		FItemID = fItemID;
	}
	public String getUserEmail() 
	{
		return UserEmail;
	}
	public void setUserEmail(String userEmail) 
	{
		UserEmail = userEmail;
	}
	public String getFItemName() 
	{
		return FItemName;
	}
	public void setFItemName(String fItemName) 
	{
		FItemName = fItemName;
	}
	public String getFItemCategory() 
	{
		return FItemCategory;
	}
	public void setFItemCategory(String fItemCategory) 
	{
		FItemCategory = fItemCategory;
	}
	public String getFItemDate() 
	{
		return FItemDate;
	}
	public void setFItemDate(String fItemDate) 
	{
		FItemDate = fItemDate;
	}
	public String getFItemTime() 
	{
		return FItemTime;
	}
	public void setFItemTime(String fItemTime) 
	{
		FItemTime = fItemTime;
	}
	public String getFItemLocation() 
	{
		return FItemLocation;
	}
	public void setFItemLocation(String fItemLocation) 
	{
		FItemLocation = fItemLocation;
	}
	public String getFItemDescription() 
	{
		return FItemDescription;
	}
	public void setFItemDescription(String fItemDescription) 
	{
		FItemDescription = fItemDescription;
	}

	public InputStream getFItemPhoto() {
		return FItemPhoto;
	}
	public void setFItemPhoto(InputStream fItemPhoto) {
		FItemPhoto = fItemPhoto;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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