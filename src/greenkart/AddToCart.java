package greenkart;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddToCart {
	public static WebDriver driver;

	public static void OpenBrowser(String str) {
		if (str.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/driverExecutables/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} else if (str.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/driverExecutables/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} else {
			System.out.println("No Browsers Specified");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		AddToCart.OpenBrowser("chrome");
		driver.manage().window().maximize();
		String[] nameOfVegetables = { "Cucumber", "Carrot", "Beans" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] productName = products.get(i).getText().split("-");
			String veggieName = productName[0].trim();
			List al = Arrays.asList(nameOfVegetables);

			if (al.contains(veggieName)) {
				driver.findElements(By.cssSelector("a.increment")).get(i).click();
				driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
				if (j == 3) {
					break;
				}
			}

		}
		Thread.sleep(2000);
		driver.quit();
	}
}