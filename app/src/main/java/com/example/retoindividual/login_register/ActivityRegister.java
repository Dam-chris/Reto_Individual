package com.example.retoindividual.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retoindividual.NavigationDrawerActivity;
import com.example.retoindividual.R;
import com.example.retoindividual.bbdd.AppDatabase;
import com.example.retoindividual.bbdd.AppExecutors;

public class ActivityRegister extends AppCompatActivity
{
    private Button btnCancel, btnRegister;
    private EditText etUser = null;
    private EditText etPassword = null;
    private EditText etRePassword = null;

    private Intent intent = null;
    private AppDatabase mDb = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDb = AppDatabase.getInstance(getApplicationContext());
        intent = getIntent();

        Toast.makeText(getApplicationContext(), "Base de datos preparada", Toast.LENGTH_SHORT).show();

        btnCancel = findViewById(R.id.btnCancelReg);
        btnRegister = findViewById(R.id.btnRegistroReg);
        etUser = findViewById(R.id.etUserReg);
        etPassword = findViewById(R.id.etPassReg);
        etRePassword = findViewById(R.id.etRePassReg);

        btnCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String user = etUser.getText().toString();
                String pass = etPassword.getText().toString();
                guardar(user, pass);
                Toast.makeText(getApplicationContext(), "Registrado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });
    }
    public void guardar(String user, String pass)
    {
        final Usuario usuario = new Usuario(user, pass);
        AppExecutors.getInstance().getDiskIP().execute(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Log.d("dam", usuario.getUsuario() + " " + usuario.getPassword());
                    mDb.usuariosDao().insertUsuario(usuario);
                } catch (Exception e)
                {
                    Log.d("dam", e.getMessage());
                }
            }
        });
    }
}