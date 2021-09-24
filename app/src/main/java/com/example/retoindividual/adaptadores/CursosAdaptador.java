package com.example.retoindividual.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.retoindividual.R;

import java.util.List;

public class CursosAdaptador extends ArrayAdapter
{
    private List<String> arrayList = null;
    private Context context = null;
    public CursosAdaptador(@NonNull Context context, int resource, @NonNull List<String> arrayList)
    {
        super(context, resource, arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount()
    {
        return arrayList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position)
    {
        return arrayList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater =LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.lista_cursos_per, parent, false);
        TextView tvCursos = vista.findViewById(R.id.tvCursos);

        tvCursos.setText(arrayList.get(position));

        return vista;
    }
}
