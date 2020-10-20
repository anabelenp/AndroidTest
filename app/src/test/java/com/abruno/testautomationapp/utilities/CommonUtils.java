package com.abruno.testautomationapp.utilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	
	
	private static AppiumDriver<MobileElement> driver;
	private static URL serverUrl;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	
	//setting android cap
	public static void setAndroidCapabilities() {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.abruno.testautomationapp");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.abruno.testautomationapp.Notes");
	}
	

	public static AppiumDriver<MobileElement> getAndroidDriver() {
		
		try {
			serverUrl=new URL("http://localhost:127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverUrl,capabilities);
		return driver;
		
	}
	
	
	public static AppiumDriver<MobileElement> getIOSDriver() {
		return driver;
	}
}
