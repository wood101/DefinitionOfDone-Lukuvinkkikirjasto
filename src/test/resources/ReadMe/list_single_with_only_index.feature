Feature: User can see single view of a reading tip with only an index.

  Scenario: the single view of a reading tip can be shown with giving the index only.
    Given all tips are shown by typing commands "l", "1"
    When command "1" is input for listing single view
    Then a single tip is shown