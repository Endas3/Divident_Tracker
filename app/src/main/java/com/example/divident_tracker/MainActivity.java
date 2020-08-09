package com.example.divident_tracker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.attempt_3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addButton;

    MyDBHelper myDB;
    ArrayList<String> stock_id, stock_ticker, stock_cost, stock_quantity;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDBHelper(MainActivity.this);
        stock_id = new ArrayList<>();
        stock_ticker = new ArrayList<>();
        stock_cost = new ArrayList<>();
        stock_quantity = new ArrayList<>();

        storeDataInArrays();


        customAdapter = new CustomAdapter(MainActivity.this, this, stock_id, stock_ticker, stock_cost, stock_quantity);
        recyclerView.setAdapter(customAdapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor =myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                stock_id.add(cursor.getString(0));
                stock_ticker.add(cursor.getString(1));
                stock_cost.add(cursor.getString(2));
                stock_quantity.add(cursor.getString(3));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigate, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_news){
            Intent intent = new Intent(MainActivity.this,NewsActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_data){
            Intent intent = new Intent(MainActivity.this,DataActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}