package com.abruno.testautomationapp.base;

import com.abruno.testautomationapp.utilities.AppiumServer;
import com.abruno.testautomationapp.utilities.CommonUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {

	public AppiumDriver<MobileElement> driver;

	public void setUp() {
		/** To do: driver == null
		 *  Load property files for either Android or IOS
		 *  Logger stuff
		 */
		AppiumServer.start();
		CommonUtils.setAndroidCapabilities();
		driver = CommonUtils.getAndroidDriver();
		}


	public void quit() {
	/** To do: driver == null
 	* Logger stuff
 	*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
		AppiumServer.stop();
	}

}
