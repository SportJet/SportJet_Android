package com.sportjet.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        View contextView = findViewById(R.id.monlayout);

        /* création des Snackbar de status des connection */
        final Snackbar connection_back = Snackbar.make(contextView, R.string.status_connection_back, Snackbar.LENGTH_LONG);
        final Snackbar connection_lose = Snackbar.make(contextView, R.string.status_connection_lose, Snackbar.LENGTH_LONG);

        View.OnClickListener actionok = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                connection_lose.show();
            }};

        View.OnClickListener actionnope = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                connection_back.show();
            }};
        /* affichage de test*/
        connection_back.setAction("OK",actionok );
        connection_lose.setAction("OK",actionnope );

        connection_back.show();


    }
    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
