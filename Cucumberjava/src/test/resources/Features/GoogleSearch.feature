@kowshik
Feature: Google search

  
  Scenario Outline: Google search validation
    Given Application verifys the application url login page
    When user search for a song "<Song>"
    Then Playing the song

    Examples: 
      | Song |
      | SC2   |
      
