package com.trello.api;

import com.trello.api.interceptor.TrelloAuthInterceptor;
import com.trello.api.services.BoardService;
import com.trello.api.services.CardsService;
import com.trello.api.services.LabelService;
import com.trello.api.services.ListService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class TrelloRestClient {
    public static final String HOME_IO_BASE_URL="https://api.trello.com/1/";

    public BoardService boardsService;
    public ListService listsService;
    public CardsService cardsService;
    public LabelService labelService;

    public TrelloRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOME_IO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        boardsService = retrofit.create(BoardService.class);
        listsService = retrofit.create(ListService.class);
        cardsService=retrofit.create(CardsService.class);
        labelService=retrofit.create(LabelService.class);

}}
