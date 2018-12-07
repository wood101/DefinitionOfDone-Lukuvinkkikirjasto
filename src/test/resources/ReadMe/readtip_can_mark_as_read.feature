Feature: You can mark a tip as read

  Scenario: tip can be marked as read by giving index
    Given all tips are shown by typing commands "l", "1"
    When command "r" is input
    And index "1" for tip to be marked is input
    Then the tip listed at index "1" has been marked as read

  Scenario: typing an index not represented by anything listed is ignored
    Given all tips are shown by typing commands "l", "1"
    When command "r" is input
    And index "1234" for tip to be marked is input
    Then the input is rejected and application responds "Bad index"
