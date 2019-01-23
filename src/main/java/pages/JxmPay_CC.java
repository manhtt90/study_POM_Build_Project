package pages;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import readPack.readPackFromExcelFile;
import rutgon.StringUtils;

public class JxmPay_CC extends rutgon.rutgon {
	// Create new class to run and get Global value "ReadGuru99ExcelFile.class"
	public readPackFromExcelFile def = new readPackFromExcelFile();

	//
	public JxmPay_CC(WebDriver driver) {
		super(driver);
		// this.driver = driver;
		// this.wait = new WebDriverWait(driver,20);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test (priority = 1)	
	public void TestCase1_CC_SC_inputNothingIntoCC() throws InterruptedException, IOException{
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=0; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		
		/*way2: read packList from excel
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx",
				"jxm");
		// Select randomPackIdRange2 (50000=<randomPackIdRange2 <= 20000000 package)
		wrapWaitClickId(def.randomPackIdRange2);
		*/
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		//Select Payment Method - CC
		wrapWaitClickId("txtpaymentMethodcredit");
		//Select Confirm button to go to Credit Card page
		wrapWaitClickId("btnSubmitPaymentElementcredit");
		// Click on X button to cancal transaction
		wrapWaitClickXpath("//*[@class='btnclose']");
		// Submit "Xac nhan" button to cancel transaction
		wrapWaitClickXpath("//*[@class='btn btn-blue']");
		//wrapFindCss("[class='btn btn-cancel w30']");
		// Back from Error screen to Result Screen 
		wrapWaitClickXpath("//*[@class='btn btn-back w30']");
		Thread.sleep(2000);
		
		//Confirm the error message appears
		String expectedError1a = "khach hang khong";
		String expectedError1b = "giao dich";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtResult")));
		String actualError1 = StringUtils.removeAccent(wrapWaitGetTextId("txtResult").toLowerCase());
		System.out.println(actualError1);
		if (actualError1.contains(expectedError1a) || actualError1.contains(expectedError1b)) {
			System.out.println("* Correct Error Message - Khách hàng không nhập thông tin thanh toán *");
		}
		else
			System.out.println("* Incorrect Error Message - Khách hàng không nhập thông tin thanh toán *");
		//Back from Result Screen to Payment page
		wrapWaitClickXpath("//*[contains(@data-bind,'ContinutePayment')]");
	}
	
	@Test (priority = 2)	
	public void TestCase2_CC_SC_inputWrongCardInforWrongOTPIntoCC() throws InterruptedException, IOException{
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=0; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		
		/*way2: read packList from excel
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx",
				"jxm");
		// Select randomPackIdRange2 (50000=<randomPackIdRange2 <= 20000000 package)
		wrapWaitClickId(def.randomPackIdRange2);
		*/
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		//Select Payment Method - CC
		wrapWaitClickId("txtpaymentMethodcredit");
		//Select Confirm button to go to Credit Card page
		wrapWaitClickId("btnSubmitPaymentElementcredit");
		//Input Card Number
		wrapSendKeysId("inputCCCardNo", "5161010000244858");
		//Input Card Holder
		wrapSendKeysId("inputCardHo", "TRU TIEN MANH");
		//Input Expired Date
		wrapSendKeysId("inputCardVa", "1122");
		//Input CVV/CVC2
		wrapSendKeysId("inputCardCVV", "999");
		//Confirm the method to go to OTP input page
		wrapWaitClickId("btnSubmit");
		
		//Go to OTP input page
		//Input wrong OTP here 3 times
		//first time
		wrapSendKeysId("enterPIN", "111111");
		wrapWaitClickId("btnOtpSubmit");
		//second wrong OTP
		wrapSendKeysId("enterPIN", "111111");
		wrapWaitClickId("btnOtpSubmit");
		//third wrong OTP
		wrapSendKeysId("enterPIN", "111111");
		wrapWaitClickId("btnOtpSubmit");
		//Click Submit button at SC error page to back to Zalopay gateway result
		wrapWaitClickId("authsubmit");
		//Click Back button to back to Result page
		wrapWaitClickXpath("//*[@class='btn btn-back w30']");
		Thread.sleep(2000);
		
		//Confirm the error message appears
		String expectedError2c1 = "thong tin";
		String expectedError2c2 = "giao dich thanh";
		String expectedError2c3 = "giao dich dang";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtResult")));
		String actualError2c = StringUtils.removeAccent(wrapWaitGetTextId("txtResult").toLowerCase());
		System.out.println(actualError2c);
		if (actualError2c.contains(expectedError2c1) || actualError2c.contains(expectedError2c2) || actualError2c.contains(expectedError2c3)) {
			System.out.println("* Correct Error Message - Giao dich thanh toan that bai *");
		}
		else
			System.out.println("* Incorrect Error Message - Giao dich thanh toan that bai *");
		//Back from Result Screen to Payment page
		wrapWaitClickXpath("//*[contains(@data-bind,'ContinutePayment')]");
	}	
	
	@Test (priority = 3)	
	public void TestCase3c_CC_HSBC_inputInvalidCardInfor() throws InterruptedException, IOException{
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=0; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		
		/*way2: read packList from excel
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx",
				"jxm");
		// Select randomPackIdRange2 (50000=<randomPackIdRange2 <= 20000000 package)
		wrapWaitClickId(def.randomPackIdRange2);
		*/
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		//Select Payment Method - CC
		wrapWaitClickId("txtpaymentMethodcredit");
		//Select Confirm button to go to Credit Card page
		wrapWaitClickId("btnSubmitPaymentElementcredit");
		//Input Card Number
		wrapSendKeysId("inputCCCardNo","4450930002725161");
		//Input Card Holder
		wrapSendKeysId("inputCardHo","TRU TIEN MANH");
		//Input Expired Date
		wrapSendKeysId("inputCardVa","1122");
		//Input CVV/CVC2
		wrapSendKeysId("inputCardCVV","999");
		//Confirm the method to go to OTP input page
		wrapWaitClickId("btnSubmit");
		//Select OK button at failed screen of HSBC
		wrapWaitClickXpath("//*[contains(@src,'but_okay')]");
		//Click Back button to back to Result page
		wrapWaitClickXpath("//*[@class='btn btn-back w30']");
		Thread.sleep(2000);
		
		
/*		//Go to OTP input page
		//Input wrong OTP here 3 times
		_driver.findElement(By.id("enterPIN")).sendKeys("111111");
		Thread.sleep(1000);
		wrapFindId("btnOtpSubmit");
		Thread.sleep(1000);
		//second wrong OTP
		_driver.findElement(By.id("enterPIN")).sendKeys("111111");
		Thread.sleep(1000);
		//third wrong OTP
		wrapFindId("btnOtpSubmit");
		Thread.sleep(1000);
		_driver.findElement(By.id("enterPIN")).sendKeys("111111");
		Thread.sleep(1000);
		wrapFindId("btnOtpSubmit");
		Thread.sleep(15000);*/

/*		//Navigate to Error Page of 123pay.vn gateway
		String expectedError2a = "Otp háº¿t háº¡n";
		String expectedError2b = "Ä‘ang xá»­";
		String actualError2;
		actualError2 = _driver.findElement(By.cssSelector(".notifications")).getText();
		if (actualError2.contains(expectedError2a) || actualError2.contains(expectedError2b)) {
			System.out.println("* Correct Error Message - Otp háº¿t háº¡n sá»­ dá»¥ng! *");
		}
		else
			System.out.println("* Incorrect Error Message - Otp háº¿t háº¡n sá»­ dá»¥ng! *");
		//Back from 123pay.vn Result Screen to Payment page
		wrapFindCss(".o-buttons");
		Thread.sleep(5000);*/
		
		//Confirm the error message appears
		String expectedError3c1 = "thong tin khach hang";
		String expectedError3c2 = "giao dich dang";
		String expectedError3c3 = "otp het han";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtResult")));
		String actualError3c = StringUtils.removeAccent(wrapWaitGetTextId("txtResult").toLowerCase());
		System.out.println(actualError3c);
		if (actualError3c.contains(expectedError3c1) || actualError3c.contains(expectedError3c2) || actualError3c.contains(expectedError3c3)) {
			System.out.println("* Correct Error Message - Giao dich khong thanh cong*");
		}
		else
			System.out.println("* Incorrect Error Message - Giao dich khong thanh cong *");
		//Back from Result Screen to Payment page
		wrapWaitClickXpath("//*[contains(@data-bind,'ContinutePayment')]");

	}
	public void test_CC() throws IOException, InterruptedException {
		this.TestCase1_CC_SC_inputNothingIntoCC();
		this.TestCase2_CC_SC_inputWrongCardInforWrongOTPIntoCC();
		this.TestCase3c_CC_HSBC_inputInvalidCardInfor();
	}

}
