package com.example.pruebamarketmix.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.apiService.ApiAsteroids;

public class MainActivity extends AppCompatActivity {

    private Button btnP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.btnP = (Button)findViewById(R.id.buttonP);
        this.btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("test","Prueba funcionamiento");
                ApiAsteroids apiAsteroids = new ApiAsteroids();
                apiAsteroids.getApiAsteroids();

            }
        });
    }
}
