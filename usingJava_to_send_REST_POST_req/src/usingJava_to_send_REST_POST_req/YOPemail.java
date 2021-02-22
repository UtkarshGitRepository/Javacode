package usingJava_to_send_REST_POST_req;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YOPemail {
	
	private static WebElement ele = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_JARs\\2_ChromeDriver\\Unzipped_File\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("http://www.yopmail.com/en/");
			Thread.sleep(2000);
			
			ele = driver.findElement(By.xpath("//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[1]//input[2]"));  //->//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[2]//input[2]
			  ele.sendKeys("randomuim2@yopmail.com");
			  Thread.sleep(2000);
			  
			//->/html/body/center/div/div/div[3]/table[3]/tbody/tr/td[1]/table/tbody/tr[3]/td/div[1]/form/table/tbody/tr[1]/td[3]/input
			//ele = driver.findElement(By.xpath("//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[4]//input"));
			ele = driver.findElement(By.xpath("//input[@class='sbut' and @type='submit']")); 
			  ele.click();
			  Thread.sleep(2000);
			driver.switchTo().frame("ifinbox");//driver.switchTo().frame("ifmail");
			ele = driver.findElement(By.xpath("/html/body/div/div[7]/div/a/span[2]"));
			  ele.click();
			  Thread.sleep(2000);
			driver.switchTo().frame("ifmail"); //ele = dri
			String emailBody = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]")).getText();
		      char[] chars = emailBody.toCharArray();
		      StringBuilder sb = new StringBuilder();
		      for(char c : chars){
		         if(Character.isDigit(c)){
		            sb.append(c);
		         }
		      }
		      System.out.println("Email OTP is: "+sb);

	}

}
