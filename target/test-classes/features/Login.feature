@SYMU-354
Feature:

  @SYMU-353
  Scenario: Verify that user can see valid placeholders on Username and Password fields - AlpY
    Given the user is on the login page
    When user leaves username and password blank
    Then user should see valid placeholders in username and password fields

  @SYMU-352
  Scenario: Verify that user can see an option link like "forgot password" on the login page - AlpY
    Given the user is on the login page
    When user clicks on Forgot Password button
    Then user should see username input and Reset Password button

  @SYMU-351
  Scenario: Verify that user can see the password explicitly when eye icon is clicked one time- AlpY
    Given the user is on the login page
    When user enters any password
    And user clicks on eye icon on the right
    Then password should be seen explicitly

  @SYMU-350
  Scenario: Verify that user can see the entered password in a form of dots by default- AlpY
    Given the user is on the login page
    When user enters any password
    Then user should see the password in a form of dots

  @SYMU-348
  Scenario Outline: Verify that user cannot login with blank username or password- AlpY
    Given the user is on the login page
    When user enters blank "<username>" or "<password>"
    And clicks Login button
    Then "Please fill out this field." message should be seen under related "<input>"

    Examples:
      | username   | password    | input    |
      |            | Employee123 | username |
      | Employee91 |             | password |

  @SYMU-347
  Scenario Outline: Verify that user cannot login with invalid credentials - AlpY
    Given the user is on the login page
    When user enters "<invalidUser>" "<invalidPass>"
    And clicks Login button
    Then user should see "Wrong username or password." message.

    Examples:
      | invalidUser  | invalidPass |
      | Employee91   | emplyee234  |
      | employer1234 | Employee123 |
      | EmployeeABC  | 12345       |

  @SYMU-343
  Scenario: Verify that user can login with valid credentials and with ENTER key - AlpY
    Given the user is on the login page
    When the user enters valid credentials
    And hits enter key
    Then the user should land on "Dashboard" page
    And username should be seen under profile icon as expected

  @SYMU-342
  Scenario: Verify that user can login with valid credentials and with login button - AlpY
    Given the user is on the login page
    When the user enters valid credentials
    And clicks Login button
    Then the user should land on "Dashboard" page
    And username should be seen under profile icon as expected