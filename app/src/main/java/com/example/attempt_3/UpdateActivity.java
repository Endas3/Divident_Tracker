package com.example.attempt_3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateActivity extends AppCompatActivity {

    EditText ticker_input, cost_input, quantity_input;
    Button update_button;
    FloatingActionButton delete_button;



    String id, ticker, cost, quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ticker_input = findViewById(R.id.tickerInputUpdate);
        cost_input = findViewById(R.id.costInputUpdate);
        quantity_input = findViewById(R.id.quantityInputUpdate);
        update_button = findViewById(R.id.updateButton);
        delete_button = findViewById(R.id.deleteButton);
        //Call first
        getAndSetIntentData();


        //Set action bar after get and set data
        ActionBar ab = getSupportActionBar();
        if (ab !=null){
            ab.setTitle("Update Stock: " +ticker);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper myDB = new MyDBHelper(UpdateActivity.this);
                ticker = ticker_input.getText().toString().trim();
                cost = cost_input.getText().toString().trim();
                quantity = quantity_input.getText().toString().trim();
                //Call after
                myDB.updateData(id, ticker, cost, quantity);
                finish();
            }

        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
     }
     void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("ticker") && getIntent().hasExtra("cost") && getIntent().hasExtra("quantity")){
            //Getting data
            id = getIntent().getStringExtra("id");
            ticker = getIntent().getStringExtra("ticker");
            cost = getIntent().getStringExtra("cost");
            quantity = getIntent().getStringExtra("quantity");

            //Setting data
            ticker_input.setText(ticker);
            cost_input.setText(cost);
            quantity_input.setText(quantity);
        }else{
            Toast.makeText(this, "No Data!", Toast.LENGTH_SHORT).show();
        }
     }

     void confirmDialog(){
         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setTitle("Delete " + ticker + "?");
         builder.setMessage("Are you sure you want to delete " + ticker + "?");
         builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 MyDBHelper myDB = new MyDBHelper(UpdateActivity.this);
                 myDB.deleteOneRow(id);
                 finish();

             }
         });
         builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {

             }
         });
         builder.create().show();
     }
}