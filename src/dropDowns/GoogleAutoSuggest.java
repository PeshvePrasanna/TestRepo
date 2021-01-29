package dropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleAutoSuggest {
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
		GoogleAutoSuggest.OpenBrowser("chrome");
		driver.get("https://www.google.com");
		String str = "cric";
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(str);
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li.sbct>div"));
		for (WebElement ele : options) {
			if (ele.getText().equalsIgnoreCase("cricket live")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(2500);
		driver.quit();
	}
}