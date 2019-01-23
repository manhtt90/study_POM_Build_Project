package randomPack;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RandomFromListOfElement {
	public static WebDriver driver;
	public static void main (String args[]) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(1000);
		List <WebElement> listings = driver.findElements(By.xpath("//*[@border='1']//*[@class='mouseOut']"));
		for (int i=0; i < listings.size(); i++) {
			System.out.println("Index " + i + ": " + listings.get(i).getText());
		}
		Random r = new Random();
		int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
		listings.get(randomValue).click(); //Clicking on the random item in the list.
	}
}
