@US002
Feature:Log out Functionality
  Background:
  Given User on the dashboard

  @FIDEX10-478
  Scenario: User can log out and ends up in login page.
    And User click username and logout button
    Then User log out and back to the login page

  @FIDEX10-484
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    And User click username and logout button
    And User log out and back to the login page
    And User click the step back button
    Then User can not go to the home page