package com.trello.UI.pages;

import com.trello.UI.core.Constants;
import com.trello.UI.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.UI.core.BrowserFactory.driver;
import static com.trello.UI.core.BrowserFactory.get;

public class BoardsPage {

    private static final String PATH= "annatkachenko11/boards";

    public Elem createBoardBtn =new Elem (By.cssSelector(".board-tile.mod-add"), "Create Board button");
    public Elem newBoardNameFld = new Elem(By.cssSelector(".subtle-input"), "Board Name field");
    public Elem submitCreateBoardBtn = new Elem
            (By.cssSelector("#chrome-container > div.window-overlay.mod-no-chrome-overlay > div > div > div > form > button"),
                    "Submit button");
    public Elem personalSettingsIcon= new Elem(By.cssSelector("#header > div.TMI28E0KnYSK9p > button._2ZNy4w8Nfa58d1.js-open-header-member-menu._3R2LYccoXhpfv9 > div > span"));
    public Elem logoutBtn=new Elem(By.cssSelector("[data-test-id*='header-member-menu-logout'"));


    public void opened() {
        get(Constants.URL+PATH);
        Assert.assertTrue(isOpened(), "Page 'Boards' ["+PATH+"] is not opened");
    }


    public boolean isOpened() {
        return driver().getCurrentUrl().equals(Constants.URL+PATH);
    }

    private Elem boardByUrlName (String urlName) {
       return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"),urlName);
    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }


    public void createBoard (String boardName)
    {
        createBoardBtn.click();
        newBoardNameFld.type(boardName);
        submitCreateBoardBtn.click();
    }


    public void logout()
    {
        personalSettingsIcon.click();
        logoutBtn.click();
    }


}
