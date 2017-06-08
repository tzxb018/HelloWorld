package com.example.tbessho.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final  String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*called when the user taps the send button*/
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.A){
            //write
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.B){
            //write
            Intent intent2 = new Intent(this, B_Activity.class);
            startActivity(intent2);
            return true;
        }

        if (id == R.id.C){
            Intent intent3 = new Intent( this, Camera_Activity .class);
            startActivity(intent3);
            return true;
        }
        return true;
    }

}
