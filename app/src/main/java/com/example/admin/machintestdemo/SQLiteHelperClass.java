package com.example.admin.machintestdemo;

import android.content.ContentValues;
import android.content.Context;

import static com.example.admin.machintestdemo.Constants.*;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Admin on 1/19/2017.
 */

public class SQLiteHelperClass extends SQLiteOpenHelper {


    public SQLiteHelperClass(Context context) {
        super(context, Constants.DATABSE_PATH + Constants.DATABSE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USER_DETAILS = "CREATE TABLE " + TABLE_PRODUCT_DETAILS + " ("
                + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_NAME + " TEXT, "
                + COLUMN_PRODUCT_PRICE + " TEXT, "
                + COLUMN_PRODUCT_QUANTITY + " TEXT )";


        Log.d("onCreate ", "onCreate: " + CREATE_USER_DETAILS);
        db.execSQL(CREATE_USER_DETAILS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIntoTable(String productName, String productPrice, String productQuantity) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();

        valuess.put(COLUMN_PRODUCT_NAME, productName);
        valuess.put(COLUMN_PRODUCT_PRICE, productPrice);
        valuess.put(COLUMN_PRODUCT_QUANTITY, productQuantity);

        db.insert(TABLE_PRODUCT_DETAILS, null, valuess);
        db.close();
        Log.e("***insertIntoTable***", "insertion successfully");
    }


    public void updateTableQuantity(String productPrice, String productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuess = new ContentValues();
        valuess.put(COLUMN_PRODUCT_PRICE, productPrice);
        db.update(TABLE_PRODUCT_DETAILS, valuess, "PRODUCT_ID = '" + productId + "'", null);
        Log.e("update successfull", "register user name ");

    }


    public JSONArray getAllTableDetails(String id) {

        JSONArray jarr = new JSONArray();
        JSONObject job = new JSONObject();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE_PRODUCT_DETAILS + " WHERE PRODUCT_ID = '" + id + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                job = new JSONObject();

                if (job != null) {
                    jarr.put(job);
                }

                String product_id = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_ID));
                String product_name = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME));
                String product_price = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_PRICE));
                String product_qty = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_QUANTITY));


                try {
                    job.put("product_id", product_id);
                    job.put("product_name", product_name);
                    job.put("product_price", product_price);
                    job.put("product_qty", product_qty);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                cursor.moveToNext();

            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return jarr;
    }

   /* public String getTableQuantity(String g_id) {

        String admin = "Y";
        String member = "";
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT  * FROM " + TABLE_PRODUCT_DETAILS + " WHERE GROUP_ID='" + g_id + "' AND GROUP_MEMBERS_IS_ADMIN='" + admin + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            Log.d("EMessanger..", "Reading Records");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                member = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_ID));
                cursor.moveToNext();
            }

        } else {
            Log.d("EMessanger..", "Cursor is null");
        }
        return member;
    }*/
}