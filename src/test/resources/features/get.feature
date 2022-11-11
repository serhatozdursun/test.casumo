Feature: This end point removing the vowels from text

Scenario: as a client I want to remove all vowels from text that written with lower case
  Given "{input}" base url and 8080 port
  When Passed ":ioR" as "input" and send the GET request
  Then Respond shouldn't be contains any of the vowels