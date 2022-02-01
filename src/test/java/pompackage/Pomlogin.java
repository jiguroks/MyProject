package pompackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import productstore.Baseclass;

public class Pomlogin extends Baseclass {
	@FindBy (id="login2")
	WebElement login;
	@FindBy (id= "loginusername")
	WebElement username;
	@FindBy (id= "loginpassword")
	WebElement password;
	@FindBy (css= "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement loginbtn;
	@FindBy (xpath= "/html/body/div[5]/div/div[1]/div/a[3]")
	WebElement laptopopt;
	@FindBy (xpath= "/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a")
	WebElement selectlaptop;
	@FindBy (xpath= "/html/body/div[5]/div/div[2]/div[2]/div/a")
	WebElement addtocart;
	@FindBy (xpath= "/html/body/nav/div/div/ul/li[4]/a")
	WebElement cart;
	@FindBy (css= "#page-wrapper > div > div.col-lg-1 > div")
	WebElement confirmation;
public Pomlogin() {
	PageFactory.initElements(driver, this);
	
}
public void clicklogin() {
		login.click();
}
public void typeusername(String name) throws InterruptedException {
	Thread.sleep(5000);
	username.sendKeys(name);
}
public void typepassword(String pass) {
	password.sendKeys(pass);
}
public void clickloginbtn() throws InterruptedException {
	loginbtn.click();
	Thread.sleep(5000);
}
public void clicklaptopopt() throws InterruptedException {
	laptopopt.click();
	Thread.sleep(5000);
}
public void clickselectlaptop() throws InterruptedException {
	selectlaptop.click();
	Thread.sleep(5000);
	boolean a = driver.findElement(By.linkText("Add to cart")).isDisplayed();
	Assert.assertEquals(a, true);
	System.out.println(a);
}
public void clickaddtocart() throws InterruptedException {
	addtocart.click();
	Thread.sleep(5000);
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
public void clickcart() {
	cart.click();
	boolean b = confirmation.isDisplayed();
	Assert.assertEquals(b, true);
	System.out.println(b);
}
}
