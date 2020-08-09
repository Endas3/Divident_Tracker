package com.example.divident_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.attempt_3.R;

public class AddActivity extends AppCompatActivity {

    EditText tickerInput, costInput, quantityInput;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tickerInput = findViewById(R.id.tickerInput);
        costInput = findViewById(R.id.costInput);
        quantityInput = findViewById(R.id.quantityInput);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper myDB = new MyDBHelper(AddActivity.this);
                myDB.addStock(tickerInput.getText().toString().trim(), Double.valueOf(costInput.getText().toString().trim()), Double.valueOf(quantityInput.getText().toString().trim()));
                tickerInput.setText("");
                costInput.setText("");
                quantityInput.setText("");
            }
        });

    }
}