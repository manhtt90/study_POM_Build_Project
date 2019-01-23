package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JxmLogin_Quick {
	WebDriver driver;
	By user = By.id("u");
	By password = By.id("p");
	By loginButton = By.id("login_submit_btn");
	By email = By.id("other_email");
	String eloginTitle = "Chơi Ngay";
	By loginTitle = By.id("login_title");
	
	public JxmLogin_Quick(WebDriver driver){
        this.driver = driver;
    }
	
	// If QuickLogin is default, fill user/passs; if not, click on QuickLogin method
	public void selectQuickLoginMethod(String strUserQuickLogin, String strPasswordQuickLogin){
		String aloginTitle = driver.findElement(loginTitle).getText();
		if (aloginTitle.contains(eloginTitle)) {
			driver.findElement(user).sendKeys(strUserQuickLogin);
			driver.findElement(password).sendKeys(strPasswordQuickLogin);
		} else {
			// Click button to select QuickLogin method
			driver.findElement(email).click();
			// Fill username/password infor to login
			driver.findElement(user).sendKeys(strUserQuickLogin);
			driver.findElement(password).sendKeys(strPasswordQuickLogin);
		}
	}
	
	// Click on login button
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserZid
	 * @param strPasswordZid
	 * @return
	 */

	public void loginToJxm_Quick(String strUserQuickLogin, String strPasswordQuickLogin) {
		// Fill user name
		this.selectQuickLoginMethod(strUserQuickLogin, strPasswordQuickLogin);
		// Click Login button
		this.clickLogin();
	}
}
