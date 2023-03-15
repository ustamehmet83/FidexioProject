Feature:US-002 Log out Functionality

  Scenario: User can log out and ends up in login page.
    When User on the login page
    And User on the dashboard
    And User click logout button
    Then User log out and back to the login page

  @wip
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When User on the login page
    And User on the dashboard
    And User click logout button
    And User log out and back to the login page
    And User click the step back button
    Then User can not go to the home page