package jpetStore.TestComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jpetStore.pageobjects.LandingPage;

public class BaseTest {
	
	public static WebDriver driver;
	public LandingPage landingPage;

	public static WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"//src//main//java//jpetStore//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "/users/mohammedsamir/Documents/chromedriver");
			driver = new ChromeDriver();

			
		} else if (browserName.equalsIgnoreCase("firefox")) {

			//System.setProperty("webdriver.gecko.driver", "/users/mohammedsamir/Documents/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			
			//System.setProperty("webdriver.edge.driver", "/users/mohammedsamir/Documents/msedgedriver");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports" +testCaseName + ".png";
		
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
	
	String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data =
	mapper.readValue(jsonContent,
			new TypeReference<List<HashMap<String,String>>>(){
	
	});
	return data;
	}

	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		 driver = initializeDriver();
		 landingPage = new LandingPage(driver);
		 landingPage.goTo();
		 return landingPage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
