@register
Feature: Register a user.

  As a normal user
  I need create an account in the system
  for start the operations.

  Background:
    * def base = 'https://api.demoblaze.com/'

  Scenario: Successful register.
    Given url base + 'signup'
    When request
     """
      {
        "username":"pepito565",
        "password":"VGVzdDQ1Nis=="
      }
    """
    And method post
    Then status 200


  Scenario: Unsuccessful register
    Given url base + 'signup'
    When request
     """
      {
        "username":"pepito002",
        "password":"VGVzdDQ1Nis=="
      }
    """
    And method post
    Then status 200
    And match $.errorMessage == "This user already exist."