Feature: Multiple Windows

Scenario: Get current window handle

When User is on page
And  User get current window handle and print it
And User opens a new window and switches to new window
Then User get backs to parent window
