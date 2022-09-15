package eComm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestECom {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
			
		   //Controlling the Server
				service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\nkcs\\AppData\\Roaming\\npm\\node_modules"
						+ "\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
						
				service.start();
				//Accessing the mobile Application
				File appDir = new File("C:\\Users\\nkcs\\Documents\\XStore\\Automation Source Code\\Appium\\src\\test\\java\\resources");
				File app = new File(appDir, "General-Store.apk");
				
				UiAutomator2Options options = new UiAutomator2Options();
				options.setCapability(MobileCapabilityType.DEVICE_NAME,  "Pixel5");
				options.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));			
	}
	
	public void longPressGesture(WebElement peopleName) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",  ((RemoteWebElement)peopleName).getId(), 
						"duration", 2000));
		
	}
	
	public void scrollTillEnd() {
		boolean canScrollMore;
		
		//***** Till scrollinng the specific point // known point
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		do
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void dragDrop(WebElement src, int xCord, int yCord) {

		//Drag & Drop gesture
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) src).getId(),
			    "endX", xCord,
			    "endY", yCord
			));
		
	}
	
	@AfterClass
	public void tearDown() {
		//Closing the MobApp & Appium Server
				driver.quit();
				service.stop();
		
	}

}
