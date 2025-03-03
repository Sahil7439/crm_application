package organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genricUtility.BaseClass;

public class orgTest extends BaseClass {
	static String exPath = "C:\\automation\\src\\test\\resources\\vtiger.xlsx";

	@Test(groups = "Functionality Test")
	public void CreateOrgNameTest() throws InterruptedException, IOException {
//		Accessing Data from Excel File
		String orgName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 0);

//		Home Window
		hp.getOrgLink().click();
		
//		Organization Window:
		creOrg.getPlusImgLink().click();
		creOrg.getOrgNameTextfield().sendKeys(orgName + ju.generateRandomNumber());
		creOrg.getSaveBtn().click();
	}

	@Test(groups = "Regression Test")
	public void orgNameWithIndustryTest() throws IOException {
		String orgName = fu.getDatafromExcelFile(exPath, "OrgTestData", 1, 0);
		String indName = fu.getDatafromExcelFile(exPath, "OrgTestData", 1, 2);
//		HomePage 
		hp.getOrgLink().click();

//		Organization Window:
		creOrg.getPlusImgLink().click();
		creOrg.getOrgNameTextfield().sendKeys(orgName + ju.generateRandomNumber());

//		Make WebDriver utility Class
		Select slt = new Select(creOrg.getIndustryDropdown());
		slt.selectByVisibleText(indName);
		creOrg.getSaveBtn().click();
	}

	@Test(groups = "Smoke Test")
	public void orgNameIndPhNum() throws IOException {
		String orgName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 0);
		String indName = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 2);
		String phNum = fu.getDatafromExcelFile(exPath, "orgTestData", 1, 3);
//		HomePage
		hp.getOrgLink().click();

//		Organization Window:
		creOrg.getPlusImgLink().click();
		creOrg.getOrgNameTextfield().sendKeys(orgName + ju.generateRandomNumber());

//		Make WebDriver utility Class
		Select slt = new Select(creOrg.getIndustryDropdown());
		slt.selectByVisibleText(indName);
		creOrg.getPhoneTextfield().sendKeys(phNum);
		creOrg.getSaveBtn().click();
	}
}
