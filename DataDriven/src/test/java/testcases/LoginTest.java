package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {
	@Test
 public void LoginBankApp() throws InterruptedException {
		log.debug("Inside Login Test");
	 driver.findElement(By.cssSelector(or.getProperty("bmlbutton"))).click();
	 Thread.sleep(4000);
	 log.debug("Login executed Sucessfully");
 }
}
