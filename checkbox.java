package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		// to load the web page properly waiting for 10 seconds if not in the
		// DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select the languages that you know?

		driver.findElementByXPath("(//section[@class = 'innerblock']//input)[1]").click();
		driver.findElementByXPath("(//section[@class = 'innerblock']//input)[4]").click();

		// 2.Confirm Selenium is checked
		WebElement checked = driver.findElementByXPath("(//section[@class = 'innerblock']//input)[6]");
		if (checked.isSelected()) {
			System.out.println("Selenium is checked");
		} else {
			System.out.println("Selenium is not checked");
		}
		// 3.DeSelect only checked
		WebElement deselect = driver.findElement(By.xpath("(//section[@class = 'innerblock']//input)[8]"));
		deselect.click();

		// 4.Select all checkboxes
		int size = driver.findElementsByXPath("//label[text()='Select all below checkboxes ']/following::input").size();
		for (int i = 1; i <= size; i++) {

		driver.findElementByXPath("(//label[text()='Select all below checkboxes ']/following::input)[" + i + "]").click();

		}

	}

}
