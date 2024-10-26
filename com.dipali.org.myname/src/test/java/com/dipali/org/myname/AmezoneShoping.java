package com.dipali.org.myname;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AmezoneShoping {
	
	public WebDriver driver;
	
	@DataProvider
	public Object[][] getBrowser() {
		return new Object[][] {
					{"chrome"},
					{"edge"},
					{"firfox"}
		};
	}
	@BeforeClass
	@Test(dataProvider= "getBrowser" )
		public void setUp(String browser) throws MalformedURLException, URISyntaxException {
		
			DesiredCapabilities caps = new DesiredCapabilities();
        	caps.setBrowserName(browser);
        	 driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), caps);      
			}
			@Test(dependsOnMethods = "setUp")
			public void amezonIn() {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://www.amazon.in/");
				System.out.println(driver.getTitle());
				Assert.assertTrue(driver.getTitle().contains("Amazon"), "Title does not contain 'Amazon'");
				driver.findElement(By.linkText("Mobiles")).click();
				Assert.assertTrue(driver.getTitle().contains("Mobiles"), "Title does not contain 'Amazon'");
			}
			@AfterClass
		    public void tearDown() {
		        if (driver != null) 
		        {
		            driver.quit();
		        }	
		}
	}
