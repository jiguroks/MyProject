package testlayer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompackage.Pomlogin;
import pompackage.Pomsignup;
import productstore.Baseclass;

public class Signuptest extends Baseclass {
	
	Pomsignup Btn;
	Pomlogin Login; 
	public Signuptest() {
		super();
	}
	

		@BeforeMethod
		public void inisetup() {
			initiate();
			Btn = new Pomsignup();
		    Login = new Pomlogin();
		}
		
		@Test(priority=1)
		public void Signupclick() throws InterruptedException {
			Btn.Clickbtn();
			Btn.typeusername(prop.getProperty("username"));
			Btn.typepassword(prop.getProperty("password"));
			Btn.clicksignup();
			Btn.clickonalert();
		}
	
		@Test(priority=2)
		public void Loginclick() throws InterruptedException {
			Login.clicklogin();
			Login.typeusername(prop.getProperty("username"));
			Login.typepassword(prop.getProperty("password"));
			Login.clickloginbtn();
			Login.clicklaptopopt();
			Login.clickselectlaptop();
			Login.clickaddtocart();
			Login.clickcart();
		}
			
		
		@AfterMethod
		public void close(){
			driver.close();
		}
}
