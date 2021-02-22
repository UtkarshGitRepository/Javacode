package UM_emailOTP_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import UM_emailOTP_module.DriverClass;

public class invoke_SeleniumWD_verify_EmailOTP {
	
	private static WebElement ele = null;

	public static void invokeSeleniumWD() throws InterruptedException {
		
		// Selenium starts
		
		//System.setProperty("webdriver.chrome.driver","C:\\Selenium_JARs\\2_ChromeDriver\\Unzipped_File\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Selenium_JARs\\3_GeckoDriver\\Unzipped_File\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.yopmail.com/en/");
		Thread.sleep(60000);
		// System.out.println("Pass 1");

		ele = driver.findElement(By.xpath("//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[1]//input[2]")); // ->//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[2]//input[2]
		ele.sendKeys("randomuim2@yopmail.com");
		Thread.sleep(2000);
		// System.out.println("Pass 2");

		ele = driver.findElement(By.xpath("//input[@class='sbut' and @type='submit']"));
		ele.click();
		Thread.sleep(2000);
		// System.out.println("Pass 3");

		driver.switchTo().frame("ifinbox");
		ele = driver.findElement(By.xpath("/html/body/div/div[7]/div/a/span[2]"));
		ele.click();
		Thread.sleep(2000);
		// System.out.println("Pass 4");

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("ifmail");
		String emailBody = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]")).getText();
		char[] chars = emailBody.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		System.out.println("Email OTP is: " + sb);
		// System.out.println("Pass 5");

		driver.quit();
		//REST_POSTDelete obj = new REST_POSTDelete();

	}

}
