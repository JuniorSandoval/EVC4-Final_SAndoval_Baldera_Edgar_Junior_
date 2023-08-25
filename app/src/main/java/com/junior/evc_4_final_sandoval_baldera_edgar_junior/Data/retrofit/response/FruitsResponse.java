package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Data.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.Fruits;

import java.util.List;

public class FruitsResponse {

    @SerializedName("fruits")
    public List<Fruits> fruitsList;

    public List<Fruits> getFruitsList(){

        return fruitsList;

    }

    public void setFruitsList(List<Fruits> fruitsList){
        this.fruitsList=fruitsList;
    }

}
