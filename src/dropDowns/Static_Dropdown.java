package dropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_Dropdown {
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
		Static_Dropdown.OpenBrowser("firefox");
		int i = 1;
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(1500);
		WebElement currencySelect = driver.findElement(By.cssSelector("select[id$='_DropDownListCurrency']"));
		Select selectCurr = new Select(currencySelect);
		List<WebElement> currencyList = selectCurr.getOptions();
		for (WebElement ele : currencyList) {
			System.out.println(ele.getText());
		}
		selectCurr.selectByIndex(2);
		Thread.sleep(1500);
		selectCurr.selectByVisibleText("USD");
		Thread.sleep(1500);
		Thread.sleep(1500);
		selectCurr.selectByValue("INR");
		Thread.sleep(1500);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1500);
		while (i < 3) {
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
			i++;
		}
		Thread.sleep(1500);
		driver.quit();
	}
}