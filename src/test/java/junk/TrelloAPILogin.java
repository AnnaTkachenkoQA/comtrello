package junk;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.UI.core.BrowserFactory;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TrelloAPILogin  extends BrowserFactory{

    CookieStorage cookieStorage = new CookieStorage();
    OkHttpClient client = new OkHttpClient.Builder().cookieJar(cookieStorage).build();
    Gson gson = new Gson();

    @Test
    public void loginByApi() throws IOException, InterruptedException {

        client.newCall(new Request.Builder().url("https://trello.com").build());

        FormBody formData = new FormBody.Builder()
                .add("method", "password")
                .add("factors[user]", "nanccy95@gmail.com")
                .add("factors[password]", "anna5624787")
                .build();
        Request request = new Request.Builder().url("https://trello.com/1/authentication").post(formData).build();
        String response = client.newCall(request).execute().body().string();
        System.out.println("Response: " +response);
        Map<String, String> map = gson.fromJson(response, new TypeToken<Map<String, String>>(){}.getType());
        String code= map.get("code");
        System.out.println("Code : " +code);


        String dsc = cookieStorage.cookies.stream().filter(cookie -> cookie.name().equals("dsc")).findFirst().get().value();
        FormBody formData2 = new FormBody.Builder()
                .add("authentication", code)
                .add("dsc", dsc)
                .build();
        Request requestSession= new Request.Builder().url("https://trello.com/1/authentication").post(formData2).build();
        response = client.newCall(requestSession).execute().body().string();
        System.out.println(response);

        driver().get("https://trello.com");
        for(Cookie cookie: cookieStorage.cookies) {
            org.openqa.selenium.Cookie seleniumCookie= new org.openqa.selenium.Cookie(cookie.name(), cookie.value());
            driver().manage().addCookie(seleniumCookie);
        }

        driver().navigate().refresh();
        Thread.sleep(10000);


    }
}
