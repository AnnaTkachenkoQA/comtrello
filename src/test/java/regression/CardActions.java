package regression;

import com.trello.UI.core.BrowserFactory;
import com.trello.UI.core.Constants;
import com.trello.UI.pages.BoardsPage;
import com.trello.UI.pages.CardPage;
import com.trello.UI.pages.LoginPage;
import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.services.CardsService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;


public class CardActions  extends BrowserFactory{

    public TrelloRestClient client=new TrelloRestClient();

   public  LoginPage loginPage= new LoginPage();
    public BoardsPage boardsPage=new BoardsPage();
    public CardPage cardPage=new CardPage();



    Card card=new Card("Test_Card"+new Date().getTime());

    @BeforeTest
    public void prepareData() throws IOException {
        card= client.cardsService.createCard("5d1243e36d5cc63a3a218058", card).execute().body();
    }


    @AfterTest
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }



    @Test
    public void login(){
        loginPage.open();
        loginPage.login("nanccy95@gmail.com", "anna5624787");
    }


    @Test (dependsOnMethods = "login")
    public void openCard(){
        boardsPage.openBoard("WCtONhWe");
        String cardUrl = card.url.substring(21, 29);
        cardPage.open(cardUrl);
        Assert.assertTrue(driver().getCurrentUrl().equals(card.url));
    }


    @Test (dependsOnMethods="openCard")
    public void addMember() throws IOException {
        cardPage.addMembers("5ce41a4d26d82e7756b5e9e0");
        card = client.cardsService.getCard(card.id).execute().body();
        Assert.assertTrue(card.idMembers.length==1);
    }


    @Test (dependsOnMethods = "addMember")
    public void deleteMember() throws IOException {
        cardPage.addOneMoreMember("5ce41a4d26d82e7756b5e9e0");
        card= client.cardsService.getCard(card.id).execute().body();
        Assert.assertTrue(card.idMembers.length==0);
    }


    @Test(dependsOnMethods = "openCard")
    public void addLabel() throws IOException {
        cardPage.addLabels("5d1243dcaf988c41f2518ff1");
        card= client.cardsService.getCard(card.id).execute().body();
      Assert.assertTrue(card.idLabels.length==1);
    }

    @Test (dependsOnMethods = "addLabel")
    public void addOneMoreLabel() throws IOException {
        cardPage.addOneMoreLabel("5d1243dcaf988c41f2518ff2");
        card= client.cardsService.getCard(card.id).execute().body();
        Assert.assertTrue(card.idLabels.length==2);
    }

    @Test (dependsOnMethods = "openCard")
    public void addChecklist() throws IOException {
        cardPage.addChecklist("Test checklist");
        card= client.cardsService.getCard(card.id).execute().body();

        //await().atMost(10, TimeUnit.SECONDS).ignoreExceptions().until();
      // Assert.assertTrue(card.idChecklists.length>0);
    }

    @Test (dependsOnMethods = "addChecklist")
    public void addChecklistItem() throws IOException {
        cardPage.addItemToChecklist("testItem1");
        card= client.cardsService.getCard(card.id).execute().body();
      // Assert.assertTrue(card.badges.checkItems==1);
    }

    @Test (dependsOnMethods = "addChecklist")
    public void deleteChecklist() throws IOException {
        cardPage.deleteChecklist("");
        card= client.cardsService.getCard(card.id).execute().body();
        Assert.assertTrue(card.idChecklists.length==0);
    }

    @Test (dependsOnMethods = "openCard")
    public void addDueDate () throws IOException {
        cardPage.addDueDate("06/07/2019");
        card= client.cardsService.getCard(card.id).execute().body();
       // Assert.assertTrue(card.due=="2019-07-06T09:00:00.000Z");
    }


    @Test (dependsOnMethods = "openCard")
    public void addAttachment() throws IOException {
        cardPage.addAttachment("https://docs.google.com/spreadsheets/d/1uKXfZ0wdeE4l413Cvv6ibog3BhBTSwBlGZArDDTRkV4/edit?ts=5cbed453#gid=1541541177");
        card= client.cardsService.getCard(card.id).execute().body();
       // Assert.assertTrue(card.badges.attachments==1);
    }

    @Test (dependsOnMethods = "openCard")
    public void moveCard() throws IOException {
        //cardPage.move("Testlist2");
       // card= client.cardsService.getCard(card.id).execute().body();

    }

    @Test
    public void closeCard() {

    }







}
