package com.trello.UI.pages;

import com.trello.UI.core.Constants;
import com.trello.UI.core.Elem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static com.trello.UI.core.BrowserFactory.driver;
import static com.trello.UI.core.BrowserFactory.get;
import static com.trello.UI.core.Constants.URL;

public class LoginPage {

    private static final String PATH = "login";

    public Elem emailFld= new Elem (By.cssSelector("#user"), "Email Field");
    public Elem passwordFld = new Elem (By.cssSelector("#password"), "Password Field");
    public Elem loginBtn = new Elem (By.cssSelector("#login"), "Login Button");


    @Step
    public  void open(){
        get(Constants.URL+PATH);
        Assert.assertTrue(isOpened(), "Page 'Login' ["+PATH+"] is not opened");
    }

    public boolean isOpened() {
        return loginBtn.isPresent() && driver().getCurrentUrl().equals(Constants.URL+PATH);
    }


    @Step
    public  void login (String email, String password){
        emailFld.type(email);
        passwordFld.type(password);
        loginBtn.click();
    }

}
