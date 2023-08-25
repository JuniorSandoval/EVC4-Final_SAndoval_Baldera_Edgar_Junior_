package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model.Fruits;
import com.junior.evc_4_final_sandoval_baldera_edgar_junior.databinding.ItemFruitBinding;

import java.util.List;

public class RVFruitsAdapter extends RecyclerView.Adapter<RVFruitsAdapter.FruitsViewHolder> {

    private List<Fruits> fruity;
    private FavoriteClick favoriteClick;

    public RVFruitsAdapter(List<Fruits> fruits, FavoriteClick favoriteClick) {
        this.fruity = fruits;
        this.favoriteClick = favoriteClick;

    }

    @NonNull
    @Override
    public FruitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFruitBinding binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit, parent, false);
        return new FruitsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsViewHolder holder, int position) {
        holder.bind(fruity.get(position));
    }

    @Override
    public int getItemCount() {
        return fruity.size();
    }

    public class FruitsViewHolder extends RecyclerView.ViewHolder{

        private ItemFruitBinding binding;
        public FruitsViewHolder(@NonNull ItemFruitBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Fruits fruit) {
            binding.txtNombreFruta.setText(fruit.getName());
            binding.btnFavorito.setOnClickListener(v ->{
                favoriteClick.onClick(fruit);
            });
            Glide.with(itemView.getContext()).load(fruit.getImgUrl()).into(binding.imgFruit);
        }
    }
    public interface FavoriteClick{
        public void onClick(Fruits fruit);
    }

}
