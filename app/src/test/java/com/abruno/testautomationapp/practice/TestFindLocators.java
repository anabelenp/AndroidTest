package com.abruno.testautomationapp.practice;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestFindLocators {
    public static AndroidDriver driver;

    @Test
    public void test_add_note_with_title_only() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.abruno.testautomationapp");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Notes");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(MobileBy.id("com.abruno.testautomationapp:id/fab")).click(); //add plus button
        driver.findElement(MobileBy.id("com.abruno.testautomationapp:id/notesTitle")).click();
        Actions action = new Actions(driver);
        action.sendKeys("Test Note 2").perform();
        driver.findElement(MobileBy.id("com.abruno.testautomationapp:id/fab")).click();

        Thread.sleep(3000);

        driver.quit();
    }



}
