package com.example.envy_m4.numberguessingapp;

import android.content.Intent;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int randomNumber;
    private int attemptCount = 1;
    private String message = "";
    private String messageSuccess = "";

    public void checkGuess(View view){

        TextView showText = (TextView) findViewById(R.id.textView);

        TextView attempt = (TextView) findViewById(R.id.attemptView);

        Button guessButton = (Button) findViewById(R.id.guessButton);

        EditText guessedNumber = (EditText) findViewById(R.id.guessedNumber);

        int guessedNumberInt = Integer.parseInt(guessedNumber.getText().toString());


        if(guessedNumberInt > randomNumber){

            message = "Too high!";
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

        }
        else if(guessedNumberInt < randomNumber){

            message = "Too low!";
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

        }
        else{
            messageSuccess = "Congrats!! Well done mate!";
            showText.setText(messageSuccess);
            String attemptC = Integer.toString(attemptCount);
            attempt.setText(attemptC);
          //  guessButton.setEnabled(false);
            guessButton.setVisibility(View.INVISIBLE);
            guessedNumber.setEnabled(false);
        }

        String attemptC = Integer.toString(attemptCount);
        attempt.setText(attemptC);
        attemptCount++;


    }

    public void loadActivity(){
        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(101);
    }

    public void onClick (View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        loadActivity();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
