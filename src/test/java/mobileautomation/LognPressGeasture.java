package mobileautomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LognPressGeasture extends BaseTest{

	@Test
	public void longPressTest() throws MalformedURLException, InterruptedException {
		
		//Start / Stop Appium Server,  Server, Capabilities configuration are taken care by BaseTest

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	    
		//Long press in People name
		WebElement peopleName = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	    longPressGesture(peopleName);
	    
	    //Asserting the values after long press action
	    String menuText = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
	    Assert.assertEquals(menuText, "Sample menu");
	    Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
	    
		System.out.println("Test execited till here");
	}
	
}
