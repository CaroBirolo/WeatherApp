package com.example.weatherapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Inicializar la ListView
        ListView listViewCities = findViewById(R.id.listViewCities);

        // Lista de ciudades
        List<String> cities = Arrays.asList("Buenos Aires", "Córdoba", "La Plata", "Mendoza", "Salta");

        // Crear el adapter y establecerlo en la ListView
        MyAdapter adapter = new MyAdapter(this, cities);
        listViewCities.setAdapter(adapter);
    }
}
