Feature: A new tip can be added if proper properties are given
    
    Scenario: videotip creation is successful with valid properties
     	Given command "a" add new readtip is selected and command "1" video is selected
        When  Title "title" and Author "author" and Link "www" and Description "desc" and Year published "2000" are input
        Then  a new videotip is added

    Scenario: booktip creation is successful with valid properties
     	Given command "a" add new readtip is selected and command "2" book is selected
        When  Title "title" and Author "author" and ISBN "12345" and Description "desc" and Year "2000" are input
        Then  a new booktip is added

    Scenario: newstip creation is successful with valid properties
     	Given command "a" add new readtip is selected and command "3" newstip is selected
        When  Title "title" and Author "author" and link "www" and Description "desc" and Publisher "publisher" and Year published "2000" are input
        Then  a new newstip is added

    Scenario: articletip creation is successful with valid properties
     	Given command "a" add new readtip is selected and command "4" article is selected
        When Title "title" and Author "author" and Link "www" and Description "desc" and Publisher "pub" and Year "2000" are input
        Then  a new articletip is added

    Scenario: blogtip creation is successful with valid properties
     	Given command "a" add new readtip is selected and command "5" blog is selected
        When Title "title" and Author "author" and Link "www" and Description "desc" and Year "2000" are input
        Then  a new blogtip is added