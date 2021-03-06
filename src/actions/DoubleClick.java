package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
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
		DoubleClick.OpenBrowser("firefox");
		driver.manage().window().maximize();
		driver.get("https://www.udemy.com/");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.name("q"))).click().keyDown(Keys.SHIFT).sendKeys("JAVA ProgramMiNG")
				.doubleClick().build().perform();
		Thread.sleep(2000);
		driver.quit();
	}
}
