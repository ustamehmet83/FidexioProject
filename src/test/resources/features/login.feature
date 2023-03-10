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
      | abcdef47@info.com       | abcdef       |
  @wip
  Scenario Outline: "Please fill out this field." message should be displayed
    When user enters empty mail "<email>" or password"<password>"
    And user click login button
    Then "Lütfen bu alanı doldurun." message should be displayed
    Examples:
      | email                   | password     |
      |                         | salesmanager |
      |                         | posmanager   |
      |                         | abcdef       |
      | salesmanager46@info.com |              |
      | posmanager47@info.com   |              |
      | abcdef@info.com         |              |
      |                         |              |


  Scenario: User should see the password in bullet signs by default
    Then user see the password in bullet signs

  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When user enters valid email "salesmanager55@info.com"
    And user enters valid password "salesmanager"
    And user press enter key of the keyboard
    Then user should be on the dashboard


