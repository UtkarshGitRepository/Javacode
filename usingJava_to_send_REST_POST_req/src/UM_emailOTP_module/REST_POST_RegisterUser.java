package UM_emailOTP_module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import UM_emailOTP_module.DriverClass;

public class REST_POST_RegisterUser {
	
	//private static String identitycontext = null;

	public static void registerUser() throws IOException {
		
		// Java HTTP URL Connection
		
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
			DriverClass.identitycontext = answer.substring(63,(length-85));
			System.out.println("Cutting from ***front*** and ***back***: "+DriverClass.identitycontext);
			
		}

	}

}
