package com.example.florian.magicapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //General
    private Button resetButton;
    private ImageView dice_p1;
    private ImageView dice_p2;

    private Button rollDice;
    final private int[] diceArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    private boolean diceRolled = false;

    private Button chooseColor;

    //Player1
    private Button plusButton_p1;
    private Button minusButton_p1;
    private TextView hitpoints_p1;
    private int hp1 = 20;
    private RelativeLayout layout_p1;

    //Player2
    private Button plusButton_p2;
    private Button minusButton_p2;
    private TextView hitpoints_p2;
    private int hp2 = 20;
    private RelativeLayout layout_p2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //General Options
        resetButton = findViewById(R.id.resetLife);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetLife();
            }
        });

        //Dice
        rollDice = findViewById(R.id.dice_button);

        dice_p1 = findViewById(R.id.dice_p1);
        dice_p2 = findViewById(R.id.dice_p2);

        dice_p1.setVisibility(View.INVISIBLE);
        dice_p2.setVisibility(View.INVISIBLE);

        //Roll dice Button

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        //Choose Color
        chooseColor = findViewById(R.id.color);

        chooseColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ChooseColor.class);
                MainActivity.this.startActivity(myIntent);
            }
        });


        //Layouts
        layout_p1 = findViewById(R.id.layout_p1);
        layout_p2 = findViewById(R.id.layout_p2);


        //################
        //### Player 1 ###
        //################

        plusButton_p1 = findViewById(R.id.player1_plus);
        minusButton_p1 = findViewById(R.id.player1_minus);
        hitpoints_p1 = findViewById(R.id.hitpointsPlayer1);

        //Set color of Hitpoits score
        hitpoints_p1.setTextColor(Color.DKGRAY);

        hitpoints_p1.setText(String.valueOf(hp1));      //Setzt den HP Textview auf 20 Leben
        
        plusButton_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp1 = hp1+1;
                hitpoints_p1.setText(String.valueOf(hp1));      //Sets the hp-Score to the new Value
                hpColor(hp1, hitpoints_p1);                     //Colors the hp-score red, when hp<=0
            }
        });

        minusButton_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp1 = hp1-1;
                hitpoints_p1.setText(String.valueOf(hp1));
                hpColor(hp1, hitpoints_p1);
            }
        });

        //################
        //### Player 2 ###
        //################


        plusButton_p2 = findViewById(R.id.player2_plus);
        minusButton_p2 = findViewById(R.id.player2_minus);
        hitpoints_p2 = findViewById(R.id.hitpointsPlayer2);

        hitpoints_p2.setText(String.valueOf(hp2));      //Setzt den HP Textview auf 20 Leben

        //Set color of Hitpoits score
        hitpoints_p2.setTextColor(Color.DKGRAY);

        plusButton_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp2 = hp2+1;
                hitpoints_p2.setText(String.valueOf(hp2));
                hpColor(hp2, hitpoints_p2);
            }
        });

        minusButton_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp2 = hp2-1;
                hitpoints_p2.setText(String.valueOf(hp2));
                hpColor(hp2, hitpoints_p2);
            }
        });
        
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        layout_p1.setBackgroundColor(intent.getIntExtra("col_p1", 0));
        layout_p2.setBackgroundColor(intent.getIntExtra("col_p2", 0));
    }

    private void rollDice() {

        if (diceRolled == false){
            dice_p1.setVisibility(View.VISIBLE);
            dice_p2.setVisibility(View.VISIBLE);

            Random numbergen = new Random();

            int roll_p1 = numbergen.nextInt(6);
            int roll_p2 = numbergen.nextInt(6);

            dice_p1.setImageResource(diceArray[roll_p1]);
            dice_p2.setImageResource(diceArray[roll_p2]);

            Log.v("p1", String.valueOf(roll_p1));
            Log.v("p2", String.valueOf(roll_p2));

            rollDice.setText(R.string.remove_the_dice);
            diceRolled = true;
        }else {
            dice_p1.setVisibility(View.INVISIBLE);
            dice_p2.setVisibility(View.INVISIBLE);

            rollDice.setText(R.string.roll_the_dice);
            diceRolled = false;
        }





    }

    private void resetLife() {
        hp1 = 20;
        hp2 = 20;
        hitpoints_p1.setText(String.valueOf(hp1));
        hitpoints_p2.setText(String.valueOf(hp2));
        hpColor(hp1, hitpoints_p1);
        hpColor(hp2, hitpoints_p2);
    }

    private void hpColor(int hp, TextView hitpoints){
        if (hp<=0){
            hitpoints.setTextColor(Color.RED);
        }else{
            hitpoints.setTextColor(Color.DKGRAY);
        }
    }

}
