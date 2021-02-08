package waits_Selenium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Implicit_Wait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./src/driverExecutables/geckodriver.exe");
		// WebDriver driver1 = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		// Implicit WAITS
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String[] itemsNeeded = { "Apple", "Banana", "Beans" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		addVegetablesToCart(driver, itemsNeeded);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.quit();

	}

	private static void addVegetablesToCart(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> totalItems = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < totalItems.size(); i++) {
			String[] itemName = totalItems.get(i).getText().split("-");
			String veggieName = itemName[0].trim();
			List<String> veggieNeeded = Arrays.asList(itemsNeeded);
			if (veggieNeeded.contains(veggieName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
