package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.getProperty("user.dir");
      Properties config=new Properties();
      Properties or =new Properties();
      FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
      config.load(fis);
      System.out.println(config.getProperty("browser"));
      FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
      or.load(fis1);
      	System.out.println(or.getProperty("bmlbutton"));
	}

}
