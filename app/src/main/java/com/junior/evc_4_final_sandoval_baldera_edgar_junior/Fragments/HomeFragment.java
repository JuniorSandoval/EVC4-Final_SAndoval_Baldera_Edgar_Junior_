package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Data.retrofit.RetrofitHelper;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Data.retrofit.response.FruitsResponse;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.Fruits;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.R;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.databinding.FragmentHomeBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(HomeViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RetrofitHelper.getService().getFruits().enqueue(new Callback<FruitsResponse>() {
            @Override
            public void onResponse(Call<FruitsResponse> call, Response<FruitsResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    fruitsCa(response.body().getFruitsList());
                }
            }

            @Override
            public void onFailure(Call<FruitsResponse> call, Throwable t) {

            }
        });
        homeViewModel.listLiveData.observe(requireActivity(), fruitList ->{
            for(int i = 0;i<fruitList.size();i++){
                Log.d("Frutas",fruitList.get(i).getName());
            }
        });
        homeViewModel.getFruit();
    }

    private void fruitsCa(List<Fruits> fruitsList){
        RVFruitsAdapter adapter = new RVFruitsAdapter(fruitsList, fruit -> {
            homeViewModel.addFruit(fruit);
        });
        binding.rvFruit.setAdapter(adapter);

    }

}