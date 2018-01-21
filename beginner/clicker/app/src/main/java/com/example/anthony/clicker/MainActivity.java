package com.example.anthony.clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    Button btnReset;

    TextView txtCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button)findViewById(R.id.buttonClick);
        btnReset = (Button)findViewById(R.id.buttonReset);
        txtCount = (TextView)findViewById(R.id.textViewCount);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = txtCount.getText().toString();
                Integer intCountValue = Integer.parseInt(countValue);
                intCountValue++;
                txtCount.setText(String.valueOf(intCountValue));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCount.setText(String.valueOf(0));
            }
        });

    }
}
