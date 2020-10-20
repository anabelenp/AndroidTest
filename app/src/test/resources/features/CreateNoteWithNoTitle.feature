Feature: As a user I not be able to create a note without a title

  Scenario Outline: New Note With No Title Creation
    Given the user clicks on the addNoteButton to create a note
    And the user clicks the save button
    Then <last_modified> should not appear on the home screen

    Examples:
      | last_modified  |
      | last modified: |
