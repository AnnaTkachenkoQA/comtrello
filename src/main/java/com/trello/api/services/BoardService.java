package com.trello.api.services;


import com.trello.api.models.TrelloBoard;
import com.trello.api.models.TrelloList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BoardService {

    @GET("boards/{boardId}/lists")
    Call<List<TrelloList>> getLists(@Path("boardId") String boardId);

    @POST("boards")
    Call<TrelloBoard> createBoard(@Query("name") String name);


    @DELETE("boards/{id}")
    Call<ResponseBody> deleteBoard(@Path("id") String id);

    @PUT("boards/{id}")
    Call<TrelloBoard> updateBoard(@Path("id") String id, @Body TrelloBoard board);
}





