package checkboxes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Select_Chkbox_CountChkBox {
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
		Select_Chkbox_CountChkBox.OpenBrowser("chrome");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("input[id*='_friendsandfamily']")).click();
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("input[id*='_StudentDiscount']")).click();
		Thread.sleep(2500);
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		List<WebElement> chkbxs = driver.findElements(By.xpath("//input[@type='checkbox']//following-sibling::label"));
		for(WebElement ele : chkbxs) {
			System.out.println(ele.getText());
		}
		driver.quit();
	}
}