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

  Scenario: When enter is pressed in the list video tips menu
    Given command "l" list is selected and "2" video is chosen
    When command "" enter is input after listing videos
    Then output "Choose an action" is printed coming back from listing videos

  Scenario: When enter is pressed in the list book tips menu
    Given command "l" list is selected and "3" book is chosen
    When command "" enter is input after listing books
    Then output "Choose an action" is printed coming back from listing books

  Scenario: When enter is pressed in the list news tips menu
    Given command "l" list is selected and "4" news is chosen
    When command "" enter is input after listing news
    Then output "Choose an action" is printed coming back from listing news

  Scenario: When enter is pressed in the list article tips menu
    Given command "l" list is selected and "5" article is chosen
    When command "" enter is input after listing articles
    Then output "Choose an action" is printed coming back from listing articles

 Scenario: When enter is pressed in the list blogs tips menu
    Given command "l" list is selected and "6" blog is chosen
    When command "" enter is input after listing blogs
    Then output "Choose an action" is printed coming back from listing blogs
