package org.example.repository;

import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.repository.entity.MealBean;

import java.io.IOException;

public class FoodRepository {
    public static String sendGet(String url) throws Exception{
        System.out.println("url: "+url);
        OkHttpClient client = new OkHttpClient();

        //initialize request
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("unexpected code " + response);
            } else {
                return response.body().string();
            }
        }

    }

    
}
