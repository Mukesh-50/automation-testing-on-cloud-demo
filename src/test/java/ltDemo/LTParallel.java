package ltDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LTParallel {

	@Parameters({"browserName","browserVersion","osVersion"})
	@Test
	public void loginTest(String browserName,String browserVersion,String osVersion) throws MalformedURLException {
		
		
		WebDriver driver=null;
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		
		ltOptions.put("username", "your username ");
		
		ltOptions.put("accessKey", "your access-key");
		
		ltOptions.put("build", "SeleniumBuild");
		
		ltOptions.put("project", "SeleniumBuild");
		
		ltOptions.put("w3c", true);
		
		
		if (browserName.equalsIgnoreCase("Chrome")) {
		
			ChromeOptions browserOptions = new ChromeOptions();
			
			browserOptions.setPlatformName(osVersion);
			
			browserOptions.setBrowserVersion(browserVersion);
		
			browserOptions.setCapability("LT:Options", ltOptions);
			
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
			
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")){
			
			FirefoxOptions browserOptions = new FirefoxOptions();
			
			browserOptions.setPlatformName(osVersion);
			
			browserOptions.setBrowserVersion(browserVersion);
		
			browserOptions.setCapability("LT:Options", ltOptions);
			
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
			
		}
		else if(browserName.equalsIgnoreCase("Edge")){
			
			EdgeOptions browserOptions = new EdgeOptions();
			
			browserOptions.setPlatformName(osVersion);
			
			browserOptions.setBrowserVersion(browserVersion);
		
			browserOptions.setCapability("LT:Options", ltOptions);
			
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
		
	
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		Assert.assertTrue(driver.getTitle().contains("Automation"));
		
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
	
		driver.quit();
		
		
	}
	
	
}
