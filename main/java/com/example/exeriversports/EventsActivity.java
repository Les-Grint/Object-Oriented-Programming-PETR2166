package com.example.exeriversports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EventsActivity extends AppCompatActivity {

    ImageButton Football, Rugby, Cricket, Tennis;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Football = (ImageButton) findViewById(R.id.imageButtonF_ball);
        Rugby= (ImageButton) findViewById(R.id.imageButtonR_ball);
        Cricket= (ImageButton) findViewById(R.id.imageButtonC_bat);
        Tennis= (ImageButton) findViewById(R.id.imageButtonT_racket);

        Football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventsActivity.this, "Football", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), F_B_TicketsActivity.class);
                startActivity(intent);
            }
        });

        Rugby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventsActivity.this, "Rugby", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Rugby_TicketsActivity.class);
                startActivity(intent);
            }
        });

        Cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventsActivity.this, "Cricket", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Crick_TicketsActivity.class);
                startActivity(intent);
            }
        });

        Tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EventsActivity.this, "Tennis", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Ten_TicketsActivity.class);
                startActivity(intent);
            }
        });










        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.Events);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Events:
                        return true;

                    case R.id.About:
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}