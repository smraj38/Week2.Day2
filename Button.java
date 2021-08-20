package WEEK2.DAY2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load an URL
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		// to load the web page properly waiting for 10 sec if not in the DOM(document
		// object model)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// find x ,y position value
		Point location = driver.findElementByXPath("//button[@id='position']").getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("The Value of X & Y position is " + x + " & " + y);

		// find the button color
		String cssValue = driver.findElementByXPath("//button[@id='color']").getAttribute("style");
		System.out.println("The Button color is " + cssValue);

		Dimension size = driver.findElementByXPath("//button[@id='size']").getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println("Button Height " + height + " & Button Width " + width);

		driver.findElementByXPath("//button[@id='home']").click();

	}

}
