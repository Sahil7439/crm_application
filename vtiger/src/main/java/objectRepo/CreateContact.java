package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {
	WebDriver driver;
	
	public CreateContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement plusImgIconLink;
	public WebElement getPlusImgIconLink( ) {
		return plusImgIconLink;
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextfield;
	public WebElement getLastNameTextField() {
		return lastNameTextfield;
	}
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement orgNamePlusIconLink;
	public WebElement getOrgNamePlusIconLink() {
		return orgNamePlusIconLink;
	}
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
