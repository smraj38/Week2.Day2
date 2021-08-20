package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	private static java.util.List<WebElement> allinks;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		// to load the web page properly waiting for 10 sec if not in the DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// goto Home Page
		WebElement label1 = driver.findElementByXPath("(//a[@link='blue'])[1]");
		String s = label1.getAttribute("href");
		System.out.println("string is" + s);
		label1.click();
		driver.navigate().back();

		// Find where am supposed to go without clicking me?
		String link = driver.findElementByXPath("(//a[@link='blue'])[2]").getAttribute("href");
		System.out.println("Naviagte to this link " + link);

		// Verify am I broken?
		driver.findElementByXPath("//a[contains(text(), 'Verify am I broken?')]").click();

		String Title = driver.getTitle();
		if (Title.contains("404")) {
			System.out.println("Link Broken");
		} else {
			System.out.println("Link not broken");
		}
		// to navigate to previous web page
		driver.navigate().back();
		
		// (Interact with same link name)
		String label2 = driver.findElementByXPath("(//a[@link='blue'])[3]").getAttribute("href");
		if (label2.equals(s)) {
			System.out.println("It interacts with same link ");
		} else {
			System.out.println("Interact with diff link");
		}

		// How many link available in the page

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int sizeOfLink = allLinks.size();
		System.out.println("The Total number of links in the page is :" + sizeOfLink);

	}

}
