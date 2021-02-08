package myCibil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckCibil {
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
		CheckCibil.OpenBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://myscore.cibil.com/CreditView/login.page");
		driver.findElement(By.id("login-Username")).sendKeys("peshve.prasanna@gmail.com");
		driver.findElement(By.id("login-Password")).sendKeys("Pras@1992");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(6000);
		System.out.println(driver.findElement(By.xpath("//div[@class='your-rank gradeD']")).getText());
		

	}

}
