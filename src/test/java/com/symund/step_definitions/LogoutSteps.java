package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutSteps {
    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.userIcon.click();
        dashboardPage.logoutBtn.click();
    }

    @Then("login page should be displayed to the user")
    public void loginPageShouldBeDisplayedToTheUser() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue(Driver.get().getCurrentUrl().startsWith(ConfigurationReader.get("url")));
    }

    @And("user clicks on go back button in the browser")
    public void userClicksOnGoBackButtonInTheBrowser() {
        BrowserUtils.waitForPageToLoad(5);
        Driver.get().navigate().back();
    }

    @Then("user should not see the homepage")
    public void userShouldNotSeeTheHomepage() {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue(Driver.get().getCurrentUrl().startsWith(ConfigurationReader.get("url")));
    }
}
