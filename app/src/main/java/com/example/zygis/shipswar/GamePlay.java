package com.example.zygis.shipswar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GamePlay extends AppCompatActivity {
    ShipMemory shipMemory = ShipMemory.getI();
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gr1);
        GridLayout gridLayout1 =findViewById(R.id.gr2);
        final TextView textView = findViewById(R.id.textView2);
        Gridview gridview = new Gridview();
        final Context context = getApplicationContext();
        final Computer computer = new Computer();
        final int[][] x = shipMemory.getComships();
        final int[][] y = shipMemory.getMyships();


       View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Grid grid = (Grid) v.getTag();


                textView.setText("col= "+grid.getCol()+"row = "+grid.getRow());
                boolean a = gameEnd(x);
                boolean b = gameEnd(y);;
                if(a == true||b==true) {

                    if (a == true){

                        dialog("Player won.", computer.getCount(),count);

                }else {
                        dialog("Computer won.", computer.getCount(),count);
                    }
                }else {

                    count++;

                    if (x[grid.getRow()][grid.getCol()] == 1) {
                        v.setBackgroundColor(Color.BLUE);
                        x[grid.getRow()][grid.getCol()] =2;

                    } else if (x[grid.getRow()][grid.getCol()]==0){
                        v.setBackgroundColor(Color.RED);
                        x[grid.getRow()][grid.getCol()]=2;
                    }else {

                        return;
                    }
                    v.setEnabled(false);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            v.setEnabled(true);
                            computer.randomAtack();
                        }
                    }, 1000);

                }
            }
        };
        gridview.grid(context, gridLayout,listener);
        gridview.grid(context, gridLayout1);

    }
    public boolean gameEnd(int [][] x){
        for (int i = 0 ; i<x.length;i++){
            for (int j = 0 ; j<x[i].length; j++){
                if (x[i][j]== 1){
                    return false;
                }
            }
        }
        return true;
    }
    public void dialog(String x, int counter1, int counter2){
        AlertDialog alertDialog = new AlertDialog.Builder(this)



                .setTitle("Results:")

                .setMessage(x+"\n"+"Computer moves: "+ counter1+"\n"+"Player moves: "+ counter2)


                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(1);
                    }
                })

                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        finishAffinity();
                        System.exit(0);
                    }
                })

                .show();
                TextView textView = new TextView(this);
                textView.setText(x);
    }
}
