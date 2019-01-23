package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rutgon.StringUtils;

public class JxmRole extends rutgon.rutgon{
	//WebDriver driver;
	By headerTitle = By.xpath("//*[@class='am-header-title']");
	By groupServerList = By.xpath("//*[@id='authServerGroupListDiv']//*[contains(@class,'am-selected am-dropdown')]");
	By groupServer1 = By.xpath("//*[@id='authServerGroupListDiv']//*[@data-index='1']//child::span[1]");
	By serverList = By.xpath("//*[@id='authServerListDiv']//*[contains(@class,'am-selected am-dropdown')]");
	By server1 = By.xpath("//*[@id='authServerListDiv']//*[@data-index='1']//child::span[1]");
	By roleList = By.xpath("//*[@id='authRoleListDiv']//*[contains(@class,'am-selected am-dropdown')]");
	By role1 = By.xpath("//*[@id='authRoleListDiv']//*[@data-index='1']//child::span[1]");
	By submitRole = By.xpath("//*[@id='authBtnSubmit']");
	
	public JxmRole(WebDriver driver) {
		super(driver);
	}
	
	@BeforeTest
	// Get the headerTitle from JxmRole Page
	public String getJxmRoleTitle() {
		//return driver.findElement(headerTitle).getText();
		//String a = wrapWaitGetTextXpath("//*[@class='am-header-title']");	
		//System.out.println(wrapWaitGetTextXpath("//*[@class='am-header-title']"));
		return StringUtils.removeAccent(wrapWaitGetTextXpath("//*[@class='am-header-title']"));
	}
	
	@Test(priority = 1)
	// Select role1 of game
	public void selectRole1() throws InterruptedException {
		/*
		wrapWaitClickXpath("//*[@id='authServerGroupListDiv']//*[contains(@class,'am-selected am-dropdown')]");
		Thread.sleep(1000);
		wrapWaitClickXpath("//*[@id='authServerGroupListDiv']//*[@data-index='1']//child::span[1]");
		Thread.sleep(1000);
		wrapWaitClickXpath("//*[@id='authServerListDiv']//*[contains(@class,'am-selected am-dropdown')]");
		Thread.sleep(1000);
		wrapWaitClickXpath("//*[@id='authServerListDiv']//*[@data-index='1']//child::span[1]");
		Thread.sleep(1000);
		wrapWaitClickXpath("//*[@id='authRoleListDiv']//*[contains(@class,'am-selected am-dropdown') and contains(@class,'am-selected')]");
		Thread.sleep(1000);
		wrapWaitClickXpath("//*[@id='authRoleListDiv']//*[@data-index='1']//child::span[1]");
		Thread.sleep(1000);
		*/

		// Click on Server Group List
		try {
			wrapClickXpath("//*[@id='authServerGroupListDiv']//*[contains(@class,'am-selected am-dropdown')]");
			//Thread.sleep(1000);
		} catch (Exception e) {
		}
		Thread.sleep(1000);
		// Click on Server Group List 1
		try {
			wrapClickXpath("//*[@id='authServerGroupListDiv']//*[@data-index='1']//child::span[1]");
			//Thread.sleep(1000);
		} catch (Exception e) {
		}
		Thread.sleep(1000);
		// Click on Server List
		wrapClickXpath("//*[@id='authServerListDiv']//*[contains(@class,'am-selected am-dropdown')]");
		try {
			//Thread.sleep(1000);
		} catch (Exception e) {
		}
		Thread.sleep(1000);
		// Click on Server 1
		try {
			wrapClickXpath("//*[@id='authServerListDiv']//*[@data-index='1']//child::span[1]");
			//Thread.sleep(1000);
		} catch (Exception e) {
		}
		Thread.sleep(1000);
		// Click on Role List
		try {
			wrapClickXpath("//*[@id='authRoleListDiv']//*[contains(@class,'am-selected am-dropdown') and contains(@class,'am-selected')]");
		} catch (Exception e) {
		}
		Thread.sleep(1000);
		// Click on Role 1
		try {
			wrapClickXpath("//*[@id='authRoleListDiv']//*[@data-index='1']//child::span[1]");
			//Thread.sleep(1000);
		} catch (Exception e) {
		}
		Thread.sleep(1000);

		
		// Click on Submit button
		try {
			wrapWaitClickXpath("//*[@id='authBtnSubmit']");
			//Thread.sleep(1000);
		} catch (Exception e) {
		}
		Thread.sleep(1000);
	}
	
	@Test(priority = 2)
	public void skipTOU() throws InterruptedException {
		//Skip "Dieu khoan su dung"
		try {
			wrapWaitClickXpath("//*[@onclick='doAgree()']");
			}
		catch (Exception e) {}
		Thread.sleep(1000);

	}
	
    public void SelectJxmRole() throws InterruptedException{
        //Select role1
        this.selectRole1();  
        this.skipTOU();
    }
}
