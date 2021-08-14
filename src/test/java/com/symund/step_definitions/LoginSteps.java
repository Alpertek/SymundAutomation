package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.pages.ResetPasswordPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        String username = ConfigurationReader.get("valid_username");
        String password = ConfigurationReader.get("valid_password");

        loginPage.login(username,password);
    }

    @When("clicks Login button")
    public void clicks_Login_button() {
        loginPage.loginBtn.click();

    }

    @Then("the user should land on {string} page")
    public void the_user_should_land_on_page(String pageName) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue("Verify that page title contains "+pageName,Driver.get().getTitle().contains(pageName));
    }

    @Then("username should be seen under profile icon as expected")
    public void username_should_be_seen_under_profile_icon_as_expected() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.userIcon.click();

        String expectedUsername = ConfigurationReader.get("valid_username");
        Assert.assertTrue(dashboardPage.usernameElement.isDisplayed());
        Assert.assertEquals(expectedUsername,dashboardPage.usernameElement.getText());
    }

    @And("hits enter key")
    public void hits_enter_key(){
        loginPage.password.sendKeys(Keys.ENTER);
    }

    @When("user enters {string} {string}")
    public void user_enters(String invalidUsername, String invalidPassword) {
        loginPage.login(invalidUsername,invalidPassword);
    }

    @Then("user should see {string} message.")
    public void user_should_see_message(String warningMessage) {
        try{
            if (loginPage.warning30sec.isDisplayed()){
                BrowserUtils.waitForVisibility(loginPage.wrongPasswordWarning,32);
            }
        }catch (NoSuchElementException noSuchElementException){
            if(Driver.get().getTitle().contains("504")){
                Driver.get().get(ConfigurationReader.get("url"));
            }
        }

        Assert.assertTrue(loginPage.wrongPasswordWarning.isDisplayed());
        Assert.assertEquals(warningMessage,loginPage.wrongPasswordWarning.getText());

    }

    @When("user enters blank {string} or {string}")
    public void userEntersBlankOr(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("{string} message should be seen under related {string}")
    public void messageShouldBeSeenUnderRelated(String message,String inputType) {
        if(inputType.equals("username")){
            Assert.assertEquals(message,loginPage.username.getAttribute("validationMessage"));
        }else{
            Assert.assertEquals(message,loginPage.password.getAttribute("validationMessage"));
        }
    }

    @When("user enters any password")
    public void userEntersAnyPassword() {
        loginPage.password.sendKeys("abc135*-");

    }

    @Then("user should see the password in a form of dots")
    public void userShouldSeeThePasswordInAFormOfDots() {
        Assert.assertEquals("password",loginPage.password.getAttribute("type"));
    }

    @And("user clicks on eye icon on the right")
    public void userClicksOnEyeIconOnTheRight() {
        loginPage.togglePassword.click();
    }

    @Then("password should be seen explicitly")
    public void passwordShouldBeSeenExplicitly() {
        Assert.assertEquals("text",loginPage.password.getAttribute("type"));
    }

    @When("user clicks on Forgot Password button")
    public void userClicksOnForgotPasswordButton() {
        loginPage.forgotPasswordbtn.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("user should see username input and Reset Password button")
    public void userShouldSeeUsernameInputAndResetPasswordButton() {
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        BrowserUtils.waitForStaleElement(resetPasswordPage.username);
        Assert.assertTrue(resetPasswordPage.username.isDisplayed());
        Assert.assertTrue(resetPasswordPage.resetPasswordBtn.isDisplayed());

    }

    @When("user leaves username and password blank")
    public void userLeavesUsernameAndPasswordBlank() {
        loginPage.login("","");
    }

    @Then("user should see valid placeholders in username and password fields")
    public void userShouldSeeValidPlaceholdersInUsernameAndPasswordFields() {
        Assert.assertEquals("Username or email",loginPage.username.getAttribute("placeholder"));
        Assert.assertEquals("Password",loginPage.password.getAttribute("placeholder"));
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        the_user_is_on_the_login_page();
        the_user_enters_valid_credentials();
        clicks_Login_button();
        the_user_should_land_on_page("Dashboard");
    }


}
