package test;

import org.testng.annotations.Test;
import dataProvider.productList_mobileGame;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.JxmLogin_ZingId;
import pages.JxmRole;
import pages.Homepage;
import pages.JxmLogin_Quick;
import pages.JxmPay_Card;
import pages.JxmPay_ATM;
import pages.JxmPay_CC;

public class TestJxm {
	//String baseUrl = "https://pay.zing.vn/";
	public WebDriver driver;
	JxmLogin_ZingId objLoginZingid;
	JxmLogin_Quick objLoginQuick;
	JxmRole objRole;
	Homepage objHomepage;
	JxmPay_Card objCardZing;
	JxmPay_ATM objATM;
	JxmPay_CC objCC;
	
	
	@BeforeTest
	@Parameters({"browser", "baseUrl"})
	public void setup(String browser, String baseUrl) throws Exception {
		/*driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		*/
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.out.println("FireFox is running");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.out.println("Chrome is running");
			// create chrome instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.out.println("Edge is running");
			// create Edge instance
			driver = new EdgeDriver();
		}
		// Check if parameter passed as 'Internet Explorer'
		else if (browser.equalsIgnoreCase("ie")) {
			// set path to Edge.exe
			System.out.println("Internet Explorer is running");
			// create Edge instance
			driver = new InternetExplorerDriver();
		}
		// Check if parameter passed as 'Opera'
		else if (browser.equalsIgnoreCase("opera")) {
			// set path to Edge.exe
			//DesiredCapabilities capablities=DesiredCapabilities.opera();
			//capablities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			//System.setProperty("webdriver.opera.driver", "D:\\Training\\SeleniumWebDriver\\operadriver.exe");
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.setBinary("C:\\Program Files\\Opera\\launcher.exe");
			OperaOptions options = new OperaOptions();
			options.setBinary(new File("C:\\Program Files\\Opera\\57.0.3098.116\\opera.exe"));
			System.out.println("Opera is running");
			// create Edge instance
			//driver = new OperaDriver();
			driver = new OperaDriver(options);
		}
		else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		driver.get(baseUrl);
		Thread.sleep(1000);
	}

	/**
	 * This test case will login in baseUrl Verify login page title as guru99 bank
	 * Login to application Verify the home page using Dashboard message
	 * @throws InterruptedException 
	 * @throws IOException 
	 */

	@Test(dataProvider = "productList_mobile", dataProviderClass = productList_mobileGame.class, priority = 1)
	//@Test(priority = 0)
	//@DataProvider(name = "productList_mobile")
	public void test_SelectRoleByZingId(String gameName) throws InterruptedException, IOException {
		System.out.println("1a");
		//Create Home Page object
		objHomepage = new Homepage(driver);
		//select GameMobile tab and GameJxm
		objHomepage.GameMobile(gameName);
		//objHomepage.SelectGameMobile();
		//objHomepage.SelectGameJxm();
		//Wait a few second to load next page
		Thread.sleep(3000);
		
		// Create Login Page object by ZingId
		objLoginZingid = new JxmLogin_ZingId(driver);
		// login to application
		objLoginZingid.loginToJxm_ZingId("four_power1", "Han123do!");
		//Wait a few second to load next page
		Thread.sleep(3000);
		
		/*
		// Create Role Page object - Go the next page - Select Role page 
		objRole = new JxmRole(driver);
		// Verify page header title
		System.out.println(objRole.getJxmRoleTitle());
		// Select Role1 actions
		objRole.SelectJxmRole();
		//Wait a few second to load next page
		Thread.sleep(3000);
		
		
		System.out.println("test_Pay_Card_Zing");
		// Create Pay_Card_Zing object
		objCardZing = new JxmPay_Card(driver);
		objCardZing.test_Card_Zing();
		//Wait a few second to load next page 
		Thread.sleep(3000);
		
		System.out.println("test_Pay_ATM");
		// Create Pay_ATM object
		objATM = new JxmPay_ATM(driver);
		objATM.test_ATM();
		//Wait a few second to load next page 
		Thread.sleep(3000);
		
		System.out.println("test_Pay_CC");
		// Create Pay_CC object
		objCC = new JxmPay_CC(driver);
		objCC.test_CC();
		//Wait a few second to load next page 
		Thread.sleep(3000);
		*/
	}
	
	@Test(priority = 2)
	//@Test(dataProvider = "productList_mobile", dataProviderClass = productList_mobileGame.class, priority = 2)
	public void test_Select_Role() throws InterruptedException {
		System.out.println("test_Select_Role");
		// Create Role Page object - Go the next page - Select Role page 
		objRole = new JxmRole(driver);
		// Verify page header title
		System.out.println(objRole.getJxmRoleTitle());
		// Select Role1 actions
		objRole.SelectJxmRole();
		//Wait a few second to load next page
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 3)
	public void test_Pay_Card_Zing() throws InterruptedException, IOException {
		System.out.println("test_Pay_Card_Zing");
		// Create Pay_Card_Zing object
		objCardZing = new JxmPay_Card(driver);
		objCardZing.test_Card_Zing();
		//Wait a few second to load next page 
		Thread.sleep(3000);
	}
	

	/*
	@Test(priority = 4)
	public void test_Pay_ATM() throws InterruptedException, IOException {
		System.out.println("test_Pay_ATM");
		// Create Pay_ATM object
		objATM = new JxmPay_ATM(driver);
		objATM.test_ATM();
		//Wait a few second to load next page 
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 5)
	public void test_Pay_CC() throws InterruptedException, IOException {
		System.out.println("test_Pay_CC");
		// Create Pay_CC object
		objCC = new JxmPay_CC(driver);
		objCC.test_CC();
		//Wait a few second to load next page 
		Thread.sleep(3000);
	}
	*/
	
	/*
	@Test(priority = 10)
	public void test_SelectRoleByQuickLogin() throws InterruptedException {
		//Create Home Page object
		objHomepage = new Homepage(driver);
		//select GameMobile tab and GameJxm
		objHomepage.SelectGameMobile();
		objHomepage.SelectGameJxm();
		
		//Wait a few second to load next page
		Thread.sleep(3000);
		
		// Create Login Page object by Quick
		objLoginQuick = new JxmLogin_Quick(driver);
		// login to application
		objLoginQuick.loginToJxm_Quick("manhtt90@gmail.com", "Han123do!");
		
		//Wait a few second to load next page
		Thread.sleep(3000);

		// Create Role Page object - Go the next page - Select Role page 
		objRole = new JxmRole(driver);
		// Verify page header title
		//System.out.println(objRole.getJxmRoleTitle());
		// Select Role1 actions
		objRole.SelectJxmRole();
	}*/
	
	
	@AfterTest 
	public void tearDown() { 
		//driver.quit(); 
	}
}