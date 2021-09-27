package com.example.retoindividual;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;


public class DialogGaleria extends DialogFragment
{
    private ImageView ivGaleria = null;
    private Context context = null;
    public DialogGaleria()
    {
        super();
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context =context;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Imagen");
        return dialog;
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog)
    {
        super.onCancel(dialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View vista = inflater.inflate(R.layout.dialog_galeria, container, false);
        ivGaleria = vista.findViewById(R.id.ivDialog);

        //obtener los datos de la imagen y el texto en el bundle
        Bundle extras = getArguments();
        String img = null;
        if (extras != null)
        {
            img = extras.getString("imagen");
        }
        //Log.d("imagen", "onViewCreated: "+img);
        Glide.with(context).load(img).centerCrop().into(ivGaleria);

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }
}
