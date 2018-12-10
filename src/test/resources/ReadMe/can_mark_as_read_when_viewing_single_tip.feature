Feature: When viewing a single tip, user can mark it as read.

  Scenario: With the correct command, a non-read tip is marked as read in single view.
    Given all tips are shown by typing commands "l", "1"
    When command "1" is input for listing single view
    And input "r" is given
    Then tip is marked as read and message "Marked as read" is shown
