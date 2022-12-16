package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Service
        //startService(new Intent(this, DegreesService.class));
        setContentView(R.layout.activity_main);
    }

    public void Button_length(View v) {
        Intent intent = new Intent(this, LengthActivity.class);
        startActivity(intent);
    }

    public void Button_weight(View v) {
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity(intent);
    }

    public void Button_temperature(View v) {
        Intent intent = new Intent(this, TemperatureActivity.class);
        startActivity(intent);
    }

    public void Button (View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button_frag:
                fragment = new BlankFragmentDegrees();
                break;
                /*
            case R.id.button3:
                fragment = new Fragment();
                break;
            case R.id.button4:
                fragment = new BlankFragmentDegrees();
                break;
                 */
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmen, fragment);
        ft.commit();
    }
}