Feature: As a user I want to create a Note with a title

  Scenario Outline: New Note Creation
    Given the user clicks on the addNoteButton
    When the user enters the <noteTitle>
    And the user clicks on the save button
    Then <expectedNote> should appear on the home screen

    Examples:
    | noteTitle | expectedNote |
    | test note | test note    |
