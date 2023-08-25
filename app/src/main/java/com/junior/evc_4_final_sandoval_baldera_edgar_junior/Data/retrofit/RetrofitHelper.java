package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {

    public static Retrofit instance;
    public static FruitsInterface service;

    public RetrofitHelper() {
    }

    public static Retrofit getInstance() {
        if(instance == null){
            //https://run.mocky.io/v3/6ffa946c-3b0f-46fb-9e61-a3e5061af73d
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLogginBuilder().build())
                    .build();
            instance = retrofit;
        }
        return instance;
    }

    public static OkHttpClient.Builder getLogginBuilder(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;
    }

    public static FruitsInterface getService(){
        if (service == null){
            service = getInstance().create(FruitsInterface.class);
        }
        return service;
    }

}
