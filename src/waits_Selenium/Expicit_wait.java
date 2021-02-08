package waits_Selenium;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Expicit_wait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./src/driverExecutables/geckodriver.exe");
		// EXPLICIT WAIT
		WebDriver driver = new FirefoxDriver();
		WebDriverWait ew = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		String[] itemsNeeded = { "Apple", "Banana", "Beans" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		addVegetablesToCart(driver, itemsNeeded);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		ew.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		ew.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
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
