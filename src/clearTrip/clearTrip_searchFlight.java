package clearTrip;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class clearTrip_searchFlight {
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
		clearTrip_searchFlight.OpenBrowser("firefox");
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("FromTag")).sendKeys("Adel");
		Thread.sleep(3400);
		List<WebElement> fromCity = driver.findElements(By.cssSelector("ul#ui-id-1 li>a"));
		for(WebElement ele : fromCity) {
			
		if(ele.getText().equalsIgnoreCase("Adelaide, AU - Adelaide (ADL)")) {
			ele.click();
			break;
		}
	
		}
		driver.findElement(By.id("ToTag")).sendKeys("Bang");
		Thread.sleep(3000);
		driver.quit();

	}

}
