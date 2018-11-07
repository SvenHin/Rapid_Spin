package com.example.svenh.sandshrew;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class PokemonHandler extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonhandler);

        Toolbar pokemonhandlertoolbar =  findViewById(R.id.pokemonhandler_toolbar);
        setActionBar(pokemonhandlertoolbar);
        getActionBar().setDisplayShowTitleEnabled(false);
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.addPkeBtn:
                Intent e = new Intent(this, PokemonAdder.class);
                this.startActivity(e);
                break;
        }
        return true;
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pokemonhandler_toolbar, menu);
        return true;
    }
}
