package com.dudbo.rgba_background_colour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Class variables
    private EditText redVal, greenVal, blueVal, opacity;
    private ConstraintLayout parent;
    private Button changeBackground;

    @Override
    public void onClick (View v) {
        if (v.getId() == R.id.redValue) {
            redVal.setText("");
        }
        else if (v.getId() == R.id.greenValue) {
            greenVal.setText("");
        }
        else if (v.getId() == R.id.blueValue) {
            blueVal.setText("");
        }
        else if (v.getId() == R.id.opacity) {
            opacity.setText("");
        }
    }

    //Convert a string to an integer
    public int strToInt (String s) {
        int val = 0;
        int end = s.length() - 1;
        int begin = 0;
        while (begin < s.length()) {
            int temp = (s.charAt(end) - '0') * powOf10(begin);
            val +=temp;
            end -=1;
            begin +=1;
        }
        return val;
    }

    //Calculate powers of 10
    public int powOf10 (int val) {
        int num = 1;
        for (int i = 0; i < val; i +=1) {
            num *=10;
        }
        return num;
    }
    //Check if a string contains any characters other than numbers
    public boolean isNumbers (String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' ||
                s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' ||
                s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9' ||
                s.charAt(i) == '0') {
                i +=1;
            }
            //Contains chars other than numbers
            else {
                return false;
            }
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redVal = findViewById(R.id.redValue);
        greenVal = findViewById(R.id.greenValue);
        blueVal = findViewById(R.id.blueValue);
        opacity = findViewById(R.id.opacity);
        parent = findViewById(R.id.parent);
        changeBackground = findViewById(R.id.changeButton);

        redVal.setOnClickListener(this);
        greenVal.setOnClickListener(this);
        blueVal.setOnClickListener(this);
        opacity.setOnClickListener(this);


        changeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isRedValid, isBlueValid, isGreenValid, isOpacityValid;
                isRedValid = isNumbers(redVal.getText().toString());
                isGreenValid = isNumbers(greenVal.getText().toString());
                isBlueValid = isNumbers(blueVal.getText().toString());
                isOpacityValid = isNumbers(opacity.getText().toString());


                //Check that only numeric input is present
                if (!isRedValid || !isGreenValid || !isBlueValid || !isOpacityValid) {
                    Toast.makeText(MainActivity.this, "Input must range from 0 to 256", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Convert the string to an integer
                    int redNum = strToInt(redVal.getText().toString());
                    int greenNum = strToInt(greenVal.getText().toString());
                    int blueNum = strToInt(blueVal.getText().toString());
                    int opacityNum = strToInt(opacity.getText().toString());

                    //Check if any of the values are out of range
                    //Beware of integer overflow
                    if (redNum < 0) {
                        redNum = 0;
                    }
                    else if (redNum > 255) {
                        redNum = 255;
                        Toast.makeText(MainActivity.this, "Warning red value out of range", Toast.LENGTH_SHORT).show();

                    }

                    if (greenNum < 0) {
                        greenNum = 0;
                    }
                    else if (greenNum > 255) {
                        greenNum = 255;
                        Toast.makeText(MainActivity.this, "Warning, green value out of range", Toast.LENGTH_SHORT).show();

                    }

                    if (blueNum < 0) {
                        blueNum = 0;
                    }
                    else if (blueNum > 255) {
                        blueNum = 255;
                        Toast.makeText(MainActivity.this, "Warning, blue value out of range", Toast.LENGTH_SHORT).show();

                    }

                    if (opacityNum < 0) {
                        opacityNum = 0;
                    }
                    else if (opacityNum > 255) {
                        opacityNum = 255;
                        Toast.makeText(MainActivity.this, "Warning, opacity value out of range", Toast.LENGTH_SHORT).show();

                    }



                    //Use bitwise operations to OR-operation the values
                    int result = blueNum | (greenNum << 8) | (redNum << 16) | (opacityNum << 24);
                    //Set background colour
                    System.out.println(String.format("0x%x", result));
                    parent.setBackgroundColor(result);

                    Toast.makeText(MainActivity.this, "Background successfully changed", Toast.LENGTH_SHORT).show();
                }
                //Reset fields
                redVal.setText("");
                blueVal.setText("");
                greenVal.setText("");
                opacity.setText("");
            }
        });

    }
}