package com.dipali.org.myname;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Amaezon_Chrome {
	
	@Test
		public void Homepagein() throws MalformedURLException, URISyntaxException {
		
//			DesiredCapabilities caps = new DesiredCapabilities();
			
//			caps.setBrowserName("chrome");

			//caps.setCapability(CapabilityType.BROWSER_NAME, "edge");
			
			//WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.6:4444").toURL(), caps);
			WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			Assert.assertTrue(driver.getTitle().contains("Amazon"), "Title does not contain 'Amazon'");
			driver.findElement(By.linkText("Mobiles")).click();
			Assert.assertTrue(driver.getTitle().contains("Mobiles"), "Title does not contain 'Amazon'");
			System.out.println("Successfull on Chrome");
			driver.close();
		}
	}

