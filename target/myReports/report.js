$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Logout.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@SYMU-366"
    }
  ]
});
formatter.scenario({
  "name": "Verify that user can log out and ends up in login page- AlpY",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SYMU-366"
    },
    {
      "name": "@SYMU-364"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.symund.step_definitions.LoginSteps.userIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on logout button",
  "keyword": "When "
});
formatter.match({
  "location": "com.symund.step_definitions.LogoutSteps.userClicksOnLogoutButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login page should be displayed to the user",
  "keyword": "Then "
});
formatter.match({
  "location": "com.symund.step_definitions.LogoutSteps.loginPageShouldBeDisplayedToTheUser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that user cannot go back to home page after having logged out - AlpY",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SYMU-366"
    },
    {
      "name": "@SYMU-365"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.symund.step_definitions.LoginSteps.userIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on logout button",
  "keyword": "When "
});
formatter.match({
  "location": "com.symund.step_definitions.LogoutSteps.userClicksOnLogoutButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on go back button in the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.symund.step_definitions.LogoutSteps.userClicksOnGoBackButtonInTheBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should not see the homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "com.symund.step_definitions.LogoutSteps.userShouldNotSeeTheHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});