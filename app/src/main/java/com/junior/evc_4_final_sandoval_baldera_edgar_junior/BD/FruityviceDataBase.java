package com.junior.evc_4_final_sandoval_baldera_edgar_junior.BD;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.FruitEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FruitEntity.class},version = 1)
public abstract class FruityviceDataBase  extends RoomDatabase {

    public abstract FruitDAO fruitDao();

    public static volatile FruityviceDataBase db;

    public static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static FruityviceDataBase getInstance(Context context){

        if(db == null){
            synchronized (FruityviceDataBase.class) {
                if(db == null) {
                    db = Room.databaseBuilder(context.getApplicationContext(), FruityviceDataBase.class, "fruits-database").build();
                }
            }
        }
        return db;
    }

}
