package checkboxes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

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
		//WebElement oneWay = driver.findElement(By.xpath("//div[@id='travelOptions']//following::label[text()='One Way' and @class='select-label']"));
		//Assert.assertTrue(oneWay.isEnabled(), "One-way trip is selected");
		driver.findElement(By.cssSelector("input[id*='_friendsandfamily']")).click();
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("input[id*='_StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='_StudentDiscount']")).isSelected(), "Student-Discount selected");
		Thread.sleep(2500);
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		List<WebElement> chkbxs = driver.findElements(By.xpath("//input[@type='checkbox']//following-sibling::label"));
		for(WebElement ele : chkbxs) {
			System.out.println(ele.getText());
		}
		driver.quit();
	}
}