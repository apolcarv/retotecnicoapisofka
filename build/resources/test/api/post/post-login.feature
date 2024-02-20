@login
Feature: Login a user.

  As a normal user
  I need login in the system
  for start the operations.

  Background:
    * def base = 'https://api.demoblaze.com/'

  Scenario: Successful login.
    Given url base + 'login'
    When request
    """
      {
         "username":"pepito777",
         "password":"VGVzdDQ1Nis="
      }
    """
    And method post
    Then status 200
    And match $.errorMessage == "Wrong password."

  Scenario: Unsuccessful login.
    Given url base + 'login'
    When request
    """
      {
         "username":"pepito777",
      }
    """
    And method post
    Then status 200
    And match $.errorMessage == "Bad parameter, missing username"