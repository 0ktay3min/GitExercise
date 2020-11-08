@wip1
Feature: Bonsai Utils Project

  Scenario: Bonsai Utils
    Given User launches chrome browser
    When User opens Bonsai URL
    And User enters valid login credentials
    And User should see Bonsai Dashboard
    When User clicks Projects tab
    When User clicks NEW Project tab
    And User enters new project information and clicks Create Project
      | Client Name | Client Email    | Project Name | Hourly Rate |
      | Apple INC   | 4sjobs@apple.com | MAC OSX      |         150 |
    And User should see newly added Project on the Project List
    Then User will close browser