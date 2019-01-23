package pages;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import readPack.readPackFromExcelFile;
import rutgon.StringUtils;

public class JxmPay_Card extends rutgon.rutgon{	
	// Create new class to run and get Global value "ReadGuru99ExcelFile.class"
	public readPackFromExcelFile def = new readPackFromExcelFile();
	
	//I. Define Xpath, Css, Id
	public JxmPay_Card(WebDriver driver) {
		super(driver);
		//this.driver = driver;25
		//this.wait = new WebDriverWait(driver,20);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void TestCase1_Card_Zing_inputNothing() throws IOException, InterruptedException{
		//System.out.println("TestCase1_Card_Zing_inputNothing");
		
		/*way1
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=1; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		*/
		
		//way2: read packList from excel
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx", "jxm");
		// Select randomPackIdRange1 (0 < randomPackIdRange1 < 50000)
		wrapWaitClickId(def.randomPackIdRange1); 
		
		Thread.sleep(1000);
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		//wrapClickId("popupProductConfirm");
		Thread.sleep(1000);
		//Select Cashcard method
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtpaymentMethodcard"))).click();
		wrapWaitClickId("txtpaymentMethodcard");
		//Thread.sleep(1000);
		//Fill nothing at PIN/Serial fields
		wrapWaitSendKeysId("txtCardSerialcard", "");
		wrapWaitSendKeysId("txtCardPincard", "");
		//Submit button to see Error
		wrapWaitClickId("btnSubmitPaymentcard");
		String expectedError1 = "vui long nhap";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtSubmitErrorMessage")));
		String actualError1 = StringUtils.removeAccent(wrapWaitGetTextId("txtSubmitErrorMessage").toLowerCase());
		System.out.println(actualError1);
		//System.out.println(actualError1);
		if (actualError1.contains(expectedError1)) {
			System.out.println("* Correct Error Message -Vui long nhap dung thong tin tren the- *");
		}
		else
			System.out.println("* Incorrect Error Message -Vui long nhap dung thong tin tren the- *");	  
	}
	
	
	@Test(priority = 2)	
	public void TestCase2_Card_Zing_HasBeenUsedIntoCashcard() throws InterruptedException, IOException{
		/*way1
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=1; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		*/
		
		//way2: read packList from excel
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx", "jxm");
		// Select randomPackIdRange1 (0 < randomPackIdRange1 < 50000)
		wrapWaitClickId(def.randomPackIdRange1); 
		
		Thread.sleep(1000);
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		//Select Cashcard method
		wrapWaitClickId("txtpaymentMethodcard");
		//Thread.sleep(1000);
		//Fill thong tin the that da su dung
		wrapWaitSendKeysId("txtCardSerialcard","Kb0042273909");
		//Thread.sleep(1000);
		wrapWaitSendKeysId("txtCardPincard","Nmb8RTM3Z");
		//Thread.sleep(1000);
		//Submit button to see Error
		wrapWaitClickId("btnSubmitPaymentcard");
		//Thread.sleep(3000);
		String expectedError2 = "the da duoc";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtSubmitErrorMessage")));
		String actualError2 = StringUtils.removeAccent(wrapWaitGetTextId("txtSubmitErrorMessage").toLowerCase());
		System.out.println(actualError2);
		if (actualError2.contains(expectedError2)) {
			System.out.println("* Correct Error Message -the da duoc su dung- *");
		}
		else
			System.out.println("* Incorrect Error Message -the da duoc su dung-*");	  
	}
	
	@Test(priority = 3)
	public void TestCase3_Card_Zing_inputInvalidCardInforIntoCashcard() throws InterruptedException, IOException{
		/*way1
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=1; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		*/
		
		//way2: read packList from excel
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx", "jxm");
		// Select randomPackIdRange1 (0 < randomPackIdRange1 < 50000)
		wrapWaitClickId(def.randomPackIdRange1); 
		Thread.sleep(1000);
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		//Select Cashcard method
		wrapWaitClickId("txtpaymentMethodcard");
		//Thread.sleep(1000);
		//Fill thong tin the Zingcard 1 trieu
		wrapWaitSendKeysId("txtCardSerialcard","8H0078012099");
		//Thread.sleep(1000);
		wrapWaitSendKeysId("txtCardPincard","PAA4A9HDM");
		//Thread.sleep(1000);
		//Submit button to see Error
		wrapWaitClickId("btnSubmitPaymentcard");
		//Thread.sleep(3000);
		String expectedError3 = "thong tin the";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtSubmitErrorMessage")));
		String actualError3 = StringUtils.removeAccent(wrapWaitGetTextId("txtSubmitErrorMessage").toLowerCase());
		System.out.println(actualError3);
		if (actualError3.contains(expectedError3)) {
			System.out.println("* Correct Error Message -Thong tin the khong dung- *");
		}
		else
			System.out.println("* Incorrect Error Message -Thong tin the khong dung-*");
		
	}
	
	public void test_Card_Zing() throws IOException, InterruptedException {
		//this.skipTOU();
		this.TestCase1_Card_Zing_inputNothing();
		this.TestCase2_Card_Zing_HasBeenUsedIntoCashcard();
		this.TestCase3_Card_Zing_inputInvalidCardInforIntoCashcard();
	}
}
