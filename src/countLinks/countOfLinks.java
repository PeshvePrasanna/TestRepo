package countLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class countOfLinks {
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
		countOfLinks.OpenBrowser("firefox");
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		Thread.sleep(2500);
		System.out.println(driver.findElements(By.tagName("a")).size());
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement ele : allLinks) {
			String str = ele.getText();
			if (!str.isEmpty()) {
				System.out.println(str);
			}
		}
		// count and print only the links present in footer
		System.out.println("**************All Links present in footer**************");
		System.out
				.println(driver.findElements(By.cssSelector("div.container>div.row>div[class*='sm']>ul>li>a")).size());
		List<WebElement> footerLinks = driver
				.findElements(By.cssSelector("div.container>div.row>div[class*='sm']>ul>li>a"));
		for(WebElement ele1:footerLinks) {
			String str1 = ele1.getText();
			if (!str1.isEmpty()) {
				System.out.println(str1);
			}
		}
		// count and print only the links present in first column of footer
		System.out.println("**************All Links present in 1st COLUMN OF footer**************");
		System.out.println(driver.findElements(By.xpath("//footer//div[@class='row']//div[1]//ul//li//a")).size());
		List<WebElement> firstFooterCol = driver.findElements(By.xpath("//footer//div[@class='row']//div[1]//ul//li//a"));
		for(WebElement ele2:firstFooterCol) {
			String str2 = ele2.getText();
			if (!str2.isEmpty()) {
				System.out.println(str2);
			}
		}
		driver.quit();
	}

}
