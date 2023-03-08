#Execution
Feature:Login Functionality

  Background:
  Given User is on login page

  #Test Case

  Scenario Outline: User login with valid credentials
    When user enters valid email "<email>"
    And user enters valid password "<password>"
    And user click login button
    Then user should be on the dashboard

    Examples: Email and Password
      | email                   | password     |
      | salesmanager46@info.com | salesmanager |
      | salesmanager47@info.com | salesmanager |
      | salesmanager48@info.com | salesmanager |
      | posmanager48@info.com   | posmanager   |
      | posmanager49@info.com   | posmanager   |
      | posmanager50@info.com   | posmanager   |
  @wip
  Scenario Outline: User login with invalid credentials
      When user enters invalid mail "<email>" or password"<password>"
      And user click login button
      Then "Wrong login/password" should be displayed

      Examples:
        | email                   | password     |
        | salesmanager46@info.com | abcdef       |
        | posmanager47@info.com   | abcdef       |
        | abcdef46@info.com       | salesmanager |
        | abcdef47@info.com       | posmanager   |
