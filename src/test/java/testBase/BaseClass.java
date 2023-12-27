package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.ResourceBundle;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static Properties properties;
	public Logger logger;

	
	@BeforeClass(groups = {"Master","Regression","Sanity"})
	
	@Parameters("browser")
//	public void setup() 
	public void setup(String br){
		
//		/SeleniumProject/src/test/resources/config.properties
	
	  

		 try {
	            // Load the .properties file
	            properties = new Properties();
	            InputStream input = new FileInputStream("D:\\Eclipse\\SeleniumProject\\src\\test\\resources\\config.properties");
	            properties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
		//intianitiate the logger 
		logger = LogManager.getLogger(this.getClass());
		
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (br.equals("edge")){
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}
//		WebDriverManager.chromedriver().setup();
		//driver instance initiate
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();
		
		
	}
	
   @AfterClass	(groups = {"Master","Regression","Sanity"})
	public void tearDown() {
	   driver.quit();		
	}
   
   public String randomString() {
	   String generatedString= RandomStringUtils.randomAlphanumeric(5);
	   return (generatedString);
	   
   }
   public String randomNumber() {
	   String generatedString2= RandomStringUtils.randomAlphanumeric(10);
	   return (generatedString2);
   }
   
   public String randomAlphaNumeric() {
	   String st= RandomStringUtils.randomAlphanumeric(4);
	   String num= RandomStringUtils.randomNumeric(3);
	   return (st+"@"+num);
   }

public String captureScreen(String tname) throws 	IOException {
	// TODO Auto-generated method stub
	
//	SimpleDateFormat df= new SimpleDateFormat();
//	Date dt= new Date();
//	String timestamp= df.format(dt);
	
	String timestamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot takescreenshot= (TakesScreenshot)driver;
	File source= takescreenshot.getScreenshotAs(OutputType.FILE);
	
	String destination= System.getProperty("user.dir")+ "\\screenshots\\"+tname+"_"+timestamp+".png";
	try {
		FileUtils.copyFile(source, new File(destination));
	}
	catch(Exception e) {
		e.getMessage();
	}
	
	
	
	return destination;
	
}

}

