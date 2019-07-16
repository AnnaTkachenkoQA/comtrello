package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.TrelloBoard;
import com.trello.api.models.TrelloLabel;
import com.trello.api.models.TrelloList;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class TryTrelloAPI {


    TrelloRestClient client = new TrelloRestClient();

    @Test
    public  void callIt() throws IOException, InterruptedException{

     /*Card API testing
        Card card = new Card();
        card.name="My New card";
        Card createdCard = client.cardsService.createCard("5d1243e36d5cc63a3a218058", card).execute().body();
        client.cardsService.deleteCard(createdCard.id);
      */

     /*Board API testing
        TrelloBoard board = client.boardsService.createBoard("TestAPIBoard").execute().body();
        String boardId= board.id;
        List<TrelloList> lists= client.boardsService.getLists(boardId).execute().body();
        System.out.println(lists);

        TrelloBoard boardNew= new TrelloBoard();
        boardNew.name="New Trello API board";
        client.boardsService.updateBoard(boardId, boardNew).execute().body();

        client.boardsService.deleteBoard(boardId).execute();
        */

     /*List API testing

        TrelloList createdList= client.listsService.createList("TestAPI List","5d1243dc36ad054e1df2a07e").execute().body();
        String listId= createdList.id;
        TrelloList getList= client.listsService.getList(listId).execute().body();
        System.out.println(getList.name);
        TrelloList newList= new TrelloList();
        newList.name= "Updated Listname";
        TrelloList updateList= client.listsService.updateList(listId, newList).execute().body();
        System.out.println(updateList.name);
      */


     /* Label Api testing


      */

        TrelloLabel createdLabel= client.labelService.createLabel("Label API", "black", "5d1243dc36ad054e1df2a07e").execute().body();
        String labelId= createdLabel.id;
        TrelloLabel getlabel= client.labelService.getLabel(labelId).execute().body();
        System.out.println(getlabel.color);
        TrelloLabel newLabel= new TrelloLabel();
        newLabel.name="violet";
        TrelloLabel updatedLabel = client.labelService.updateLabel(labelId, newLabel).execute().body();
        System.out.println(updatedLabel.name);
        client.labelService.deleteLabel(labelId).execute();

    }
}
