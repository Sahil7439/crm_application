package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	public WebElement orgLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	@FindBy(linkText = "Contacts")
	public WebElement contactLink;

	public WebElement getContactLink() {
		return contactLink;
	}

//	For Logout
	@FindBy(xpath = "//span[@class='userName']/../following-sibling::td[@class='small']/img")
	public WebElement personImgLink;

	public WebElement getPersonImglink() {
		return personImgLink;
	}

	@FindBy(linkText = "Sign Out")
	public WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void logoutMethod(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(getPersonImglink()).build().perform();
		act.click(getLogoutLink()).build().perform();
	}
}
