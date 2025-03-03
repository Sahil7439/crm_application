package genricUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import objectRepo.CreateContact;
import objectRepo.CreateOrg;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;
	public FileUtility fu = new FileUtility();
	public JavaUtility ju = new JavaUtility();
	public HomePage hp; // Remove initialization here
	public CreateOrg creOrg; // Remove initialization here
	public CreateContact con; // Remove initialization here
	public WebDriverWait wait;

//	public ExtentReports reports;
	String path = "C:\\automation\\src\\main\\resources\\CommonData.properties";

	@BeforeSuite
	public void configBS() {
		Reporter.log("----- Database Connected-------", true);
//		ExtentSparkReporter spark = new ExtentSparkReporter("./Advance_reporting/report.html");
//		spark.config().setDocumentTitle("Document title");
//		spark.config().setReportName("Report Name");
//		spark.config().setTheme(Theme.DARK);

//		reports = new ExtentReports();
//		reports.attachReporter(spark);
//		reports.setSystemInfo("O.S.", "Windows 11");
//		reports.setSystemInfo("Browser", "Chrome");
	}

	@BeforeTest
	public void btest() {
		Reporter.log("Pre condition", true);
	}

	@BeforeClass
	public void configBC() throws IOException {
		Reporter.log("-----Launching the Browser", true);

		String bro = fu.getDataFromPropertiesFile(path, "bro");
		String url = fu.getDataFromPropertiesFile(path, "url");
		if (bro.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (bro.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (bro.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

		hp = new HomePage(driver);
		creOrg = new CreateOrg(driver);
		con = new CreateContact(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void configBM() throws IOException {
		String url = fu.getDataFromPropertiesFile(path, "url");
		String username = fu.getDataFromPropertiesFile(path, "un");
		String password = fu.getDataFromPropertiesFile(path, "pwd");

		LoginPage lp = new LoginPage(driver);
		lp.loginMethod(username, password, url);
		Reporter.log("------Login------", true);
	}

	@AfterMethod
	public void ConfigAM() {
		Reporter.log("--------LogOut", true);
		hp = new HomePage(driver);
		hp.logoutMethod(driver);
	}

	@AfterClass
	public void configAC() {
		driver.quit();
		Reporter.log("Close Browser", true);
	}

	@AfterTest
	public void configAT() {
		Reporter.log("Post condition", true);
	}

	@AfterSuite
	public void configAS() {
		Reporter.log("-----Close DB, Report backUp------", true);
	}
}
