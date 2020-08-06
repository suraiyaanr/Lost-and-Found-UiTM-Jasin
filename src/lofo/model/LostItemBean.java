package lofo.model;

import java.io.InputStream;

public class LostItemBean extends UsersBean
{
	private String LItemID;
	private String UserEmail;
	private String LItemName;
	private String LItemCategory;
	private String LItemDate;
	private String LItemTime;
	private String LItemLocation;
	private String LItemDescription;
	private InputStream LItemPhoto;
	private String photo;
	public boolean valid;
	public String getLItemID() {
		return LItemID;
	}
	public void setLItemID(String lItemID) {
		LItemID = lItemID;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getLItemName() {
		return LItemName;
	}
	public void setLItemName(String lItemName) {
		LItemName = lItemName;
	}
	public String getLItemCategory() {
		return LItemCategory;
	}
	public void setLItemCategory(String lItemCategory) {
		LItemCategory = lItemCategory;
	}
	public String getLItemDate() {
		return LItemDate;
	}
	public void setLItemDate(String lItemDate) {
		LItemDate = lItemDate;
	}
	public String getLItemTime() {
		return LItemTime;
	}
	public void setLItemTime(String lItemTime) {
		LItemTime = lItemTime;
	}
	public String getLItemLocation() {
		return LItemLocation;
	}
	public void setLItemLocation(String lItemLocation) {
		LItemLocation = lItemLocation;
	}
	public String getLItemDescription() {
		return LItemDescription;
	}
	public void setLItemDescription(String lItemDescription) {
		LItemDescription = lItemDescription;
	}
	public InputStream getLItemPhoto() {
		return LItemPhoto;
	}
	public void setLItemPhoto(InputStream lItemPhoto) {
		LItemPhoto = lItemPhoto;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}