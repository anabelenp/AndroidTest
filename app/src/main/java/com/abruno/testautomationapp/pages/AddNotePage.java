package com.abruno.testautomationapp.pages;

import com.abruno.testautomationapp.base.PageBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddNotePage extends PageBase{

	
	@AndroidFindBy(id="com.abruno.testautomationapp:id/fab")
	public WebElement addNoteButton;
	
	@AndroidFindBy(id="com.abruno.testautomationapp:id/notesTitle")
	public WebElement titleInput;


	@AndroidFindBy(id="com.abruno.testautomationapp:id/fab")
	public WebElement saveNoteButton;

	public AddNotePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void clickOnCreateNoteButton() {	addNoteButton.click(); }

	public void enterNoteTitle(String titleText) {
		titleInput.click();
		titleInput.sendKeys("titleText");
		saveNoteButton.click();
	}

	public void saveNote() {
		saveNoteButton.click();
	}


	public String getNoteTitleText() {
		return this.titleInput.getText();
	}
}
