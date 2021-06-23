package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItemE;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItemE = findViewById(R.id.etItemE);
        btnSave = findViewById(R.id.btnSave);
        getSupportActionBar().setTitle("Edit Item");

        etItemE.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // When the user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create intent which will contain the results
                Intent intent = new Intent();

                // pass the data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItemE.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // set the result of the intent
                setResult(RESULT_OK, intent);

                // finish actibity, close screen and go back
                finish();

            }
        });
    }
}