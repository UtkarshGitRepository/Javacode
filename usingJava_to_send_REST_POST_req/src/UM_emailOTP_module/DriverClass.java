package UM_emailOTP_module;

import UM_emailOTP_module.REST_POST_RegisterUser;
import UM_emailOTP_module.invoke_SeleniumWD_verify_EmailOTP;
import UM_emailOTP_module.REST_POST_DeleteUser;

import java.io.IOException;
import org.openqa.selenium.WebElement;



public class DriverClass {
	
	public static String identitycontext = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		REST_POST_RegisterUser.registerUser();
		invoke_SeleniumWD_verify_EmailOTP.invokeSeleniumWD();
		REST_POST_DeleteUser.deleteUser();
		

	}

}
