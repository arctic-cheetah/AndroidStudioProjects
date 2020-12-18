package com.dudbo.ui_basic2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private EditText edtTxtName;
    private TextView txtHello;

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnHello) {
            Toast.makeText(this, "G'day " + edtTxtName.getText().toString() + "\n", Toast.LENGTH_SHORT).show();
            txtHello.setText("Hello " + edtTxtName.getText().toString());
        }
        else if (v.getId() == R.id.edtTxtName) {
            Toast.makeText(this, "Attempting to write", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "Pressed long", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);
        btnHello.setOnLongClickListener(this);

        txtHello = findViewById(R.id.txtHello);
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtName.setOnClickListener(this);
        txtHello.setOnClickListener(this);
    }

}