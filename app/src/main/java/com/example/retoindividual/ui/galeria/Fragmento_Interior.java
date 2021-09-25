package com.example.retoindividual.ui.galeria;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retoindividual.R;
import com.example.retoindividual.RecyclerData;
import com.example.retoindividual.adaptadores.RecyclerViewAdapter;

import java.util.ArrayList;


public class Fragmento_Interior extends Fragment
{

    // TODO: Rename and change types and number of parameters
    public static Fragmento_Interior newInstance()
    {
        return new Fragmento_Interior();
    }
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_fragmento__interior, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvInterior);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        for (int i = 0; i < 10 ; i++)
        {
            recyclerDataArrayList.add(new RecyclerData("Interior "+ (i+1),"https://almi.eus/wp-content/uploads/2018/06/logo-Almi.jpg"));
        }

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerDataArrayList,getContext());

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}