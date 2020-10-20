package com.abruno.testautomationapp.steps;

import com.abruno.testautomationapp.base.TestBase;
import com.abruno.testautomationapp.pages.AddNotePage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@RunWith(JUnit4.class)
public class CreateNoteSteps extends TestBase {

    AddNotePage addNote;

    @Before
    public void initialization() {
        setUp();
        addNote = new AddNotePage(driver);

     }

    @After
    public void tearDown() {
        quit();
    }


    @Given("the user clicks on the addNoteButton")
    public void the_user_clicks_on_the_add_note_button() {
        addNote.clickOnCreateNoteButton();
    }

    @When("the user enters the {string}")
    public void the_user_enters_the_note_title(String title) {
        addNote.enterNoteTitle(title);
    }

    @And("the user clicks on the save button")
    public void the_user_clicks_on_the_save_button() {
        addNote.saveNote();
    }

    @Then("{string} should appear on the home screen")
    public void expected_note_should_appear_on_the_home_screen(String expectedTitle) {
        Assert.assertTrue(addNote.getNoteTitleText().contains(expectedTitle));
    }
}
