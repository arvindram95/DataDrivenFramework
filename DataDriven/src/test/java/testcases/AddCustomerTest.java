package testcases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilites.ExcelReader;
public class AddCustomerTest extends TestBase {
	@Test(dataProvider="getdata")
	public void AddCustomerTest(String FirstName,String LastName,String PostCode) throws InterruptedException {
		driver.findElement(By.cssSelector(or.getProperty("addCustBtn_CSS"))).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(or.getProperty("firstname_CSS"))).sendKeys(FirstName);
		Thread.sleep(5000);
		driver.findElement(By.xpath(or.getProperty("lastname_XPATH"))).sendKeys(LastName);
		driver.findElement(By.cssSelector(or.getProperty("postcode_CSS"))).sendKeys(PostCode);
		driver.findElement(By.cssSelector(or.getProperty("addbtn_CSS"))).click();
		Reporter.log("Customer added sucessfully");
	}
	@DataProvider(name="getdata")
	public Object[][] getdata() {
		String sheetName="AddCustomerTest";
		int rows=excel.getRowCount(sheetName);
		int columns=excel.getColumnCount(sheetName);
		Object[][] data=new Object[rows-1][columns];
		for(int rowNum=2; rowNum<=rows;rowNum++) {
			
		
		for(int colNum=0;colNum<columns;colNum++) {
			data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
		}
		}
		return data;
	}
	

	

}
