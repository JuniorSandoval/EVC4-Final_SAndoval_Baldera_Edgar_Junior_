package com.junior.evc_4_final_sandoval_baldera_edgar_junior.BD;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.FruitEntity;

import java.util.List;

public class FruitRepository {

    private FruitDAO dao;
    private FruityviceDataBase db;

    public FruitRepository(Application application) {

        db = FruityviceDataBase.getInstance(application);
        dao = db.fruitDao();

    }

    public void addShow(FruitEntity showEntity){
        FruityviceDataBase.dataBaseWriteExecutor.execute(()->
                dao.addFruit(showEntity));
    }
    public LiveData<List<FruitEntity>> getAll(){
        return dao.getAll();
    }

}
