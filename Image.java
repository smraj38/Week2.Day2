package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		// to load the web page properly waiting for 10 seconds if not in the
		// DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on this image to go home page

		driver.findElementByXPath("//img[@alt='logo Testleaf']").click();
		driver.navigate().back();

		// Am I Broken Image?

		WebElement img = driver.findElementByXPath("//img[contains(@src , 'abcd.jpg')]");
		String s = img.getAttribute("naturalwidth");
		if (s==null) {
			System.out.println("The image is broken");
		} else {
			System.out.println("The image is not broken");
		}
		// Click me using Keyboard or Mouse

		driver.findElementByXPath("//img[contains(@src, 'keyboard')]").click();

	}

}
