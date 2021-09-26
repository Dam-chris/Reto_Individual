package com.example.retoindividual.ui.inicio;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentoInicioViewModel extends ViewModel
{
    // TODO: Implement the ViewModel
    private MutableLiveData<List<String>> cursos = null;
    private List<String> listaCursos = new ArrayList<>();

    public FragmentoInicioViewModel()
    {
        cursos = new MutableLiveData<List<String>>();
        llenarCursos();
        cursos.postValue(listaCursos);
    }

    public MutableLiveData<List<String>> getCursos()
    {
        return cursos;
    }

    private void llenarCursos()
    {
        listaCursos.add("DAM1");
        listaCursos.add("DAM2");
        listaCursos.add("ASIR1");
        listaCursos.add("ASIR2");
        listaCursos.add("SMR1");
        listaCursos.add("SMR2");
        listaCursos.add("GA1");
        listaCursos.add("GA2");
    }
}