package com.example.retoindividual.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.retoindividual.ui.galeria.FragmentGaleria;
import com.example.retoindividual.ui.galeria.Fragmento_Exterior;
import com.example.retoindividual.ui.galeria.Fragmento_Interior;

public class GaleriaFragmentosAdaptador extends FragmentStateAdapter
{
    public GaleriaFragmentosAdaptador(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle)
    {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        if (position == 1)
        {
            return new Fragmento_Interior();
        }
        return new Fragmento_Exterior();
    }

    @Override
    public int getItemCount()
    {
        return 2;
    }
}
