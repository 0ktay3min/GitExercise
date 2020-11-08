Feature: Bonsai Login

  Scenario: Bonsai Login with Positive and Negative Test
    When User is in bonsaihomepage
    And  User enter correct <username> and <password>
    Then User should login and should see dashboard page
    
  |username                |password     |
  |service_dev@codistan.com|IBecameACoder|
    