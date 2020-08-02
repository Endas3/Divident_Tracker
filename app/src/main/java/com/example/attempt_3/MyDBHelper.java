package com.example.attempt_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "StockLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "stockList";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TICKER = "stock_ticker";
    private static final String COLUMN_COST = "stock_cost";
    private static final String COLUMN_QUANTITY = "stock_quantity";

    MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TICKER + " TEXT, " + COLUMN_COST + " DOUBLE, " + COLUMN_QUANTITY + " DOUBLE);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
    void addStock(String ticker, Double cost, Double quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TICKER, ticker);
        cv.put(COLUMN_COST, cost);
        cv.put(COLUMN_QUANTITY, quantity);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db !=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

    void updateData(String row_id, String ticker, String cost, String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TICKER,ticker);
        cv.put(COLUMN_COST,cost);
        cv.put(COLUMN_QUANTITY,quantity);

        long result = db.update(TABLE_NAME,cv,"_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Update.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Update Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,"_id=?",new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
        }

    }
}
