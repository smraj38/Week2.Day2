package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Lunch a Chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		// to load the webpage properly waiting for 10 sec if not in the DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// fill the form
		driver.findElement(By.id("email")).sendKeys("john.skew@Testleaf.com");
		driver.findElementByXPath("//input[contains(@value,'Append')]").sendKeys("TEST LEAF");
		driver.findElementByXPath("//input[contains(@value,'Append')]").sendKeys(Keys.TAB);
		// getting the default text in the text box
		String Uname = driver.findElementByXPath("(//input[contains(@name,'username')])[1]").getAttribute("value");
		System.out.println("The default value from the Edit box is "+Uname);
		// Clear the text box
		driver.findElementByXPath("(//input[contains(@name,'username')])[2]").clear();
		// check edit box is enabled or disabled.
		boolean enabled = driver.findElementByXPath("//input[@disabled='true']").isEnabled();
		if (!enabled) {
			System.out.println("The Edit box is disabled");
		} else {
			System.out.println("The Edit box is Enabled");
		}

	}

}
