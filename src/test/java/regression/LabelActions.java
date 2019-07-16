package regression;

import com.trello.UI.core.BrowserFactory;
import com.trello.UI.pages.BoardsPage;
import com.trello.UI.pages.CardPage;
import com.trello.UI.pages.LabelPage;
import com.trello.UI.pages.LoginPage;
import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.TrelloLabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

public class LabelActions  extends BrowserFactory {
    public TrelloRestClient client=new TrelloRestClient();

    public LoginPage loginPage= new LoginPage();
    public BoardsPage boardsPage=new BoardsPage();
    public CardPage cardPage=new CardPage();
    public LabelPage labelPage=new LabelPage();

    Card card=new Card("Test_Card"+new Date().getTime());

    TrelloLabel label= new TrelloLabel();

    @BeforeTest
    public void prepareData() throws IOException {
        card= client.cardsService.createCard("5d1243e36d5cc63a3a218058", card).execute().body();
        label= client.labelService.createLabel("LAbelTest", "lime", "5d1243dc36ad054e1df2a07e").execute().body();
    }


    @AfterTest
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }


    @Test
    public void login() {
        loginPage.open();
        loginPage.login("nanccy95@gmail.com", "anna5624787");
        WebElement explicitWait = (new WebDriverWait(driver(), 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label*='Back to Home']")));
        Assert.assertTrue(driver().getCurrentUrl().equals("https://trello.com/annatkachenko11/boards"));
    }

    @Test (dependsOnMethods = "login")
    public void openLabelPage(){
        boardsPage.openBoard("WCtONhWe");
        String cardUrl = card.url.substring(21, 29);
        labelPage.open(cardUrl);
    }


    @Test (dependsOnMethods = "openLabelPage")
    public void createLabel() {
        labelPage.addLabel("Label1");
        //Assert.assertTrue(=="Label1" );
    }

    @Test (dependsOnMethods = "openLabelPage")
    public void renameLabel() throws IOException {
        labelPage.changeLabel(label.id, "New Name");
        WebElement explicitWait = (new WebDriverWait(driver(), 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-add-label")));
        label= client.labelService.getLabel(label.id).execute().body();
        Assert.assertTrue(label.name.equals("New Name"));
    }

    @Test (dependsOnMethods = "renameLabel")
    public void deleteLabel() {
        labelPage.deleteLabel(label.id);

    }


    @Test (dependsOnMethods = "deleteLabel")
    public void logout(){
        labelPage.closeLabelWindow();
        cardPage.closeCardWindow();
        boardsPage.logout();
        WebElement explicitWait = (new WebDriverWait(driver(), 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".global-header-section-button")));
        Assert.assertTrue(driver().getCurrentUrl().equals("https://trello.com/logged-out"));
    }



}
