package dropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestions {
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
		AutoSuggestions.OpenBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String countryName = "fr";
		driver.findElement(By.cssSelector("input#autosuggest")).sendKeys(countryName);
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item"));
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("France")) {
				option.click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
