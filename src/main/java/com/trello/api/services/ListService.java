package com.trello.api.services;



import com.trello.api.models.TrelloBoard;
import com.trello.api.models.TrelloList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


public interface ListService {

    @GET("lists/{listId}")
    Call<TrelloList> getList(@Path("listId") String listId);//подстановка параметра в УРЛу

    @POST("lists")
    Call<TrelloList> createList(@Query("name") String name, @Query("idBoard") String boardId); //параметры


    @PUT("lists/{id}")
    Call<TrelloList> updateList(@Path("id") String id, @Body TrelloList list);

    @DELETE("lists/{id}")
    Call<ResponseBody> deleteList(@Path("id") String id); //у List нет метода Delete, но если бы был, то выглядел бы так))

}
