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

public class ScrollingGeasture extends BaseTest{

	@Test
	public void ScrollTest() throws MalformedURLException, InterruptedException {
		
		//Start / Stop Appium Server,  Server, Capabilities configuration are taken care by BaseTest

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Scrolling when the Clicking element is known
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//Scrolling when Clicking element is not known
		scrollTillEnd();
		
	    Thread.sleep(2000);
		System.out.println("Test execited till here");
	}
	
}
