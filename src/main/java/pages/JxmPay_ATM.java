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

public class JxmPay_ATM extends rutgon.rutgon {
	// Create new class to run and get Global value "ReadGuru99ExcelFile.class"
	public readPackFromExcelFile def = new readPackFromExcelFile();

	//
	public JxmPay_ATM(WebDriver driver) {
		super(driver);
		// this.driver = driver;
		// this.wait = new WebDriverWait(driver,20);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void TestCase1_ATM_BIDV_cancelTransaction() throws InterruptedException, IOException {
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=0; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		
		/*way2: read packList from excel
		//readExcel(String filePath, String fileName, String sheetName) có 3 tham số cần truyên vô
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx",
				"jxm");
		// Select randomPackIdRange2 (50000=<randomPackIdRange2 <= 20000000 package)
		// randomPackIdRange2 được định nghĩa ở class readPackFromExcelFile, 
		wrapWaitClickId(def.randomPackIdRange2);
		*/
		//Thread.sleep(1000);
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		// Select Payment Method - ATM/iBanking
		wrapWaitClickId("txtpaymentMethodbank");
		//Thread.sleep(1000);
		// Select BIDV Bank
		wrapWaitClickId("1bidv");
		//Thread.sleep(1000);
		// Select Confirm button to go to BIDV bank page
		wrapWaitClickId("btnSubmitPaymentElementbank");
		//Thread.sleep(3000);
		// Set variables cardnumber and cardholder = null
		// Click on X button to cancal transaction
		wrapWaitClickXpath("//*[@class='btnclose']");
		//Thread.sleep(1000);
		// Submit "Xac nhan" button to cancel transaction
		wrapWaitClickXpath("//*[@class='btn btn-blue']");
		//wrapFindCss("[class='btn btn-cancel w30']");
		//Thread.sleep(1000);
		// Back from Error screen to Result Screen 
		wrapWaitClickXpath("//*[@class='btn btn-back w30']");
		Thread.sleep(2000);
		
		// Check if being redirected to Result Page of Web Payment
		String expectedError4a = "giao";
		String expectedError4b = "giao dich dang";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtResult")));
		String actualError4 = StringUtils.removeAccent(wrapWaitGetTextId("txtResult").toLowerCase());
		System.out.println(actualError4);
		// compare the actual title with the expected title
		if (actualError4.contains(expectedError4a) ||actualError4.contains(expectedError4b)) {
			System.out.println("* Correct Error Message -giao dich dang xu ly!- *");
			//Thread.sleep(1000);
		} else {
			System.out.println("* Incorrect Error Message -giao dich dang xu ly!- *");
			//Thread.sleep(1000);
		}
		//Back from Result Screen to Payment page
		wrapWaitClickXpath("//*[contains(@data-bind,'ContinutePayment')]");
	}

	@Test(priority = 2)
	public void TestCase2_ATM_BIDV_inputDisableCardInforIntoATM() throws InterruptedException, IOException {
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
		//Thread.sleep(1000);
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		// Select Payment Method - ATM/iBanking
		wrapWaitClickId("txtpaymentMethodbank");
		// Thread.sleep(1000);
		// Select BIDV Bank
		wrapWaitClickId("1bidv");
		// Thread.sleep(1000);
		// Select Confirm button to go to BIDV bank page
		wrapWaitClickId("btnSubmitPaymentbank");
		// Thread.sleep(3000);
		// Find elements in ZaloPay gateway
		// Input Card Number and Card Holder
		wrapWaitSendKeysId("inputCardNo", "9704180070361878");
		wrapWaitSendKeysId("inputCardHo", "TRU TIEN MANH");
		// Submit button to see Error
		wrapWaitClickId("btnSubmit");
		// Thread.sleep(1000);
		// Back from Error screen to Result Screen
		wrapWaitClickXpath("//*[@class='btn btn-back w30']");
		Thread.sleep(2000);
		// Check if being redirected to Result Page of Web Payment
		String expectedError5a = "nhap sai thong tin";
		String expectedError5b = "giao dich dang";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtResult")));
		String actualError5 = StringUtils.removeAccent(wrapWaitGetTextId("txtResult").toLowerCase());
		System.out.println(actualError5);
		// compare the actual title with the expected title
		if (actualError5.contains(expectedError5a) || actualError5.contains(expectedError5b)) {
			System.out.println("* Correct Error Message -Nhập sai thông tin!- *");
		} else
			System.out.println("* Incorrect Error Message -Nhập sai thông tin!- *");
		// Back from Result Screen to Payment page
		wrapWaitClickXpath("//*[contains(@data-bind,'ContinutePayment')]");
	}

	@Test(priority = 3)
	public void TestCase3_ATM_VPBANK_InputBlankOTPIntoATM() throws InterruptedException, IOException {
		List <WebElement> listings = driver.findElements(By.xpath("//*[@class='lazy']"));
		for (int i=0; i < listings.size(); i++) {
			//System.out.println("Index " + i + ": " + listings.get(i).getAttribute("id"));
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
		
		/*way2: read packList from excel
		System.out.println("TestCase3");
		def.readExcel(System.getProperty("user.dir") + "\\src\\excelExportAndFileIO", "ExportExcelAllGames.xlsx",
				"jxm");
		// Select 50k VND package
		wrapWaitClickId(def.randomPackIdRange2);
		*/
		//Thread.sleep(1000);
		// Select Confirm at popup displayed
		wrapWaitClickId("popupProductConfirm");
		Thread.sleep(1000);
		// Select Payment Method - ATM/iBanking
		wrapWaitClickId("txtpaymentMethodbank");
		// Thread.sleep(1000);
		// Select VPBank
		wrapWaitClickId("1vpb");
		// Thread.sleep(1000);
		// Select Confirm button to go to VPbank page
		wrapWaitClickId("btnSubmitPaymentbank");
		// Thread.sleep(3000);

		// Input correct information here (Correct CardNumber, Correct CardHolder)
		wrapWaitSendKeysId("gateway_CardName", "TRU TIEN MANH");
		wrapWaitSendKeysId("gateway_CardNumber", "9704320827334501");
		wrapWaitSendKeysId("CardMonth", "01");
		wrapWaitSendKeysId("CardYear", "18");

		// Click on Thanh Toan button
		wrapWaitClickXpath("//*[@type='image' or contains(@onclick,'thanhtoan2.jpg')]");
		//src='images/button/thanhtoan.jpg'

		// Input blank OTP
		wait.until(ExpectedConditions.elementToBeClickable(By.id("verifyotp_OtpCode")));
		wrapWaitSendKeysId("verifyotp_OtpCode", "111111");
		wrapWaitSendKeysId("verifyotp_SecureCode", "111111");
		// Submit the first wrong time
		wrapWaitClickXpath("//*[@type='image' or contains(@onclick,'thanhtoan.jpg')]");
		// Thread.sleep(1000);
		// Submit the second wrong time
		wrapWaitClickXpath("//*[@type='image' or contains(@onclick,'thanhtoan.jpg')]");
		// Thread.sleep(1000);
		// Submit the third wrong time
		wrapWaitClickXpath("//*[@type='image' or contains(@onclick,'thanhtoan.jpg')]");
		// Thread.sleep(2000);
		// Wait for Transaction Failed button displayed
		// WebDriverWait wait1 = new WebDriverWait(_driver, 20);
		// wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn
		// btn-back w30']")));
		// Back from Error screen to Result Screen
		wrapWaitClickXpath("//*[@class='btn btn-back w30']");
		Thread.sleep(2000);
		String expectedError6 = "khach hang khong nhap";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtResult")));
		String actualError6 = StringUtils.removeAccent(wrapWaitGetTextId("txtResult").toLowerCase());
		System.out.println(actualError6);
		// compare the actual title with the expected title
		if (actualError6.contains(expectedError6)) {
			System.out.println("* Correct Error Message -Khách hàng không nhập OTP- *");
		} else
			System.out.println("* Incorrect Error Message -Khách hàng không nhập OTP- *");
		// Back from Result Screen to Payment page
		wrapWaitClickXpath("//*[contains(@data-bind,'ContinutePayment')]");
		// Thread.sleep(2000);
	}

	public void test_ATM() throws IOException, InterruptedException {
		this.TestCase1_ATM_BIDV_cancelTransaction();
		this.TestCase2_ATM_BIDV_inputDisableCardInforIntoATM();
		this.TestCase3_ATM_VPBANK_InputBlankOTPIntoATM();
	}

}
