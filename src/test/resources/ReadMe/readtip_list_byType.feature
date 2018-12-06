Feature: readtiplists by type are printed in correct form

  Scenario: videotips are printed in a compact table
    Given command "l" list tips is given
    When  type command "2" video is input
    Then videotips are printed in a table

  Scenario: videotips do not contain extra information
    Given command "l" list tips is given
    When  type command "2" video is input
    Then videotable does not contain year

  Scenario: booktips are printed in a compact table
    Given command "l" list tips is given
    When  type command "3" book is input
    Then booktips are printed in a table

  Scenario: booktips do not contain extra information
    Given command "l" list tips is given
    When  type command "3" book is input
    Then booktable does not contain year

  Scenario: newstips are printed in a compact table
    Given command "l" list tips is given
    When  type command "4" news  is input
    Then newstips are printed in a table

  Scenario: newstips do not contain extra information
    Given command "l" list tips is given
    When  type command "4" news  is input
    Then newstable does not contain year

  Scenario: articletips are printed in a compact table
    Given command "l" list tips is given
    When  type command "5" article is input
    Then articletips are printed in a table

  Scenario: articletips do not contain extra information
    Given command "l" list tips is given
    When  type command "5" article is input
    Then articletable does not contain year

  Scenario: blogtips are printed in a compact table
    Given command "l" list tips is given
    When  type command "6" blogs is input
    Then blogtips are printed in a table

  Scenario: blogtips do not contain extra information
    Given command "l" list tips is given
    When  type command "6" blog  is input
    Then blogtable does not contain year

