package UM_emailOTP_module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import UM_emailOTP_module.DriverClass;

public class REST_POST_DeleteUser {
	
	public static String identitycontext = null;

	public static void deleteUser() throws IOException {
		
		// Java HTTPURLConnection 2
		
		URL url1 = new URL("https://testapi.ttcsp.cloud/userservice/api/v3/deleteuserprofile");
		HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
		con1.setRequestMethod("POST");
		con1.setRequestProperty("Content-Type", "application/json; utf-8");
		con1.setRequestProperty("identitycontext", DriverClass.identitycontext);
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
