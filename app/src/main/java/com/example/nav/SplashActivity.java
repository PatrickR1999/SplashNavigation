package com.example.nav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){ // Ei tea
            @Override
            public void run(){ // Meetod run
                Intent mainIntent = new Intent(SplashActivity.this,
                        MainActivity.class); // Muudab SplashAcitvity ekraani MainAcivity vastu
                startActivity(mainIntent); // Alustatakse ekraani muutmist
                finish(); // Lõpetab
            }
        },SPLASH_TIME_OUT); // SPLASH_TIME_OUT läheb tööle
    }
}
