package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    public ResetPasswordPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "user")
    public WebElement username;

    @FindBy(id="reset-password-submit")
    public WebElement resetPasswordBtn;

}
