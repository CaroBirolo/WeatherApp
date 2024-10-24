package com.example.weatherapp;

import android.content.Intent; // Asegúrate de importar esta clase
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        Button currentForecastButton = findViewById(R.id.currentForecastButton);
        Button citiesListButton = findViewById(R.id.citiesListButton);

        // Establecer el texto desde la clase Constants
        welcomeText.setText(Constants.WELCOME_TEXT);
        currentForecastButton.setText(Constants.CURRENT_FORECAST_TEXT);
        citiesListButton.setText(Constants.CITIES_LIST_TEXT);

        // Agregar el OnClickListener al botón "Listado de ciudades"
        citiesListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
