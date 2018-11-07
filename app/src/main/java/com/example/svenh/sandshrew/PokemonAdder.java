package com.example.svenh.sandshrew;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.app.*;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.IOException;

public class PokemonAdder extends Activity {

    private TextView pke_add_name, pke_add_ab, pke_add_t1, pke_add_t2, pke_add_nat, pke_add_id, pke_add_stat;
    private ProgressBar ratingBar;
    private int best_stat = 0;
    DBHandler db;
    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonadder);
        Toolbar pokemonhandlertoolbar =  findViewById(R.id.pokemonadder_toolbar);
        setActionBar(pokemonhandlertoolbar);
        getActionBar().setDisplayShowTitleEnabled(false);
        db  = new DBHandler(PokemonAdder.this);


        //XML FIELDS DEFINED BELOW
        pke_add_id = findViewById(R.id.pke_id);
        pke_add_name = findViewById(R.id.pkm_name);
        pke_add_ab = findViewById(R.id.ability);
        pke_add_t1 = findViewById(R.id.type1);
        pke_add_t2 = findViewById(R.id.type2);
        pke_add_nat = findViewById(R.id.nature);
        pke_add_stat = findViewById(R.id.total);


        ratingBar = (ProgressBar) findViewById(R.id.ratingBar);
    }



        public void initialize(){

        }


    public void addPokemon( View view){
        Pokemon pokemon = new Pokemon(Integer.parseInt(pke_add_id.getText().toString()), pke_add_name.getText().toString(), pke_add_t1.getText().toString(),pke_add_t2.getText().toString(),pke_add_ab.getText().toString(), pke_add_nat.getText().toString(),(Integer.parseInt(pke_add_stat.getText().toString())));
        /*Toast.makeText(PokemonAdder.this,
                "Name: " + pokemon.getName(),
                Toast.LENGTH_SHORT).show();
        Toast.makeText(PokemonAdder.this,
                "Ability :" + pokemon.getAbility(),
                        Toast.LENGTH_SHORT).show();
        Toast.makeText(PokemonAdder.this,
                "Type1 :" + pokemon.getType1(),
                        Toast.LENGTH_SHORT).show();
        Toast.makeText(PokemonAdder.this,
                "Type2 :" + pokemon.getType2(),
                        Toast.LENGTH_SHORT).show();
        Toast.makeText(PokemonAdder.this,
                "Nature :" + pokemon.getNature(),
                        Toast.LENGTH_SHORT).show();
        Toast.makeText(PokemonAdder.this,
                "ID: " + pokemon.get_id(),
                        Toast.LENGTH_SHORT).show();
        Toast.makeText(PokemonAdder.this,
                "Total:" + pokemon.getStat(),
                        Toast.LENGTH_SHORT).show();
        */
        try{
            db.addPokemon(pokemon);
            Toast.makeText(PokemonAdder.this,
                    "Added to db",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        catch (Exception e){
            Toast.makeText(PokemonAdder.this, "Exception" + (e.getMessage()), Toast.LENGTH_LONG).show();
        }

    }

    public void updateRating(){
        int rating = Integer.parseInt(pke_add_stat.getText().toString());
        ratingBar.setProgress(rating);
    }


    //Reroll methods under
    public void rerollId(View v){
        ((TextView) findViewById(R.id.pke_id)).setText(db.getRandomId());
    }

    public void getNewPokemon(View v){

    }
    public void rerollname(View v){
        ((TextView) findViewById(R.id.pkm_name)).setText(db.getRandomName());
    }
    public void rerollability(View v){
        ((TextView) findViewById(R.id.ability)).setText(db.getRandomAbility());
    }
    public void rerolltype1(View v){
        ((TextView) findViewById(R.id.type1)).setText(db.getRandomType());
    }
    public void rerolltype2(View v){
        ((TextView) findViewById(R.id.type2)).setText(db.getRandomType());

    }
    public void rerollnature(View v){
        ((TextView) findViewById(R.id.nature)).setText(db.getRandomNature());
    }
    public void rerollstat(View v){
        ((TextView) findViewById(R.id.total)).setText(db.getRandomStat());
        updateRating();
    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pokemonadder_toolbar, menu);
        return true;
    }


}
