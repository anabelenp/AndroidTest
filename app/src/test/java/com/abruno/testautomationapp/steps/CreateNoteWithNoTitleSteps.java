package com.abruno.testautomationapp.steps;

import com.abruno.testautomationapp.base.TestBase;
import com.abruno.testautomationapp.pages.AddNotePage;
import com.abruno.testautomationapp.pages.HomePage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


@RunWith(JUnit4.class)
public class CreateNoteWithNoTitleSteps extends TestBase {

    AddNotePage addNote;
    HomePage hp;

    @Before
    public void initialization() {
        setUp();
        addNote = new AddNotePage(driver);
        hp = new HomePage(driver);
     }

    @After
    public void tearDown() {
        quit();
    }


    @Given("the user clicks on the addNoteButton to create a note")
    public void the_user_clicks_on_the_add_note_button_to_create_a_note() {
        addNote.clickOnCreateNoteButton();
    }

    @And("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        addNote.saveNote();
    }

    @Then("{string} should not appear on the home screen")
    public void expected_note_should_not_appear_on_the_home_screen(String lastModifiedStr) {
        Assert.assertFalse(hp.getLastUpdatedNoteText().contains(lastModifiedStr));
    }
}
