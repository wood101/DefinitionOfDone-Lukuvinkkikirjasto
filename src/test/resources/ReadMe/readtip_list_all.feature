 Feature: all readtiplist is printed in correct form

  Scenario: all readtips are printed as a compact table
    Given command "l" list tips is given
    When  type command "1" all is input
    Then all readtips are printed in a table
    
  Scenario: print doesn't contain extra information
    Given command "l" list tips is given
    When  type command "1" all is input
    Then table don't contain link
 
  Scenario: if field data is longer than column length
    Given data with a long author field exists
    And command "l" list tips is given
    When  type command "1" all is input
    Then table contains "..."
       
