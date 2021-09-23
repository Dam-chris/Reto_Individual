package com.example.retoindividual;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.GridView;
import android.widget.ListView;

import com.example.retoindividual.adaptadores.CursosAdaptador;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retoindividual.databinding.ActivityNavigationDrawerBinding;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerActivity extends AppCompatActivity
{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationDrawerBinding binding;
    private List<String> arrayCursos = new ArrayList<String>();
    private ListView lvCursos = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_Inicio, R.id.nav_Galeria, R.id.nav_Mapa)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        llenarCursos();

        lvCursos = findViewById(R.id.lvCursos);
        CursosAdaptador adapter = new CursosAdaptador(this, 0, arrayCursos);
        lvCursos.setAdapter(adapter);

    }

    private void llenarCursos()
    {
        arrayCursos.add("Cursos:");
        arrayCursos.add("DAM1");
        arrayCursos.add("DAM2");
        arrayCursos.add("ASIR1");
        arrayCursos.add("ASIR2");
        arrayCursos.add("SMR1");
        arrayCursos.add("SMR2");
        arrayCursos.add("GA1");
        arrayCursos.add("GA2");
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}