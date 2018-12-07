 Feature: empty lists are not shown

    Scenario: if tips are not found error message is given
        Given command "l" list tips is given
        When  type command "1" all is input
        Then error message :"No reading tips found." is printed
    
#    Scenario: if tips are not found error message is given
#        Given command "l" list tips is given
#        When  type command "2" video is input
#        Then error message :"No reading tips found." is printed
#    Scenario: if tips are not found error message is given
#        Given command "l" list tips is given
#        When  type command "3" book is input
#        Then error message :"No reading tips found." is printed
#
#    Scenario: if tips are not found error message is given
#        Given command "l" list tips is given
#        When  type command "4" news is input
#        Then error message :"No reading tips found." is printed
#
#    Scenario: if tips are not found error message is given
#        Given command "l" list tips is given
#        When  type command "5" article is input
#        Then error message :"No reading tips found." is printed
#
#    Scenario: if tips are not found error message is given
#        Given command "l" list tips is given
#        When  type command "6" blog is input
#        Then error message :"No reading tips found." is printed