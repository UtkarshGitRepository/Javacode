package usingJava_to_send_REST_POST_req;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class REST_POST_request {

	private static WebElement ele = null;
	public static String identitycontext = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// Java HTTPURLConnection 1
		URL url = new URL("https://testapi.ttcsp.cloud/userservice/api/v3/register");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		String inputMessage = "{\"firstname\":\"First_Java_Person\",\"lastname\":\"Last_Java_Person\",\"email\":\"randomuim2@yopmail.com\",\"password\":\"WXBvaXBpJDFydw==\",\"dialingcode\":\"91\",\"phone\":\"6387903257\",\"iseulaaccepted\":\"true\",\"versionnumber\":\"1.0\",\"fcmtoken\":\"ccHhroqWSgiwX8H3M5uiVI:APA91bGGH37Uz0YQ43XUo6vWp6JW63LGYg4ouJ9mujOzow0brtSJvEU-WII7pS6yG3xD9aJzVH4RG878D4Q_53gnMEGLErKhMaUYIdGqBWxBLcxZ9Qav0P-JubTwH7R5qHgfiGmJSyu1\",\"imei\":\"13627066288288\"}";
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = inputMessage.getBytes("utf-8");
			os.write(input, 0, input.length);
			                    os.flush();
			                    os.close();
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			String answer = response.toString();
			System.out.println("Response is: "+answer);
			int length = answer.length();
			identitycontext = answer.substring(63,(length-85));
			System.out.println("Cutting from ***front*** and ***back***: "+identitycontext);
			
			
		}
		// System.out.println("End");

		// Selenium starts
		Thread.sleep(2000);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium_JARs\\2_ChromeDriver\\Unzipped_File\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.yopmail.com/en/");
		Thread.sleep(2000);
		// System.out.println("Pass 1");

		ele = driver.findElement(By.xpath(
				"//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[1]//input[2]")); // ->//html//body//center//div//div//div[3]//table[3]//tbody//tr//td[1]//table//tbody//tr[3]//td//div[1]//form//table//tbody//tr[1]//td[2]//input[2]
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
		

		// Java HTTPURLConnection 2
		URL url1 = new URL("https://testapi.ttcsp.cloud/userservice/api/v3/deleteuserprofile");
		HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
		con1.setRequestMethod("POST");
		con1.setRequestProperty("Content-Type", "application/json; utf-8");
		con1.setRequestProperty("identitycontext", identitycontext);
		con1.setRequestProperty("clienttype", "mobile");
		con1.setRequestProperty("Accept", "application/json");
		con1.setDoOutput(true);
		String inputMessage1 = "{\"password\":\"WXBvaXBpJDFydw==\"}";
		try (OutputStream os1 = con1.getOutputStream()) {
			byte[] input1 = inputMessage1.getBytes("utf-8");
			os1.write(input1, 0, input1.length);
                                    os1.flush();
                                    os1.close();
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con1.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}

	}

}
// \"password\":\"WXBvaXBpJDFydw==\"
