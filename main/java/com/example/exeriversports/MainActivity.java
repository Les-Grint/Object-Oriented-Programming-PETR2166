package com.example.exeriversports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // This declares variables for the users entered text.
    EditText fName, lName, email, password, rePassword;

    // This declares variables for the buttons entered text.
    Button Signup, Login;

    // This declares variable for the Database.
    DBFunctions DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This initialises the variables and assigns the values entered by the user to them.
        fName = (EditText) findViewById(R.id.fName);
        lName = (EditText) findViewById(R.id.lName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        rePassword = (EditText) findViewById(R.id.rePassword);
        Signup = (Button) findViewById(R.id.btnSignup);
        Login = (Button) findViewById(R.id.btnLogin);
        DB = new DBFunctions(this);

        // This is the listener for the 'Signup' button
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            // This is the event handler for the Signup button
            public void onClick(View view) {
                // Here the declared strings will hold the information entered by the user
                String FirstName = fName.getText().toString();
                String LastName = lName.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String RePassword = rePassword.getText().toString();

                // If any of the string variables are empty execute the toast message.
                if(FirstName.equals("") || LastName.equals("") || Email.equals("") || Password.equals("") || RePassword.equals(""))
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                // If none of the string variables are empty execute the code in the 'ELSE' statement/
                else
                {
                    // If the values stored in the string variables 'Password' and 'RePassword' match execute the code within the 'IF statement'.
                    if(Password.equals(RePassword))
                    {
                        Boolean checkmember = DB.checkemail(Email);
                        if(checkmember==false)
                        {
                            Boolean insert = DB.insertData(Email, FirstName, LastName, Password);
                            if(insert==true)
                            {
                                Toast.makeText(MainActivity.this, "Member successfully registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this, "Member registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Email already registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

        // This is the listener for the 'Login' button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This redirects to the Login page
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}