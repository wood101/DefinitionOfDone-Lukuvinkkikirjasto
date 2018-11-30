Feature: Bookmark can be browsed by type
    
    Scenario: video types can be retrieved from the database
        Given command "l" is input
        When  type command "2" is input
        Then  video tips are printed
    
    Scenario: book types can be retrieved from the database
        Given command "l" is input
        When  type command "3" is input
        Then  book tips are printed
    
    Scenario: news types can be retrieved from the database
        Given command "l" is input
        When  type command "4" is input
        Then  news tips are printed
    
    Scenario: article types can be retrieved from the database
        Given command "l" is input
        When  type command "5" is input
        Then  article tips are printed
    
    Scenario: blog types can be retrieved from the database
        Given command "l" is input
        When  type command "6" is input
        Then  blog tips are printed