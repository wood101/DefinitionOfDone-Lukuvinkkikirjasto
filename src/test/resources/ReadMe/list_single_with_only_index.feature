Feature: User can see single view of a reading tip with only an index.

  Scenario: after marking a tip as read the date checked is shown in single view
    Given all tips are shown by typing commands "l", "1"
    When command "1" is input for listing single view
    And ...
    Then ...
