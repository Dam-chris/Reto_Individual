package com.example.retoindividual.ui.galeria;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retoindividual.R;
import com.example.retoindividual.RecyclerData;
import com.example.retoindividual.adaptadores.GaleriaFragmentosAdaptador;
import com.example.retoindividual.adaptadores.RecyclerViewAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FragmentGaleria extends Fragment
{
    public static FragmentGaleria newInstance()
    {
        return new FragmentGaleria();
    }
    private TabLayout tabs = null;
    private ViewPager2 pager2 = null;
    private GaleriaFragmentosAdaptador adaptador;
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_galeria_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        tabs = view.findViewById(R.id.tlGaleria);
        pager2 = view.findViewById(R.id.vpGalerias);
        FragmentManager fm = requireActivity().getSupportFragmentManager();
        adaptador = new GaleriaFragmentosAdaptador(fm,getLifecycle());
        pager2.setAdapter(adaptador);

        tabs.addTab(tabs.newTab().setText("Exterior"));
        tabs.addTab(tabs.newTab().setText("Interior"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()
        {
            @Override
            public void onPageSelected(int position)
            {
               tabs.selectTab(tabs.getTabAt(position));
            }
        });
    }
}