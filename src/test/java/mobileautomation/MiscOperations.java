package mobileautomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscOperations extends BaseTest{

	@Test
	public void AppiumBasics() throws MalformedURLException {
		
		//Start / Stop Appium Server,  Server, Capabilities configuration are taken care by BaseTest

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		//Rotating the device into Landscape mode
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actualTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualTitle, "WiFi settings");
		
		//Coping the Text from Clip Board
		driver.setClipboardText("Kushi WiFi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
		//Keboard button pressing - Enter, Back, Home etc
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
	}
	
}
