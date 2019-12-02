package com.android_controler;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//Socket.io
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

//JAVA
import java.net.URISyntaxException;




public class MainActivity extends AppCompatActivity {

    private Button BTActivite;
    private Button SocketBtn;

    //preparation de socket
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.43.63:3000");
            Log.i ("test avec", String.valueOf(mSocket));
        } catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSocket.connect();
        Log.i ("etat: ","connected...");
        //affichage de la page
        setContentView(R.layout.activity_main);


        //création evenement clique sur button
        BTActivite = findViewById(R.id.startPartie);
        BTActivite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Lancer = new Intent(MainActivity.this, activitytwo.class);
                startActivity(Lancer);
                mSocket.emit("Partie lancer");

            }
        });
        //fin button
        //création evenement clique sur button
        SocketBtn = findViewById(R.id.testsocketbutton);
        SocketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //quand clique
                mSocket.emit("btn1+");
            }
        });
        //fin button






    }
    //fin on create


}
