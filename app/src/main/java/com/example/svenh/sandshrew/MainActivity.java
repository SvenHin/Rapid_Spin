package com.example.svenh.sandshrew;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    Cursor c = null;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolbar =   findViewById(R.id.main_toolbar);
        setActionBar(mainToolbar);
        getActionBar().setDisplayShowTitleEnabled(false);
        PreferenceManager.setDefaultValues(this,R.xml.preferences,false);
        db = new DBHandler(MainActivity.this);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar, menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.prefBtn:
                showPreferences();
                break;
            case R.id.newRunBtn:
                Intent e = new Intent(this, PokemonHandler.class);
                this.startActivity(e);
                break;

        }
        return true;
    }
    public void showPreferences(){
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }


}

