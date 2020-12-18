package com.dudbo.prompt;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view) {
        //Change the first name
        EditText FirstName = findViewById(R.id.FirstName);
        TextView UserFirstName = findViewById(R.id.UserFirstName);
        UserFirstName.setText(FirstName.getText().toString());
        //Change the last name
        EditText LastName = findViewById(R.id.LastName);
        TextView UserLastName = findViewById(R.id.UserLastName);
        UserLastName.setText(LastName.getText().toString());
        //Change the email
        EditText Email = findViewById(R.id.Email);
        TextView UserEmail = findViewById(R.id.UserEmail);
        UserEmail.setText(Email.getText().toString());
    }
}