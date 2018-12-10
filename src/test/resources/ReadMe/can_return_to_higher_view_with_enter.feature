Feature: User can return to higher view with enter

  Scenario: When enter is pressed in the main menu
    Given command "" only enter in main menu is input
    Then error message: "Choose a correct input!" choose a correct input is printed
