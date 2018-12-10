Feature: User can search for reading tips with a given keyword.

  Scenario: Searching for reading tip by part of author name
    Given user has typed search command "f"
    When user types keyword "hack"
    Then a list of matching reading tips

  Scenario: Searching for tip by part of title
    Given user has typed search command "f"
    When user types keyword "P vs. NP"
    Then a list of matching reading tips

  Scenario: Searching for reading tip by year
    Given user has typed search command "f"
    When user types keyword "2014"
    Then a list of matching reading tips

  Scenario: Searching for reading tip with keyword not matching anything
    Given user has typed search command "f"
    When user types keyword "The hitchhikers guide"
    Then informs user that no reading tips found
