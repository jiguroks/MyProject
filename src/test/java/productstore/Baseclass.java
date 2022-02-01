package productstore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Timeutils;


public class Baseclass  {
	
	public static WebDriver driver; 
	public static Properties prop = new Properties();
	public static Alert al;
	
	
	//Step 1 make constructor of class
	
	public Baseclass() {
		try {
			FileInputStream file = new FileInputStream ("C:\\Users\\jigur\\eclipse\\Demoblaze\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
	}
		
	//Step 2	Create all methods used in child class
		
		public static void initiate() {
			String browsername = prop.getProperty("browser");
			
			if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if (browsername.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Timeutils.timepage, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
	}


