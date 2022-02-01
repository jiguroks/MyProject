package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import productstore.Baseclass;

public class Pomsignup extends Baseclass{

	//Object repository
	@FindBy (id="signin2")
	WebElement signup;
	@FindBy (id="sign-username")
	WebElement username;
	@FindBy (id="sign-password")
	WebElement password;
	@FindBy (css="#signInModal > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement signupbtn;
	@FindBy (css="#signInModal > div > div > div.modal-footer > button.btn.btn-secondary")
	WebElement cancelbtn;
	//Initiate page element
		
	public Pomsignup() {
		PageFactory.initElements(driver, this);
		
	}
	public void Clickbtn () {
		signup.click();
	
	}
	public void typeusername(String name) throws InterruptedException {
		Thread.sleep(5000);
		username.sendKeys(name);
	}
	public void typepassword(String pass) {
		password.sendKeys(pass);
	}
	public void clicksignup() {
		signupbtn.click();
	}
	public void clickonalert() throws InterruptedException {
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();	    
	    String a = alert.getText();
	    if (a=="This user already exist.") {
	    	alert.dismiss();
	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	cancelbtn.click(); 	
	    }
	    else { 
	    
		alert.accept();
	    }
	    }
}


