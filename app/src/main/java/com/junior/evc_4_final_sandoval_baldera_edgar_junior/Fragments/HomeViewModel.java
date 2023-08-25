package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.BD.FruitRepository;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.FruitEntity;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.Fruits;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private FruitRepository repository;

    public LiveData<List<FruitEntity>> listLiveData = new MutableLiveData<List<FruitEntity>>();

    public HomeViewModel(@NonNull Application application){
        super(application);
        repository = new FruitRepository(application);
    }

    public void addFruit(Fruits fruit){
        FruitEntity fruitEntity = new FruitEntity();
        fruitEntity.setName(fruit.getName());
        fruitEntity.setImgUrl(fruit.getImgUrl());
        repository.addShow(fruitEntity);
    }

    public void getFruit(){
        listLiveData = repository.getAll();
    }

    public class HomeviewModelFactory implements ViewModelProvider.Factory {
        private final Application application;

        public HomeviewModelFactory(Application myapplication) {
            application = myapplication;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modeClass){
            return (T)new HomeViewModel(application);
        }

    }
}
