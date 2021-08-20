package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	private Object keys;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		// to load the web page properly waiting for 10 seconds if not in the
		// DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select dropdown value using index

		WebElement d = driver.findElementByXPath("//select[@id='dropdown1']");
		Select dd1 = new Select(d);
		dd1.selectByIndex(1);

		// Select dropdown value using text

		WebElement d1 = driver.findElementByXPath("//select[@name='dropdown2']");
		Select dd2 = new Select(d1);
		dd2.selectByVisibleText("Selenium");

		// Select dropdown value using value

		WebElement d2 = driver.findElementByXPath("//select[@id='dropdown3']");
		Select dd3 = new Select(d2);
		dd3.selectByValue("1");

		// get the no of dropdown option

		WebElement d3 = driver.findElementByXPath("//select[@class='dropdown']");
		Select dd4 = new Select(d3);
		int size = dd4.getOptions().size();
		System.out.println("Drop down option count is " + size);

		// sendkeys to select

		driver.findElementByXPath("(//section[@class='innerblock']//select)[5]").sendKeys(Keys.ARROW_DOWN);
	

		// Select your programs

		WebElement d5 = driver.findElementByXPath("(//section[@class='innerblock']//select)[6]");
		Select dd6 = new Select(d5);
		dd6.selectByValue("1");
		dd6.selectByValue("2");

	}

}
