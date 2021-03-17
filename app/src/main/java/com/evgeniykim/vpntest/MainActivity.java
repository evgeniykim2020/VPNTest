package com.evgeniykim.vpntest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.evgeniykim.vpntest.UI.BounceInterpolator;
import com.evgeniykim.vpntest.UI.Countries;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Chronometer chronometer;
    private int i = 0;
    private ImageView flag;
    private TextView country;

//    private ImageView flag;
//    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.connection_button);
        chronometer = findViewById(R.id.simpleChronometer);
        flag = findViewById(R.id.flagPos);
        country = findViewById(R.id.countryName);

        getFlag();

    }



    public void onClick(View view) {

        if (i == 0) {
            final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
            BounceInterpolator interpolator = new BounceInterpolator(2, 10);
            animation.setInterpolator(interpolator);
            button.startAnimation(animation);

            chronometer.start();

            i++;

        } else if (i == 1) {

            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.stop();

            i = 0;
        }


    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.menu_down);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_down) {
            Intent intent = new Intent(MainActivity.this, Countries.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void getFlag() {
        try {
//            Bundle bundle = getIntent().getExtras();
            String position = getIntent().getExtras().get("position").toString();
            String flagImg = getIntent().getExtras().get("Flag").toString();
            String stateTxt = getIntent().getExtras().get("State").toString();
            Glide.with(getApplicationContext()).load(flagImg).into(flag);
            country.setText(stateTxt);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}