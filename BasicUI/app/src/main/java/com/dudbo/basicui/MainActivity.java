package com.dudbo.basicui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button selectImage;

    //Check that all variables have entry
    private Spinner nationSpinner;
    private Button register;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText reEnterPassword;
    private RelativeLayout parent;
    private RadioGroup gender;
    private CheckBox agreement;
    private String name2;
    private String email2;
    private String password2;
    private String reEnterPassWord2;
    private String nationSpinner2;
    private ArrayList<String> listNations = new ArrayList<String>();

    @Override
    public void onClick(View v) {
        //Fetch the data and check for validity
        name2 = name.getText().toString();
        email2 = email.getText().toString();
        password2 = password.getText().toString();
        reEnterPassWord2 = reEnterPassword.getText().toString();
        nationSpinner2 = nationSpinner.getSelectedItem().toString();

        if (v.getId() == R.id.selectImageButton) {
            Toast.makeText(this, "Selected image", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.passWord) {
            Toast.makeText(this, "Password must have at least 8 characters or more", Toast.LENGTH_LONG).show();
        }
        else if (v.getId() == R.id.registerButton) {
            boolean success = true;
            if (name2.isEmpty()) {
                Toast.makeText(this, "Name cannot be empty ", Toast.LENGTH_SHORT).show();
                success = false;
            }
            if (email2.isEmpty()) {
                Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                success = false;
            }
            if (password2.length() < 8) {
                Toast.makeText(this, "Password is too short, and it must be at least 8 characters long", Toast.LENGTH_LONG).show();
                success = false;
            }
            if (!reEnterPassWord2.equals(password2)) {
                Toast.makeText(this, "Re-entered password must be identical to the password", Toast.LENGTH_SHORT).show();
                success = false;
            }
            if (gender.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Must select a gender", Toast.LENGTH_SHORT).show();
                success = false;
            }
            if (nationSpinner2.isEmpty()) {
                Toast.makeText(this, "Country cannot be empty", Toast.LENGTH_SHORT).show();
                success = false;
            }
            if (!agreement.isChecked()) {
                Toast.makeText(this, "Must accept user agreement", Toast.LENGTH_SHORT).show();
                success = false;
            }
            if (success) {
                Snackbar.make(parent, "Successfully registered user", Snackbar.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nationSpinner = findViewById(R.id.nationsSpinner);
        selectImage = findViewById(R.id.selectImageButton);
        register = findViewById(R.id.registerButton);
        name = findViewById(R.id.userName);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.passWord);
        reEnterPassword = findViewById(R.id.reEnterPassWord);
        agreement = findViewById(R.id.CheckBoxUserAgreement);
        gender = findViewById(R.id.RadioGroupGender);
        parent = findViewById(R.id.RelativeLayout);

        listNations.add("");
        listNations.add("Australia");
        listNations.add("Brazil");
        listNations.add("United Kingdom");
        listNations.add("United States");
        listNations.add("Canada");
        listNations.add("China");
        listNations.add("Germany");
        listNations.add("France");
        listNations.add("Saudi Arabia");
        listNations.add("Russia");
        listNations.add("Sweden");
        listNations.add("Italy");
        listNations.add("Qatar");
        listNations.add("South Africa");
        listNations.add("Spain");
        listNations.add("Ireland");
        listNations.add("Chile");
        listNations.add("Uruguay");
        listNations.add("Greece");
        nationSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listNations));

        selectImage.setOnClickListener(this);
        password.setOnClickListener(this);
        register.setOnClickListener(this);


        //Check if user agreement is empty
    }
}