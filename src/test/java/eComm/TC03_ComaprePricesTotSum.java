package eComm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class TC03_ComaprePricesTotSum extends BaseTestECom{
	
	@Test
	public void fillForm() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Kushi");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Scroll till  view the required Item
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		//Selecting the Item
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		System.out.println("Number of Items :" +productCount);
		
		for(int i=0; i<productCount; i++) {
			
			String itemName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println("Item Name :" +itemName);
			
			if(itemName.equalsIgnoreCase("Jordan 6 Rings"))
					{
				        Thread.sleep(4000);
						driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
						System.out.println("Test case passed :)");
					}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click();
	    
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String CartItem = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(CartItem, "Jordan 6 Rings");
		
	}

}
