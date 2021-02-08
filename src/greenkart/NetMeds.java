package greenkart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NetMeds {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/driverExecutables/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] addSunProd = {"Vegetal BIO SPF-30 Sunscreen Lotion 100 ml","Sri Sri Tattva Protecting Sunscreen 60 ml"};
        driver.manage().window().maximize();
		driver.get("https://www.netmeds.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sunProducts = driver.findElement(By.xpath("//div[@class='home-best-seller']//following::span[text()='Sunscreen Lotions']"));
		 js.executeScript("arguments[0].scrollIntoView();", sunProducts);
		 Thread.sleep(5000);
		// driver.findElement(By.xpath("//div[@class='parent']//following::span[text()='No Thanks']")).click();
		 //driver.findElement(By.cssSelector("div.parent a#closeButton")).click();
		 List<WebElement> products = driver.findElements(By.cssSelector("div[class='home-best-seller'][data-id='section_52'] span.clsgetname"));
		for (int i = 0; i < products.size(); i++) {
			List<String> al = Arrays.asList(addSunProd);
			if(al.contains(products)) {
				driver.findElements(By.cssSelector("button[type='submit'][class='toCart cartbag']")).get(i).click();
			}
		}
	Thread.sleep(2000);
	}
}
