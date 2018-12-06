 Feature: all readtiplist is printed in correct form

  Scenario: all readtips are printed in a compact table
    Given command "l" list tips is given
    When  type command "1" all is input
    Then all readtips are printed in a table
    
  Scenario: print dont't contain extra information
    Given command "l" list tips is given
    When  type command "1" all is input
    Then table don't contain year'
    
