@SYMU-366 @smoke
Feature:

  @SYMU-364
  Scenario: Verify that user can log out and ends up in login page- AlpY
    Given user is logged in
    When user clicks on logout button
    Then login page should be displayed to the user

  @SYMU-365
  Scenario: Verify that user cannot go back to home page after having logged out - AlpY
    Given user is logged in
    When user clicks on logout button
    And user clicks on go back button in the browser
    Then user should not see the homepage