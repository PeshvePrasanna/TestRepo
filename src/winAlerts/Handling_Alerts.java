package winAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handling_Alerts {
	public static WebDriver driver;

	public static void OpenBrowser(String str) {
		if (str.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/driverExecutables/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (str.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/driverExecutables/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Browsers Specified");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Handling_Alerts.OpenBrowser("firefox");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#name")).sendKeys("Prasanna Peshve");
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		Thread.sleep(3500);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3500);
		driver.switchTo().alert().dismiss();
		Thread.sleep(500);
		
		driver.quit();

	}

}
