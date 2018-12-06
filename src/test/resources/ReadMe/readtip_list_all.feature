 Feature: all readtiplist is printed in correct form

  Scenario: all readtips are printed in a compact table
    Given command "l" list tips is given
    When  type command "1" all is input
    Then all readtips are printed in a table
    
