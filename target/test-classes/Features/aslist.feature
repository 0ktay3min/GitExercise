@wip2
Feature: SignUp

  Scenario: SignUp with aslist
    Given User is on Bonsai signup page
    And User creates new account with below credentials
      | signupname | signupemail   | signuppassowrd |
      | ty         | ty@gmail.com  | abcdefg        |
      | uyr        | uyr@gmail.com | bnbngng        |
