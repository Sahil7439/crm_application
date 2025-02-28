package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindow {
	public NewWindow(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement orgTextFeild;
	
	public WebElement getOrgTextFeild() {
		return orgTextFeild;
	}
	
	@FindBy(name = "search_field")
	private WebElement orgDropdown;
	
	public WebElement getOrgDropdown() {
		return orgDropdown;
	}
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
}
