package com.example.florian.magicapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChooseColor extends AppCompatActivity{

    //Player1
    private Button p1_b_white;
    private Button p1_b_black;
    private Button p1_b_red;
    private Button p1_b_blue;
    private Button p1_b_green;
    private TextView p1_showCol;
    private int p1_col;            //für Übergabe der gewählten Farbe als int

    //Player2
    private Button p2_b_white;
    private Button p2_b_black;
    private Button p2_b_red;
    private Button p2_b_blue;
    private Button p2_b_green;
    private TextView p2_showCol;
    private int p2_col;

    //Pick Color Button
    private Button b_pickCol;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_color);

        //Pick Color Button
        b_pickCol = findViewById(R.id.pickCol_button);

        //Player 1
        p1_b_white = findViewById(R.id.p1_b_white);
        p1_b_black = findViewById(R.id.p1_b_black);
        p1_b_red = findViewById(R.id.p1_b_red);
        p1_b_blue = findViewById(R.id.p1_b_blue);
        p1_b_green = findViewById(R.id.p1_b_green);
        p1_showCol = findViewById(R.id.p1_col_selected);

        p1_b_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_col = getResources().getColor(R.color.white);
                p1_showCol.setBackgroundColor(p1_col);
            }
        });

        p1_b_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_col = getResources().getColor(R.color.black);
                p1_showCol.setBackgroundColor(p1_col);
            }
        });

        p1_b_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_col = getResources().getColor(R.color.red);
                p1_showCol.setBackgroundColor(p1_col);
            }
        });

        p1_b_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_col = getResources().getColor(R.color.blue);
                p1_showCol.setBackgroundColor(p1_col);
            }
        });

        p1_b_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1_col = getResources().getColor(R.color.green);
                p1_showCol.setBackgroundColor(p1_col);
            }
        });


        //Player 2
        p2_b_white = findViewById(R.id.p2_b_white);
        p2_b_black = findViewById(R.id.p2_b_black);
        p2_b_red = findViewById(R.id.p2_b_red);
        p2_b_blue = findViewById(R.id.p2_b_blue);
        p2_b_green = findViewById(R.id.p2_b_green);
        p2_showCol = findViewById(R.id.p2_col_selected);

        p2_b_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2_col = getResources().getColor(R.color.white);
                p2_showCol.setBackgroundColor(p2_col);
            }
        });

        p2_b_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2_col = getResources().getColor(R.color.black);
                p2_showCol.setBackgroundColor(p2_col);
            }
        });

        p2_b_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2_col = getResources().getColor(R.color.red);
                p2_showCol.setBackgroundColor(p2_col);
            }
        });

        p2_b_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2_col = getResources().getColor(R.color.blue);
                p2_showCol.setBackgroundColor(p2_col);
            }
        });

        p2_b_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2_col = getResources().getColor(R.color.green);
                p2_showCol.setBackgroundColor(p2_col);
            }
        });


        //Pick Col Button
        b_pickCol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(ChooseColor.this, MainActivity.class);
                //TODO gewählte Farbe an Mainactivity übergeben
                myIntent.putExtra("col_p1", p1_col);
                myIntent.putExtra("col_p2", p2_col);
                ChooseColor.this.startActivity(myIntent);
            }
        });




    }
}
