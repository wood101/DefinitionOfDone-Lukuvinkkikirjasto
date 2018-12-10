Feature: User can return to higher view with enter

  Scenario: When enter is pressed in the main menu
    Given command "" only enter in main menu is input
    Then error message: "Choose a correct input!" choose a correct input is printed

  Scenario: When enter is pressed in the add tip menu
    Given command "a" add new readtip is selected
    When command "" enter is input
    Then output "Choose an action" is printed

  Scenario: When enter is pressed in the list tips menu
    Given command "l" list is selected
    When command "" enter is input after listing
    Then output "Choose an action" is printed coming back from list

  Scenario: When enter is pressed in the list all tips menu
    Given command "l" list is selected and "1" all is chosen
    When command "" enter is input after listing all
    Then output "Choose an action" is printed coming back from listing all