package com.dudbo.ui_basic3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private CheckBox findingNemo, theLionKing, theTheoryOfEverything;
    private RadioGroup rgRelationship;
    private ProgressBar progressBar;

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Toast.makeText(this, "You have seen finding Nemo", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You have not seen finding Nemo", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (R.id.rbMarried == checkedId ) {
            Toast.makeText(this, "Married", Toast.LENGTH_SHORT).show();
        }
        else if (R.id.rbSingle == checkedId) {
            Toast.makeText(this, "Single", Toast.LENGTH_SHORT).show();
        }
        else if (R.id.rbInARelation == checkedId) {
            Toast.makeText(this, "In a relation", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findingNemo = findViewById(R.id.findingNemo);
        theLionKing = findViewById(R.id.theLionKing);
        theTheoryOfEverything = findViewById(R.id.theTheoryOfEverything);


        if (findingNemo.isChecked()) {
            Toast.makeText(this, "You have seen finding Nemo", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You have not seen finding Nemo", Toast.LENGTH_SHORT).show();
        }
        //Two ways to declare a listener
        findingNemo.setOnCheckedChangeListener(this);
        //One via passing an object
        //Or creating a method and as above
        theLionKing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have seen The Lion King", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "You have not seen The Lion King", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rgRelationship = findViewById(R.id.rgRelationship);
        rgRelationship.setOnCheckedChangeListener(this);

        progressBar = findViewById(R.id.progressBar);

    }
}