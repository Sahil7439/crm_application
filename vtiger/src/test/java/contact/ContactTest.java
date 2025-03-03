package contact;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genricUtility.BaseClass;
import objectRepo.NewWindow;

public class ContactTest extends BaseClass {
	static String exPath = "C:\\automation\\src\\test\\resources\\vtiger.xlsx";

	@Test
	public void CreateContactLastNameTest() throws IOException {
		String orgName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 0);
		String lastName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 4);

//		Home Page
		hp.getContactLink().click();

//		Contact Window
		con.getPlusImgIconLink().click();
		con.getLastNameTextField().sendKeys(lastName);
		con.getSaveBtn().click();
	}

	@Test
	public void contactLastnameWithOrgname() throws IOException {
		String orgName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 0);
		String lastName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 4);
//		Home Page
		hp.getContactLink().click();

//		Contact Window
		con.getPlusImgIconLink().click();
		con.getLastNameTextField().sendKeys(lastName);
		con.getOrgNamePlusIconLink().click();

//			Switching to another Window:
		Set<String> ids = driver.getWindowHandles();
		String pId = driver.getWindowHandle();
		for (String id : ids) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.equals(null)) {
				break;
			}
		}

//		New Window 
		NewWindow newWin = new NewWindow(driver);
		newWin.getOrgTextFeild().sendKeys(orgName);
		Select slt = new Select(newWin.getOrgDropdown());
		slt.selectByVisibleText("Organization Name");
		newWin.getSearchButton().click();
		driver.findElement(By.linkText("Qspiders_")).click();

//		Switch back to parent window:
		driver.switchTo().window(pId);
		con.getSaveBtn().click();
	}
}
