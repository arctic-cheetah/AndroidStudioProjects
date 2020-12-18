package com.dudbo.listview_and_spiner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView cities;
    private Spinner nameSpinner;
//    private ArrayList<String> myNames = new ArrayList<String>();
    ArrayList<String> myCities = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = findViewById(R.id.myList);
        myCities.add("London");
        myCities.add("Auckland");
        myCities.add("Beirut");
        myCities.add("Paris");
        myCities.add("Rome");

        nameSpinner = findViewById(R.id.mySpinner);
//        myNames.add("Jay");
//        myNames.add("Jebediah");
//        myNames.add("Riley");
//        myNames.add("Excelsior");
//        ArrayAdapter<String> namesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, myNames);
//        nameSpinner.setAdapter(namesAdapter);

        nameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected " + nameSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myCities);
        cities.setAdapter(citiesAdapter);

        cities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected " + myCities.get(position), Toast.LENGTH_SHORT).show();
                System.out.println(R.id.mySpinner);
                System.out.println(R.id.myList);
                System.out.println(view.getId());
                System.out.println(id);
            }
        });



    }
}