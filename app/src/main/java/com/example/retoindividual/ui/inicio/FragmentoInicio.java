package com.example.retoindividual.ui.inicio;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retoindividual.R;

import java.util.List;

public class FragmentoInicio extends Fragment
{

    private FragmentoInicioViewModel mViewModel;
    private ListView lvCursos = null;

    public static FragmentoInicio newInstance()
    {
        return new FragmentoInicio();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //animcaion
        Animation animFadeOut = AnimationUtils.loadAnimation(getContext(),R.anim.fade_out);
        container.startAnimation(animFadeOut);

        return inflater.inflate(R.layout.fragmento_inicio_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(FragmentoInicioViewModel.class);
        // TODO: Use the ViewModel
        lvCursos = getView().findViewById(R.id.lvCursos);
        TextView tvCursos = getView().findViewById(R.id.tvTituloCursos);
        tvCursos.setText("Lista De Cursos:");

        mViewModel.getCursos().observe(getViewLifecycleOwner(), new Observer<List<String>>()
        {
            @Override
            public void onChanged(List<String> cursos)
            {
                CursosAdaptador adapter = new CursosAdaptador(getContext(), 0, cursos);
                lvCursos.setAdapter(adapter);
            }
        });
    }


}