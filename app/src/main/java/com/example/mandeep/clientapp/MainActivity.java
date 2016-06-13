package com.example.mandeep.clientapp;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Mandeep on 13-06-2016.
 */
public class MainActivity extends AppCompatActivity {

    protected static final String PROVIDER_NAME = "com.mandeep.provider.hr";
    protected static final String TABLE_NAME = "employee";
    protected static final String URL = "content://" + PROVIDER_NAME + "/" + TABLE_NAME;
    protected static final Uri CONTENT_URI = Uri.parse(URL);

    protected static final String idField = "_id";
    protected static final String nameField = "name";
    protected static final String ageField = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewEmployee(View view) {

        //Add new employee record
        ContentValues contentValues = new ContentValues();
        contentValues.put(nameField, ((EditText) findViewById(R.id.txtName)).getText().toString());
        contentValues.put(ageField, ((EditText) findViewById(R.id.txtAge)).getText().toString());

        //insert the record
        Uri uri = getContentResolver().insert(CONTENT_URI, contentValues);

        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    // Navigate to ViewEmployees Activity
    public void getAllEmployees(View view) {
        Intent intent = new Intent(this, ViewAllEmployees.class);
        startActivity(intent);
    }
}
