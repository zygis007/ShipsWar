package com.example.zygis.shipswar;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Computer {
    private ShipMemory shipMemory =ShipMemory.getI();
    private Grid grid;
    private Random random= new Random();
    private ShipSet set = new ShipSet();
    private Gridview gridview = new Gridview();
    private int [][] x;
    private int count=0;
    private TextView[][] textViews = gridview.getTextViews1();

    public int getCount() {
        return count;
    }

    public void pickShips(){
        do {
            int c= random.nextInt(10);
            int r= random.nextInt(10);
            set.setVs(true);
            grid = new Grid(r,c);


                 if(set.getPadejo()<=1){
                     set.setKeturvietis(grid);


                 }else if(set.getPadejo()>=2 && set.getPadejo()<=3){
                     set.setTrivietis(grid);

                 }else if(set.getPadejo()>3 && set.getPadejo()<=6) {
                     set.setDvivietis(grid);

                 } else if(set.getPadejo()>6 && set.getPadejo()<=10){
                     set.setVienvietis(grid);

                 }else {

                     return;
                 }
             }while (set.padejo<=10);

    }
    public void randomAtack(){
        x = shipMemory.getMyships();
            count++;
        while(true) {

            int c = random.nextInt(10);
            int r = random.nextInt(10);

            if (x[r][c] == 1) {
                textViews[r][c].setBackgroundColor(Color.BLUE);
                x[r][c] = 2;

                break;
            } else if (x[r][c] == 2) {

            } else {
                textViews[r][c].setBackgroundColor(Color.RED);
                x[r][c] = 2;

                break;
            }
        }
    }
}
