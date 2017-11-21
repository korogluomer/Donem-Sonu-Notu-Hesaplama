package com.example.omero.donemsonuortalamahesaplama;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by omero on 3.09.2017.
 */

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);


        Bundle extras=getIntent().getExtras();
        double sonuc=extras.getDouble("sonuc_al");
        sonuc=Math.floor(sonuc*100)/100;

        TextView sonuctxt=(TextView)findViewById(R.id.sonucText);
        sonuctxt.setText(String.valueOf(sonuc));

    }
}
