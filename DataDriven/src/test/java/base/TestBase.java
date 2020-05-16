package base;

import java.io.FileInputStream;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilites.ExcelReader;




public class TestBase  {

	public static WebDriver driver;
	public static Properties config =new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
    public static Logger log=Logger.getLogger("devpinoyLogger");
    public static ExcelReader excel=new ExcelReader("C:\\Users\\Acheron\\eclipse-workspace\\DataDriven\\src\\test\\resources\\excel\\ExcelReading.xlsx");
    @BeforeSuite
	public void setup() {
		if (driver== null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      try {
				or.load(fis);
				log.debug("Prop file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Launched");
		}
		driver.get(config.getProperty("url"));
		log.debug("Navigated to : "+config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Implicit.wait")),
				TimeUnit.SECONDS);

	}

	@AfterSuite
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
		log.debug("Execution Completed");
	}
}