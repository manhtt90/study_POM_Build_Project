package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataProvider.productList_mobileGame;

public class Homepage extends rutgon.rutgon{
	//WebDriver driver;
	String scrollToBottom = "window.scrollTo(0, document.body.scrollHeight)";
	By gameMobile = By.xpath("");
	
	public Homepage(WebDriver driver) {
		super(driver);	
	}

	// Select Game Mobile tab
	@Test(priority = 1)
	public void SelectGameMobile() throws InterruptedException {
		System.out.println("SelectGameMobile");
		//driver.findElement(gameMobile).click();
		wrapWaitClickXpath("//*[contains(text(),'Game Mobile')]");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Way 1, Scroll manual till Page Bottom - not really ok
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		// System.out.println("Scroll to Page bottom 1st time");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		// System.out.println("Scroll to Page bottom 2nd time");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		// System.out.println("Scroll to Page bottom 3rd time");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		// System.out.println("Scroll to Page bottom 4th time");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
	}

	// Find JXM game
	@Test(dataProvider = "productList_mobile", dataProviderClass = productList_mobileGame.class, priority = 2)
	//@Test(priority = 1)
	//@DataProvider(name = "productList_mobile")
	public void SelectGameJxm(String gameName) {
		System.out.println("SelectGameJxm");
		wrapWaitClickXpath(gameName);
		//String a = "//*[contains(text(),'Võ Lâm Truyền Kỳ Mobile')]";
		//driver.findElement(By.xpath(gameName)).click();
		//System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	}

	public void GameMobile(String gameName) throws InterruptedException {
		this.SelectGameMobile();
		this.SelectGameJxm(gameName);
	}
}