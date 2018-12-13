 Feature: link can be opened from single tip view

  Scenario: correct link is opened in browser
    Given command "l" list tips is given
    When  command "1" is input for listing single view
    When  command "o" open link is given
    Then  bookmark's link is opened in browser
    
  Scenario: correct link can be made from book isbn
    Given command "l" list tips is given
    When  command "1" is input for listing single book view
    When  command "o" open link is given
    Then  book's link is opened in browser
