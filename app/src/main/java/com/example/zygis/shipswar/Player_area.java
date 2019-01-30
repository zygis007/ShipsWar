package com.example.zygis.shipswar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class Player_area extends AppCompatActivity {
    Button button;

    int count=0;
    ShipMemory shipMemory = ShipMemory.getI();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_area);
        button = findViewById(R.id.bt1);
        final ShipSet tipas = new ShipSet();
        final Gridview gridview =new Gridview();
        Context context = getApplicationContext();
        GridLayout gridLayout = findViewById(R.id.grid4);
        final Computer computer = new Computer();
        final TextView textView = (TextView) findViewById(R.id.txt);
        final TextView[][] board =gridview.getTextViews();
       int numb =1;

        for(int i =0 ; i< tipas.getPadejo(); i++ ) {
            if (tipas.getPadejo() <= 1) {
                textView.setText("Padekite keturvieti: ");


            } else if (tipas.getPadejo() >= 2 && tipas.getPadejo() <= 3) {
                textView.setText("Padekite trivieti: ");


            } else if (tipas.getPadejo() > 3 && tipas.getPadejo() <= 6) {
                textView.setText("Padekite dvivieti: ");


            } else if (tipas.getPadejo() > 6 && tipas.getPadejo() <= 10) {
                textView.setText("Padekite vienvieti: ");

            } else {
                textView.setText("Laivai sudeti galite zaisti.");
                break;
            }
        }
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Grid grid = (Grid) v.getTag();




                if(tipas.getPadejo()<=1){
                    tipas.setKeturvietis(grid);


                }else if(tipas.getPadejo()>=2 && tipas.getPadejo()<=3){
                    tipas.setTrivietis(grid);


                }else if(tipas.getPadejo()>3 && tipas.getPadejo()<=6) {
                    tipas.setDvivietis(grid);


                } else if(tipas.getPadejo()>6 && tipas.getPadejo()<=10){
                    tipas.setVienvietis(grid);


                }else {
                    textView.setText("Laivai sudeti, galite zaisti");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent =new Intent(getApplicationContext(),GamePlay.class);
                            startActivity(intent);

                            computer.pickShips();
                        }
                    });
                    return;
                }
                int [][] x = shipMemory.getMyships();
                paint(x, board);

            }
        };


        gridview.grid(context,gridLayout,listener);



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        new AlertDialog.Builder(this)
                .setTitle("Ship War")
                .setMessage("Ar tikrai norite iseiti is zaidimo?")
                .setPositiveButton("Taip", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Ne", null)
                .show();
    }

    public void paint(int[][] x, TextView[][] y){
        for (int i =0; i<x.length; i++){
            for (int j = 0; j<x[i].length; j++){
                if (x[i][j]==1){
                    y[i][j].setBackgroundColor(Color.BLUE);
                }
            }
        }
    }

}


