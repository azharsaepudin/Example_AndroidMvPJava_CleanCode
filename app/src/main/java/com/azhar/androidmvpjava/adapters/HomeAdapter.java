package com.azhar.androidmvpjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.androidmvpjava.R;
import com.azhar.androidmvpjava.model.CityListData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;


import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private final OnItemClickListener listener;
    private List<CityListData> data;
    private Context context;


    public HomeAdapter(Context context, List<CityListData> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.click(data.get(position),  listener);
    holder.tvCity.setText(data.get(position).getNAMA());
    holder.tvDesc.setText(data.get(position).getNPM());

//    String images = data.get(position).getBackground();
//
//    Glide.with(context)
//            .load(images)
//            .into(holder.background);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {
        void onClick(CityListData Item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCity, tvDesc;
        ImageView background;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCity = itemView.findViewById(R.id.city);
            tvDesc = itemView.findViewById(R.id.hotel);
            //background = itemView.findViewById(R.id.image);

        }

        public void click(final CityListData cityListData, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }


    }


}
