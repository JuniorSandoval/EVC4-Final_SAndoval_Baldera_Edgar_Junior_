package com.junior.evc_4_final_sandoval_baldera_edgar_junior.BD;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.FruitEntity;

import java.util.List;

@Dao
public interface FruitDAO {

    @Insert
    public void addFruit(FruitEntity show);

    @Query("SELECT * FROM fruits WHERE name LIKE :name LIMIT 1")
    public FruitEntity getFruitByName(String name);

    @Query("SELECT * FROM fruits")
    public LiveData<List<FruitEntity>> getAll();

    @Delete
    public void deleteFruit(FruitEntity show);

}
