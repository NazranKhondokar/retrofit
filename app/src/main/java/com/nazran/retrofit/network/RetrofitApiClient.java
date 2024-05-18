package com.nazran.retrofit.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {
    private static final String BASE_URL = "http://127.0.0.1:1991/api/v1/";
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitApiClient() {
    } // So that nobody can create an object with constructor

    public static Retrofit getClient() {
        if (retrofit == null) {
            synchronized (RetrofitApiClient.class) { //thread safe Singleton implementation

                OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .build();


                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(okHttpClient)
                            .build();
                }
            }
        }

        return retrofit;
    }
}
