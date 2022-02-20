package com.example.activit_1_adv_204_billanes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView Result;
    EditText Non_negative_integer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = findViewById(R.id.Result);
        Non_negative_integer = findViewById(R.id.non_negative_integer);
    }

    public void Convert(View view) {
        Result.setText(Result());
    }
    private String Result(){
        int input = 0;
        try {
            input = Integer.parseInt(Non_negative_integer.getText().toString());
        } catch (Exception e) {
            input = 0;
            return("Number only");
        }
        if(input<0)
            return ("Postive number only");
        int sorted = 0;
        int digits = 10;
        int sortedDigits = 1;
        boolean first = true;

        while (input > 0) {
            int digit = input % 10;

            if (!first) {

                int tmp = sorted;
                int toDivide = 1;
                for (int i = 0; i < sortedDigits; i++) {
                    int tmpDigit = tmp % 10;
                    if (digit <= tmpDigit) {
                        sorted = sorted / toDivide * toDivide * 10 + digit * toDivide + sorted % toDivide;
                        break;
                    } else if (i == sortedDigits - 1) {
                        sorted = digit * digits + sorted;
                    }
                    tmp /= 10;
                    toDivide *= 10;
                }
                digits *= 10;
                sortedDigits += 1;
            } else {
                sorted = digit;
            }

            first = false;
            input = input / 10;
        }
        return(sorted + "");
    }
}
