package com.samer.mathsucks;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageEditText;
    EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        totalTextView = findViewById(R.id.totalTextView);
        percentageEditText = findViewById(R.id.percentageEditText);
        numberEditText = findViewById(R.id.numberEditText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(!percentageEditText.getText().toString().isEmpty()) {
                      if(!numberEditText.getText().toString().isEmpty()) {
                          totalTextView.setText(
                                  Float.toString(
                                          Float.parseFloat(numberEditText.getText().toString())     *
                                  (Float.parseFloat(percentageEditText.getText().toString()) / 100)
                                  )
                          );
                      } else {
                          totalTextView.setText("0");
                          Toast.makeText(getApplicationContext(), "Please enter number", Toast.LENGTH_SHORT).show();
                      }
                  } else {
                      totalTextView.setText("0");
                      Toast.makeText(getApplicationContext(), "Please enter percentage", Toast.LENGTH_SHORT).show();
                  }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
