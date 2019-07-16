package com.trello.api.services;

import com.trello.api.models.TrelloLabel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface LabelService {

    @GET("labels/{id}")
    Call<TrelloLabel> getLabel(@Path("id") String id);


    @PUT("labels/{id}")
    Call<TrelloLabel> updateLabel(@Path("id") String id, @Body TrelloLabel label);

    @POST("labels")
    Call<TrelloLabel> createLabel (@Query("name") String name, @Query("color") String color, @Query("idBoard") String idBoard);

    @DELETE("labels/{id}")
    Call<ResponseBody> deleteLabel(@Path("id") String id);

}
