Feature: User can return to higher view with enter

  Scenario: When enter is pressed in the main menu
    Given command "" only enter in main menu is input
    Then error message: "Choose a correct input!" choose a correct input is printed

  Scenario: When enter is pressed in the add tip menu
    Given command "a" add new readtip is selected
    When command "" enter is input
    Then output "Choose an action" is printed
