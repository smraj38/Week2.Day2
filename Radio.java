package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radio {

	private static WebElement webElement;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		// to load the web page properly waiting for 10 seconds if not in the
		// DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Radio button selection yes/no

		driver.findElementByXPath("//input[@id='yes']").click();

		// Find default selected radio button
		WebElement chk = driver.findElementByXPath("//label[@for='Unchecked']");
		if (chk.isSelected()) {
			System.out.println("default selection is unchecked");
		} else {
			System.out.println("default selection is Checked");
		}

		// Select your age group (Only if choice wasn't selected)
		int a = 33;
		if (a < 20) {
		driver.findElementByXPath("//label[contains (text(),'Select your age')]/following-sibling::input[@value = '0']").click();
			System.out.println("age group is under 1 - 20 yrs");
		} else if (a < 40) {
			driver.findElementByXPath("//label[contains (text(),'Select your age')]/following-sibling::input[@value = '0']").click();
			System.out.println("age group is under 21 - 40 yrs");
		} else {
			System.out.println("age group is above 40 yrs ");
		}

	}

}
