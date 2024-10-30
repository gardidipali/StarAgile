package com.dipali.org.myname;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

  public class Amezon_Edge {
@Test
	public void HomepageCheck() throws MalformedURLException, URISyntaxException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("MicrosoftEdge");
	    WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.5:4444").toURL(),caps);
		// http://172.17.0.2:4444  // http://192.168.1.6:4444
	    driver.get("https://www.amazon.in/");
		Assert.assertTrue(driver.getTitle().contains("Amazon"), "Title does not contain 'Amazon'");
		driver.findElement(By.linkText("Mobiles")).click();
		Assert.assertTrue(driver.getTitle().contains("Mobiles"), "Title does not contain 'Amazon'");
		System.out.println("Successfull on Edge");
		driver.close();
		}
}
