Feature: single readtips are printed in correct form from the list of all

  Scenario: all readtips are listed and single tip is wanted
    Given command "l" list tips is given
    When type command "1" all is input
    And command "s" is chosen
    And index "1" is chosen
    Then the right tip shown

  Scenario: all readtips are listed and single tip is wanted
    Given command "l" list tips is given
    When type command "1" all is input
    And command "s" is chosen
    And index "100" is chosen
    Then "Bad index" is printed
