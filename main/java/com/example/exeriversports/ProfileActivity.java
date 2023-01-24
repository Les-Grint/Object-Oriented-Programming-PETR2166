package com.example.exeriversports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity
{

    // This declares variables for the users entered text.
    EditText fName, lName, email, password, rePassword;

    // This declares variables for the buttons entered text.
    Button Update, Delete, Select;
    // This declares variable for the Database.

    // This declares variable for the Database.
    DBFunctions DB;


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SessionManagement sessionManagement = new SessionManagement(ProfileActivity.this);
        String Email = sessionManagement.getSession();

        TextView test = (TextView) findViewById(R.id.test);
        test.setText(Email);
        // TextView lName = (TextView) findViewById(R.id.lName);
        // EditText email = (EditText) findViewById(R.id.email);
        // email.setText(Email);

        // This initialises the variables and assigns the values entered by the user to them.
        fName = (EditText) findViewById(R.id.fName);
        lName = (EditText) findViewById(R.id.lName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        rePassword = (EditText) findViewById(R.id.rePassword);

        Update = findViewById(R.id.btnUpdate);
        Delete = findViewById(R.id.btnDelete);
        Select = findViewById(R.id.btnSelect);
        DB = new DBFunctions(this);

        Update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String FirstName = fName.getText().toString();
                String LastName = lName.getText().toString();
                String Password = password.getText().toString();
                String RePassword = rePassword.getText().toString();

                // If any of the string variables are empty execute the toast message.
                if(FirstName.equals("") || LastName.equals("") || Email.equals("") || Password.equals("") || RePassword.equals(""))
                    Toast.makeText(ProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    // If none of the string variables are empty execute the code in the 'ELSE' statement/
                else
                {
                    // If the values stored in the string variables 'Password' and 'RePassword' match execute the code within the 'IF statement'.
                    if(Password.equals(RePassword))
                    {
                        Boolean checkupdatedata = DB.updateData(FirstName, LastName, Email, Password);
                        if (checkupdatedata == true) {
                            Toast.makeText(ProfileActivity.this, "Member details updated", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(ProfileActivity.this, "No record found to update", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(ProfileActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                // String Email = email.getText().toString();
                        Boolean checkdeletedata = DB.deleteData(Email);
                        if (checkdeletedata == true)
                        {
                            Toast.makeText(ProfileActivity.this, "Member details deleted", Toast.LENGTH_SHORT).show();
                            // This will remove all values saved in session and redirect to the login screen
                            SessionManagement sessionManagement = new SessionManagement(ProfileActivity.this);
                            sessionManagement.removeSession();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else
                        {
                            Toast.makeText(ProfileActivity.this, "No record found to delete", Toast.LENGTH_SHORT).show();
                        }

            }
        });

        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Cursor res = DB.getdata(Email); //  DB.getdata(Email);
                if(res.getCount()==0)
                {
                    Toast.makeText(ProfileActivity.this, "No record found", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Email :"+res.getString(0)+"\n");
                    buffer.append("First Name :"+res.getString(1)+"\n");
                    buffer.append("Last name :"+res.getString(2)+"\n");
                    buffer.append("Password :"+res.getString(3)+"\n\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Members List");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

            bottomNavigationView = findViewById(R.id.bottom_navigator);
            bottomNavigationView.setSelectedItemId(R.id.Profile);

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
    }
}