package com.example.exeriversports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class F_B_TicketsActivity extends AppCompatActivity {

    // This declares variables for the buttons.
    Button Adult_Ticket_Btn, Child_Ticket_Btn, Member_Ticket_Btn, Front_Row_Btn, Middle_Row_Btn, Back_Row_Btn, Meal_Deal_Btn, VIP_Btn, Tour_Btn, Buy_Btn;
    Ticket New_Ticket, Custom_Ticket;

    Boolean A_T, C_T, M_T;
    String click;


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_tickets);

        Adult_Ticket_Btn = (Button) findViewById(R.id.btn_adult_ticket);
        Child_Ticket_Btn = (Button) findViewById(R.id.btn_child_ticket);
        Member_Ticket_Btn = (Button) findViewById(R.id.btn_member_ticket);
        Front_Row_Btn = (Button) findViewById(R.id.btn_front_row);
        Middle_Row_Btn = (Button) findViewById(R.id.btn_middle_row);
        Back_Row_Btn = (Button) findViewById(R.id.btn_back_row);
        Meal_Deal_Btn = (Button) findViewById(R.id.btn_meal_deal);
        VIP_Btn = (Button) findViewById(R.id.btn_vip);
        Tour_Btn = (Button) findViewById(R.id.btn_tour);
        Buy_Btn = (Button) findViewById(R.id.btn_purchase);





        // This is the listener for the 'Adult_Ticket_Btn' button
        Adult_Ticket_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Child_Ticket_Btn.setEnabled(true);
                Member_Ticket_Btn.setEnabled(true);
                Adult_Ticket_Btn.setEnabled(false);
                A_T = true;
                C_T = false;
                M_T = false;
                new Adult_Ticket();
                Toast.makeText(F_B_TicketsActivity.this, "Adult Ticket Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // This is the listener for the 'Child_Ticket_Btn' button
        Child_Ticket_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adult_Ticket_Btn.setEnabled(true);
                Member_Ticket_Btn.setEnabled(true);
                Child_Ticket_Btn.setEnabled(false);
                A_T = false;
                C_T = true;
                M_T = false;
                new Child_Ticket();
                Toast.makeText(F_B_TicketsActivity.this, "Child Ticket Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // This is the listener for the 'Member_Ticket_Btn' button
        Member_Ticket_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adult_Ticket_Btn.setEnabled(true);
                Child_Ticket_Btn.setEnabled(true);
                Member_Ticket_Btn.setEnabled(false);
                A_T = false;
                C_T = false;
                M_T = true;
                new Member_Ticket();
                Toast.makeText(F_B_TicketsActivity.this, "Member Ticket Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // This is the listener for the 'Front_Row_Btn' button
        Front_Row_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Middle_Row_Btn.setEnabled(true);
                Back_Row_Btn.setEnabled(true);
                Front_Row_Btn.setEnabled(false);
                new Front_Row_Section(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Front Row Section Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'Middle_Row_Btn' button
        Middle_Row_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Front_Row_Btn.setEnabled(true);
                Back_Row_Btn.setEnabled(true);
                Middle_Row_Btn.setEnabled(false);
                new Middle_Row_Section(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Middle Row Section Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'Back_Row_Btn' button
        Back_Row_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Front_Row_Btn.setEnabled(true);
                Middle_Row_Btn.setEnabled(true);
                Back_Row_Btn.setEnabled(false);
                new Back_Row_Section(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Back Row Section Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'Meal_Deal_Btn' button
        Meal_Deal_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meal_Deal_Btn.setEnabled(false);
                new Meal_Deal(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Meal Deal Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'VIP_Btn' button
        VIP_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VIP_Btn.setEnabled(false);
                new VIP_Access(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "VIP Access Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'Tour_Btn' button
        Tour_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tour_Btn.setEnabled(false);
                new Grounds_Tour(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Grounds Tour Selected", Toast.LENGTH_SHORT).show();
            }
        });

        if (A_T = true){
            new Adult_Ticket();
        }

         //This is the listener for the 'Buy_Btn' button
        Buy_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (A_T.equals(true)){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));
                    TextView desc = (TextView) findViewById(R.id.desc);
                    TextView cost = (TextView) findViewById(R.id.cost);
                    desc.setText("Custom Ticket\n" + Custom_Ticket.getDescription());
                    cost.setText("Total Price: £" + Custom_Ticket.getCost());
                }
                else
                {
                    //Ticket Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));
                    //TextView desc = (TextView) findViewById(R.id.desc);
                    //TextView cost = (TextView) findViewById(R.id.cost);
                    //desc.setText("Custom Ticket\n" + Custom_Ticket.getDescription());
                    //cost.setText("Total Price: £" + Custom_Ticket.getCost());
                }


                //Ticket Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));

                //Ticket Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));

                //TextView desc = (TextView) findViewById(R.id.desc);
                //TextView cost = (TextView) findViewById(R.id.cost);
                //desc.setText("Custom Ticket\n" + Custom_Ticket.getDescription());
                //cost.setText("Total Price: £" + Custom_Ticket.getCost());

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
                        startActivity(new Intent(getApplicationContext(), EventsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.About:
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });













    }}





