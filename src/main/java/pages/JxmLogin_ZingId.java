package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JxmLogin_ZingId extends rutgon.rutgon {
	//WebDriver driver;
	By user = By.id("u");
	By password = By.id("p");
	By loginButtonZid = By.id("login_submit_btn");

	public JxmLogin_ZingId(WebDriver driver){
        //this.driver = driver;
		super(driver);
    }

	// Set user name in textbox
	public void setUserName(String strUserZid) {
		wrapSendKeysId("u",strUserZid);
	}

	// Set password in password textbox
	public void setPassword(String strPasswordZid) {
		wrapSendKeysId("p",strPasswordZid);
	}

	// Click on login button
	public void clickLogin() {
		wrapWaitClickId("login_submit_btn");
	}

	// Get the title of Login Page
	//public String getLoginTitle() {
	//	return driver.findElement(titleText).getText();
	//}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserZid
	 * @param strPasswordZid
	 * @return
	 */

	public void loginToJxm_ZingId(String strUserZid, String strPasswordZid) {
		// Fill user name
		this.setUserName(strUserZid);
		// Fill password
		this.setPassword(strPasswordZid);
		// Click Login button
		this.clickLogin();
	}
}
