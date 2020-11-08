@wip
Feature: Creaate a new account

  Scenario: Creaate a new account in Bonsai
    When I am on bonsai
    And I use following credentials to creaate a new registry
      | email        | name    | password |
      | ty@gmail.com | ty arsu | abcdef   |
