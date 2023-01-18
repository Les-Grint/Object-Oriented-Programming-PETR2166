package com.example.exeriversports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //This declares the EditText variables 'email' and 'password'.
    EditText email, password;

    //This declares the Button variables 'Login' and 'SignUp'.
    Button Login, SignUp;

    //This declares the DBFunctions variable 'DB.
    DBFunctions DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // This initialises the variables and assigns the values entered by the user to them.
        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password1);
        Login = (Button) findViewById(R.id.btnLogin1);
        SignUp = (Button) findViewById(R.id.btnSignup1);
        DB = new DBFunctions(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Here the declared string variables will hold the information entered by the user
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                // If any of the string variables are empty execute the toast message.
                if(Email.equals("") || Password.equals (""))
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                else{
                    // This calls the 'checklogin' function from 'DBFunctions.java'.
                    Boolean checklogin = DB.checklogin(Email, Password);
                        // If the the login details match the details stored in the database execute the toast message.
                        if(checklogin==true){


                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            // This redirects to the Home page.
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Invalid login details", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        });

        // This is the listener for the 'Sign Up Page' button
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This redirects to the Sign Up page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
