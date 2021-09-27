package com.example.retoindividual.ui.galeria;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.retoindividual.DialogGaleria;
import com.example.retoindividual.R;
import com.example.retoindividual.recicladores.RecyclerData;
import com.example.retoindividual.recicladores.RecyclerItemClickListener;
import com.example.retoindividual.recicladores.RecyclerViewAdapter;

import java.util.ArrayList;

public class Fragmento_Exterior extends Fragment
{


    // TODO: Rename and change types and number of parameters
    public static Fragmento_Exterior newInstance()
    {
        return new Fragmento_Exterior();
    }

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    private  ImageView ivGaleria = null;
    private Context context;


    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_fragmento__exterior, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvExterior);

        // created new array list..
        recyclerDataArrayList = new ArrayList<>();

        // added data to array list
        for (int i = 0; i < 20; i++)
        {
            recyclerDataArrayList.add(new RecyclerData("Exterior " + (i + 1), "https://almi.eus/wp-content/uploads/2018/06/logo-Almi.jpg"));
        }

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerDataArrayList, context);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //on item click listener del reciclador
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(View view, int position)
                    {
                        //Log.d("galeria", "onItemClick: estoy pinchando en el elemento: " + recyclerDataArrayList.get(position).getTitulo());
                        Toast.makeText(context, recyclerDataArrayList.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("imagen",recyclerDataArrayList.get(position).getImg());
                        DialogGaleria dialogGaleria = new DialogGaleria();
                        dialogGaleria.show(requireActivity().getSupportFragmentManager(), "imagen");
                        dialogGaleria.setArguments(bundle);
                    }

                    @Override
                    public void onLongItemClick(View view, int position)
                    {

                    }
                })
        );
    }

}