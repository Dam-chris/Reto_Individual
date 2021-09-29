package com.example.retoindividual.ui.galeria;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.retoindividual.DialogGaleria;
import com.example.retoindividual.R;
import com.example.retoindividual.recicladores.RecyclerData;
import com.example.retoindividual.recicladores.RecyclerItemClickListener;
import com.example.retoindividual.recicladores.RecyclerViewAdapter;

import java.util.ArrayList;

public class FragmentEntorno extends Fragment
{

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    private Context context = null;

    // TODO: Rename and change types and number of parameters
    public static FragmentEntorno newInstance()
    {
        FragmentEntorno fragment = new FragmentEntorno();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvEntorno);

        // created new array list..
        recyclerDataArrayList = new ArrayList<>();

        // added data to array list
        for (int i = 0; i < 6; i++)
        {
            recyclerDataArrayList.add(new RecyclerData("Entorno " + (i + 1), "https://i.pinimg.com/originals/26/85/0d/26850d219311b90bea6faec98cfae29f.jpg"));
        }

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerDataArrayList, getContext());

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entorno, container, false);
    }
}