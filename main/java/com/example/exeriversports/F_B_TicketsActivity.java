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

    String TotPrc = "Total Price: £", CusTick = "Custom Ticket\n";

    Boolean A_T = false, C_T = false, M_T = false, F_R = false, M_R = false, B_R = false, M_D = false, V_P = false, T_O = false;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_tickets);

        Adult_Ticket_Btn = findViewById(R.id.btn_adult_ticket);
        Child_Ticket_Btn = findViewById(R.id.btn_child_ticket);
        Member_Ticket_Btn = findViewById(R.id.btn_member_ticket);
        Front_Row_Btn = findViewById(R.id.btn_front_row);
        Middle_Row_Btn = findViewById(R.id.btn_middle_row);
        Back_Row_Btn = findViewById(R.id.btn_back_row);
        Meal_Deal_Btn = findViewById(R.id.btn_meal_deal);
        VIP_Btn = findViewById(R.id.btn_vip);
        Tour_Btn = findViewById(R.id.btn_tour);
        Buy_Btn = findViewById(R.id.btn_purchase);


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
                F_R = true;
                M_R = false;
                B_R = false;
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
                F_R = false;
                M_R = true;
                B_R = false;
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
                F_R = false;
                M_R = false;
                B_R = true;
                new Back_Row_Section(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Back Row Section Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'Meal_Deal_Btn' button
        Meal_Deal_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meal_Deal_Btn.setEnabled(false);
                M_D = true;
                new Meal_Deal(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Meal Deal Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'VIP_Btn' button
        VIP_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VIP_Btn.setEnabled(false);
                V_P = true;
                new VIP_Access(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "VIP Access Selected", Toast.LENGTH_SHORT).show();

            }
        });

        // This is the listener for the 'Tour_Btn' button
        Tour_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tour_Btn.setEnabled(false);
                T_O = true;
                new Grounds_Tour(New_Ticket);
                Toast.makeText(F_B_TicketsActivity.this, "Grounds Tour Selected", Toast.LENGTH_SHORT).show();
            }
        });


         //This is the listener for the 'Buy_Btn' button
        Buy_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Decorators
                // Adult ticket decorator, front row section, no add ons.

                // Adult ticket / front row section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Adult_Ticket());//
                }

                // Adult ticket decorator, front row section, one add on.

                // Adult ticket / front row section / meal deal.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Front_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket / front row section / vip.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Front_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket / front row section / grounds tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Front_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket decorator, front row section, two add ons.

                // Adult ticket / front row section / meal deal / VIP.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket / front row section / meal deal / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket / front row section / vip / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket decorator, front row section, three add ons.

                // Adult ticket / front row section / meal deal / vip / tour
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Adult_Ticket()))));
                }

                // Adult ticket decorator, middle row section, no add ons.

                // Adult ticket / middle row section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Middle_Row_Section(new Adult_Ticket());//
                }

                // Adult ticket decorator, middle row section, one add on.

                // Adult ticket / middle row section / meal deal.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Middle_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket / middle row section / vip.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Middle_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket / middle row section / grounds tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Middle_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket decorator, middle row section, two add ons.

                // Adult ticket / middle row section / meal deal / VIP.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Middle_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket / middle row section / meal deal / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Middle_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket / middle row section / vip / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket decorator, middle row section, three add ons.

                // Adult ticket / middle row section / meal deal / vip / tour
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Adult_Ticket()))));
                }

                // Adult ticket decorator, back row section, no add ons.

                // Adult ticket / back row section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Back_Row_Section(new Adult_Ticket());//
                }

                // Adult ticket decorator, back row section, one add on.

                // Adult ticket / back row section / meal deal.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Back_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket / back row section / vip.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Back_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket / back row section / grounds tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Back_Row_Section(new Adult_Ticket()));
                }

                // Adult ticket decorator, back row section, two add ons.

                // Adult ticket / back row section / meal deal / VIP.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Back_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket / back row section / meal deal / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Back_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket / back row section / vip / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Adult_Ticket())));
                }

                // Adult ticket decorator, back row section, three add ons.

                // Adult ticket / back row section / meal deal / vip / tour
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Adult_Ticket()))));
                }

                // Decorators
                // Child ticket decorator, front row section, no add ons.

                // Child ticket / front row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Child_Ticket());//
                }

                // Child ticket decorator, front row section, one add on.

                // Child ticket / front row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Front_Row_Section(new Child_Ticket()));
                }

                // Child ticket / front row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Front_Row_Section(new Child_Ticket()));
                }

                // Child ticket / front row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Front_Row_Section(new Child_Ticket()));
                }

                // Child ticket decorator, front row section, two add ons.

                // Child ticket / front row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Child_Ticket())));
                }

                // Child ticket / front row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Front_Row_Section(new Child_Ticket())));
                }

                // Child ticket / front row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Child_Ticket())));
                }

                // Child ticket decorator, front row section, three add ons.

                // Child ticket / front row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Child_Ticket()))));
                }

                // Child ticket decorator, middle row section, no add ons.

                // Child ticket / middle row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Middle_Row_Section(new Child_Ticket());//
                }

                // Child ticket decorator, middle row section, one add on.

                // Child ticket / middle row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Middle_Row_Section(new Child_Ticket()));
                }

                // Child ticket / middle row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Middle_Row_Section(new Child_Ticket()));
                }

                // Child ticket / middle row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Middle_Row_Section(new Child_Ticket()));
                }

                // Child ticket decorator, middle row section, two add ons.

                // Child ticket / middle row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Middle_Row_Section(new Child_Ticket())));
                }

                // Child ticket / middle row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Middle_Row_Section(new Child_Ticket())));
                }

                // Child ticket / middle row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Child_Ticket())));
                }

                // Child ticket decorator, middle row section, three add ons.

                // Child ticket / middle row section / meal deal / vip / tour
                else if (((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) ))))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Child_Ticket()))));
                }

                // Child ticket decorator, back row section, no add ons.

                // Child ticket / back row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Back_Row_Section(new Child_Ticket());//
                }

                // Child ticket decorator, back row section, one add on.

                // Child ticket / back row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Back_Row_Section(new Child_Ticket()));
                }

                // Child ticket / back row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Back_Row_Section(new Child_Ticket()));
                }

                // Child ticket / back row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Back_Row_Section(new Child_Ticket()));
                }

                // Child ticket decorator, back row section, two add ons.

                // Child ticket / back row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Back_Row_Section(new Child_Ticket())));
                }

                // Child ticket / back row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Back_Row_Section(new Child_Ticket())));
                }

                // Child ticket / back row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Child_Ticket())));
                }

                // Child ticket decorator, back row section, three add ons.

                // Child ticket / back row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Child_Ticket()))));
                }

                // Decorators
                // Member ticket decorator, front row section, no add ons.

                // Child ticket / front row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Child_Ticket());
                }

                // Member ticket / front row section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Member_Ticket());
                }

                // Member ticket decorator, front row section, one add on.

                // Member ticket / front row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Front_Row_Section(new Member_Ticket()));
                }

                // Member ticket / front row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Front_Row_Section(new Member_Ticket()));
                }

                // Member ticket / front row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Front_Row_Section(new Member_Ticket()));
                }

                // Member ticket decorator, front row section, two add ons.

                // Member ticket / front row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Member_Ticket())));
                }

                // Member ticket / front row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Front_Row_Section(new Member_Ticket())));
                }

                // Member ticket / front row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Member_Ticket())));
                }

                // Member ticket decorator, front row section, three add ons.

                // Member ticket / front row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Member_Ticket()))));
                }

                // Member ticket decorator, middle row section, no add ons.

                // Member ticket / middle row section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Middle_Row_Section(new Member_Ticket());//
                }

                // Member ticket decorator, middle row section, one add on.

                // Member ticket / middle row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Middle_Row_Section(new Member_Ticket()));
                }

                // Member ticket / middle row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Middle_Row_Section(new Member_Ticket()));
                }

                // Member ticket / middle row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Middle_Row_Section(new Member_Ticket()));
                }

                // Member ticket decorator, middle row section, two add ons.

                // Member ticket / middle row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Middle_Row_Section(new Member_Ticket())));
                }

                // Member ticket / middle row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Middle_Row_Section(new Member_Ticket())));
                }

                // Member ticket / middle row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Member_Ticket())));
                }

                // Member ticket decorator, middle row section, three add ons.

                // Member ticket / middle row section / meal deal / vip / tour
                else if (((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) ))))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Member_Ticket()))));
                }

                // Member ticket decorator, back row section, no add ons.

                // Member ticket / back row section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Back_Row_Section(new Member_Ticket());//
                }

                // Member ticket decorator, back row section, one add on.

                // Member ticket / back row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Back_Row_Section(new Member_Ticket()));
                }

                // Member ticket / back row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Back_Row_Section(new Member_Ticket()));
                }

                // Member ticket / back row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Back_Row_Section(new Member_Ticket()));
                }

                // Member ticket decorator, back row section, two add ons.

                // Member ticket / back row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Back_Row_Section(new Member_Ticket())));
                }

                // Member ticket / back row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Back_Row_Section(new Member_Ticket())));
                }

                // Member ticket / back row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Member_Ticket())));
                }

                // Member ticket decorator, back row section, three add ons.

                // Member ticket / back row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Member_Ticket()))));
                }

                TextView desc = findViewById(R.id.desc);
                TextView cost = findViewById(R.id.cost);
                desc.setText(CusTick + Custom_Ticket.getDescription());
                cost.setText(TotPrc + Custom_Ticket.getCost());
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
