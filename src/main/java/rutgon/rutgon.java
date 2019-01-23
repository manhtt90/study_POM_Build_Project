package rutgon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rutgon {
	public WebDriver driver;
	public WebDriverWait wait;
	//public FluentWait wait;
	
	//
	public rutgon (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (driver, 120);
		//this.wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
	}

	//I. Define Xpath, Css, Id
	public String wrapGetTextXpath(String elementXpath) {
		return driver.findElement(By.xpath(elementXpath)).getText();
	}
	public String wrapWaitGetTextXpath(String elementXpath) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getText();
	}
	public void wrapClickXpath(String elementXpath) {
		driver.findElement(By.xpath(elementXpath)).click();
	}
	public void wrapWaitClickXpath(String elementXpath) {
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
	}
	public void wrapSendKeysXpath(String elementXpath, String keyXpath) {
		driver.findElement(By.xpath(elementXpath)).sendKeys(keyXpath);
	}
	public void wrapWaitSendKeysXpath(String elementXpath, String keyXpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).sendKeys(keyXpath);
	}
	
	//Css
	public String wrapGetTextCss(String elementCss) {
		return driver.findElement(By.cssSelector(elementCss)).getText();
	}
	public String wrapWaitGetTextCss(String elementCss) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCss))).getText();
	}
	public void wrapClickCss(String elementCss) {
		driver.findElement(By.cssSelector(elementCss)).click();
	}
	public void wrapWaitClickCss(String elementCss) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCss))).click();
	}
	public void wrapSendKeysCss(String elementCss, String keyCss) {
		driver.findElement(By.cssSelector(elementCss)).sendKeys(keyCss);
	}
	public void wrapWaitSendKeysCss(String elementCss, String keyCss) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCss))).sendKeys(keyCss);
	}
	
	//Id
	public String wrapGetTextId(String elementId) {
		return driver.findElement(By.id(elementId)).getText();
	}
	public String wrapWaitGetTextId(String elementId) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId))).getText();
	}
	public void wrapClickId(String elementId) {
		driver.findElement(By.id(elementId)).click();
	}
	public void wrapWaitClickId(String elementId) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId))).click();
	}
	public void wrapSendKeysId(String elementId, String keyId) {
		driver.findElement(By.id(elementId)).sendKeys(keyId);
	}
	public void wrapWaitSendKeysId(String elementId, String keyId) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId))).sendKeys(keyId);
	}
}
