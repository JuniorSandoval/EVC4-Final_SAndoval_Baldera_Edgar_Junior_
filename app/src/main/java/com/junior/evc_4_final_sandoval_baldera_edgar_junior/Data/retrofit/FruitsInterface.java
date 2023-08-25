package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Data.retrofit;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Data.retrofit.response.FruitsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FruitsInterface {

    @GET("6ffa946c-3b0f-46fb-9e61-a3e5061af73d")
    Call<FruitsResponse> getFruits();

}
