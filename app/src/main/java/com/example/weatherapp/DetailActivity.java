package com.example.weatherapp;

import static android.os.Build.VERSION_CODES.R;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView; // Importa TextView
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.Toast;

import javax.xml.transform.Result;

import retrofit2.call;
import retrofit2.Callback;
import retrofit2.Response;



public class DetailActivity extends AppCompatActivity {

    TextView nameOfCity, tempActual, tempMax, tempMin, description;

    float latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        Intent miIntent = getIntent();
        latitud = miIntent.getFloatExtra("lat",  0.0F);
        longitud = miIntent.getFloatExtra("lon",  0.0F);

        nameOfCity = findViewById(R.id.currentTemperatureTextView);
        tempActual = findViewById(R.id.currentTemperatureTextView);
        tempMax = findViewById(R.id.maxTemperatureTextView);
        tempMin = findViewById(R.id.minTemperatureTextView);
        description = findViewById(R.id.weatherDescriptionTextView);


        // Configurar padding para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Obtener el nombre de la ciudad desde el Intent
        String cityName = getIntent().getStringExtra("cityName");

        // Configurar el TextView para mostrar el nombre de la ciudad
        TextView cityNameTextView = findViewById(R.id.cityNameTextView);
        cityNameTextView.setText(cityName);

        // Configurar el botón de volver
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish()); 
    }

    private void getCurrentWeather(){
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getCurrentWeather(latitud, longitud, API.TOKEN, API.UNITS, API.LANG);
        call.enqueue(new Call.Callback<Results>(){
            @Override
            public void onResponse(@NonNull Call<Results> call, @NonNull Response<Results> Response) {
                if (Response.isSuccessful()&& response.body() != null) {
                    Results results = Response.body();
                    nameOfCity.setText(results.name);
                    tempActual.setText(String.valueOf(results.main.temp.shortValue()));
                    tempMax.setText(String.valueOf(results.main.temp_max.shortValue()));
                    tempMin.setText(String.valueOf(results.main.temp_min.shortValue()));
                    Results.Weather weather = results.weather.get(0);
                    description.setText(weather.description);
                }else {
                    Toast.makeText(DetailActivity.this, "Fallo de conexion", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<results> call, @NonNull Throwable t){

            }
        });
    }
}
