package com.example.mandeep.clientapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Mandeep on 13-06-2016.
 */
public class ViewAllEmployees extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all);
        ListView listview = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

        listview.setAdapter(arrayAdapter);

        //Retrieve all employee records from the provider app
        Cursor cursor = getContentResolver().query(MainActivity.CONTENT_URI, null, null, null, null);

        //populate the employee records in the listview

        if (cursor.moveToFirst()) {
            do {
                arrayAdapter.add(cursor.getString(cursor.getColumnIndex(MainActivity.idField)) + "\n"
                        + cursor.getString(cursor.getColumnIndex(MainActivity.nameField)) + "\n"
                        + cursor.getString(cursor.getColumnIndex(MainActivity.ageField)));
            }
            while(cursor.moveToNext());
        }
    }
}
