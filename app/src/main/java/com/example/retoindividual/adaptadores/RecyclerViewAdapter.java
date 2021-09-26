package com.example.retoindividual.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retoindividual.R;
import com.example.retoindividual.recicladores.RecyclerData;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>
{

    private ArrayList<RecyclerData> courseDataArrayList;
    private Context mcontext;

    public RecyclerViewAdapter(ArrayList<RecyclerData> recyclerDataArrayList, Context mcontext)
    {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {

        private TextView courseTV;
        private ImageView courseIV;

        public RecyclerViewHolder(@NonNull View itemView)
        {
            super(itemView);
            courseTV = itemView.findViewById(R.id.tvNombres);
            courseIV = itemView.findViewById(R.id.ivImagenes);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_per, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position)
    {
        // Set the data to textview and imageview.
        RecyclerData recyclerData = courseDataArrayList.get(position);
        holder.courseTV.setText(recyclerData.getTitle());
        //holder.courseIV.setImageResource(recyclerData.getImgid());
        //añadir glide aqui
        Glide.with(mcontext).load(recyclerData.getImgid()).centerCrop().into(holder.courseIV);
    }

    @Override
    public int getItemCount()
    {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

}
