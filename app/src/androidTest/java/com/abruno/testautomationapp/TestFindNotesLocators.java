package com.dexcom.testautomationapp;

public class TestFindNotesLocators {
    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Different ways to find an element
        //driver.findElement(MobileBy.id("io.selendroid.testapp:id/visibleButtonTest")).click();
        //driver.findElement(MobileBy.AccessibilityId("io.selendroid.testapp:id/visibleButtonTestCD")).click(); //cross platform and industry std. In the inpsector look at the content-desc value
        //driver.findElement(MobileBy.class("android.widget.Button")).click(); //class value
        //tageName[@attribute='value']
        //driver.findElement(MobileBy.xpath("//*[@content-desc='visibleButtonTestCD']")).click(); //xpath is slow but can be used
        //driver.findElement(MobileBy.xpath("//*[@text='Display text view']")).click();
        //driver.findElement(MobileBy.xpath("//*[contains(@text='Display text')]")).click();
        //driver.findElement(MobileBy.xpath("//*android.widget.Button[contains(@text='Display text')]")).click();
        driver.findElement(MobileBy.xpath("//*android.widgetLinearLayout/android.widget.Button[contains(@text='Display text')]")).click(); //parent/child classes
        System.out.println(driver.getPageSource()); // gets the html code
        Thread.sleep(3000);
        // driver.quit();



}
