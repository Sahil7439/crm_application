package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrg {
	WebDriver driver;
	
	public CreateOrg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement plusImgLink;
	
	@FindBy(name = "accountname")
	private WebElement orgNameTextfield;
	
	@FindBy(id = "phone") 
	private WebElement phoneTextfield;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	public WebElement getPlusImgLink() {
		return plusImgLink;
	}
	
	public WebElement getOrgNameTextfield() {
		return orgNameTextfield;
	}
	
	public WebElement getPhoneTextfield() {
		return phoneTextfield;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
