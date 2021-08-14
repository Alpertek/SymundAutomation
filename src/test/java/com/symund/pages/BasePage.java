package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "expand")
    public WebElement userIcon;

    @FindBy(css = "li[data-id='logout']")
    public WebElement logoutBtn;

    @FindBy(css = "span.user-status-menu-item__header")
    public WebElement usernameElement;
}
