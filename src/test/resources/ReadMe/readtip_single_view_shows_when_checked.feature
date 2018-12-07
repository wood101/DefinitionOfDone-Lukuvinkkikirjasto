Feature: User can see when reading tip has been marked

  Scenario: after marking a tip as read the date checked is shown in single view
    Given all tips are shown by typing commands "l", "1"
    When command "r" is input
    And index "1" for tip to be marked is input
    Then the tip listed at index "1" shows when it was marked
