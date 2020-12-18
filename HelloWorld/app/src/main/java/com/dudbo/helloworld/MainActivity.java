package com.dudbo.helloworld;

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

    public void onBtnClick (View view) {
        EditText edtTxtName = findViewById(R.id.edtTxtName);
        TextView txtHello = findViewById(R.id.txtMessage);
        txtHello.setText("You died " + edtTxtName.getText().toString());
    }
}