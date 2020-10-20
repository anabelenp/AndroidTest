package com.abruno.testautomationapp.pages;

import com.abruno.testautomationapp.base.PageBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends PageBase{


	@AndroidFindBy(id="com.abruno.testautomationapp:id/lastUpdatedDate")
	public WebElement lastUpdatedDateText;

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public String getLastUpdatedNoteText() {
		return this.lastUpdatedDateText.getText();
	}

	
}
