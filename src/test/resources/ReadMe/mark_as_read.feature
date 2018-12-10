 Feature: readtip can be marked as read

  Scenario: unread bookmark is marked as aread
    Given command "l" list tips is given
    When  type command "r" all is input
    When  correct tip index '1' is input
    Then  bookmark is marked as read
    
  Scenario: wrong index number is given
    Given command "l" list tips is given
    When  type command "r" all is input
    When  correct tip index '10' is input
    Then  bookmark is not marked as read
    
  Scenario: read bookmark is marked as read again
    Given command "l" list tips is given
    When  type command "r" all is input
    When  correct tip index '1' is input
    Then  bookmark read date is updated
