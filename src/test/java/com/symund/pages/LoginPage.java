package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "user")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(id="lost-password")
    public WebElement forgotPasswordbtn;

    @FindBy(css = "p.warning.wrongPasswordMsg")
    public WebElement wrongPasswordWarning;

    @FindBy(css="a.toggle-password")
    public WebElement togglePassword;

    @FindBy(css = ".warning.throttledMsg")
    public WebElement warning30sec;

    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }
}
