package com.example.retoindividual.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.retoindividual.NavigationDrawerActivity;
import com.example.retoindividual.R;
import com.example.retoindividual.bbdd.AppDatabase;
import com.example.retoindividual.bbdd.AppExecutors;

public class DialogLogin extends DialogFragment
{
    private EditText etUsuario = null;
    private EditText etPassword = null;
    private Button btnAceptar = null;
    private Button btnRegistro = null;
    private AppDatabase mdb = null;
    private Context context = null;

    public DialogLogin()
    {
        super();
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Login");
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
        View vista = inflater.inflate(R.layout.login, container, false);

        etUsuario = vista.findViewById(R.id.etUser);
        etPassword = vista.findViewById(R.id.etPass);
        btnAceptar = vista.findViewById(R.id.btnAccess);
        btnRegistro = vista.findViewById(R.id.btnRegistro);

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        btnRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), ActivityRegister.class);
                startActivity(intent);
            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mdb = AppDatabase.getInstance(context);

                String user = etUsuario.getText().toString();
                String password = etPassword.getText().toString();
                AppExecutors.getInstance().getDiskIP().execute(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Usuario usu = mdb.usuariosDao().loadUsuarioByNamePass(user, password);

                        if(usu != null && !user.isEmpty())
                        {
                            dismiss();
                        } else
                        {
                            etUsuario.setText("Anguila Explosiva");
                            etPassword.setText("");
                        }
                    }
                });
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
