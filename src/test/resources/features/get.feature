Feature: This end point removing the vowels from text

  Scenario: as a client I want to remove all vowels from text that written with lower case
    Given "{input}" base url and 9292 port
    When Passed ":TaeioT" as "input" and send the GET request
    Then Respond shouldn't be contains any of the vowels

  Scenario: as a client I want to remove all vowels from text that written with upper case
    Given "{input}" base url and 9292 port
    When Passed ":TAEIOT" as "input" and send the GET request
    Then Check status code 200
    Then Respond shouldn't be contains any of the vowels