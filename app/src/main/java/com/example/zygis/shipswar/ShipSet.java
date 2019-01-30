package com.example.zygis.shipswar;

import android.widget.Switch;

public class ShipSet {


    Laivai vienvietis;
    Laivai dvivietis;
    Laivai trivietis;
    Laivai keturvietis;
    int padejo=1;
    private boolean vs;

    ShipMemory shipMemory =ShipMemory.getI();
    int[][] x =new int[10][10];
    private void space(int[][] x){
        if (vs){
            shipMemory.setComships(x);
        }else{
            shipMemory.setMyships(x);
        }
    }



    public void setVs(boolean vs) {
        this.vs = vs;
    }

    public int getPadejo() {
        return padejo;
    }
    public void setVienvietis(Grid grid){
        vienvietis = new Laivai(grid,1);
        checkSpace(vienvietis);
        space(x);
    }
    public void setDvivietis(Grid grid){
        dvivietis = new Laivai(grid,2);
        checkSpace(dvivietis);
        space(x);
    }
    public void setTrivietis(Grid grid){
        trivietis = new Laivai(grid,3);
        checkSpace(trivietis);

        space(x);

    }
    public void setKeturvietis(Grid grid){
        keturvietis = new Laivai(grid,4);
        checkSpace(keturvietis);

        space(x);
    }


    public int[][] getX() {
        return x;
    }


    public void checkSpace(Laivai laivai){

        int col =laivai.grid.getCol();
        int row = laivai.grid.getRow();
        try {
            switch (laivai.dydis) {

                case 1:
                    if (col == 0 && x[row][col] == 0 && x[row][col + 1] == 0 ||
                            col == 9 && x[row][col] == 0 && x[row][col - 1] == 0 || x[row][col] == 0 && x[row][col + 1] == 0 && x[row][col - 1] == 0) {
                        if (row == 0 && x[row + 1][col] == 0 || row == 9 && x[row - 1][col] == 0 || x[row + 1][col] == 0 && x[row - 1][col] == 0) {
                            x[row][col] = 1;
                            padejo++;
                        }

                    }
                    break;
                case 2:
                    if (
                            row ==9 && col==9 && x[row][col]==0 && x[row - 1][col]==0&& x[row][col -2]==0&& x[row - 1][col-1]==0&& x[row][col -1]==0 && x[row-1][col-2]==0
                            ||row==0&&col == 9 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col -2]==0&& x[row + 1][col-1]==0&& x[row][col -1]==0&& x[row+1][col-2]==0
                            ||row == 0 && col !=9 && col != 0 && col!=1 && x[row][col]==0 && x[row + 1][col]==0 && x[row][col+1]==0 && x[row + 1][col-1]==0 && x[row][col-2]==0&& x[row][col-1]==0 && x[row+1][col+1]==0&& x[row+1][col-2]==0||
                            row == 9 && col !=9 && col != 0 && col !=1 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 1][col - 1] ==0 && x[row][col+1]==0&& x[row][col-1]==0&& x[row][col-2]==0&& x[row-1][col+1]==0&& x[row-1][col-2]==0||
                            col ==9 && row !=9 && row !=0 && x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col - 1]==0 && x[row][col -2]==0&& x[row - 1][col-1]==0 && x[row + 1][col-1]==0 && x[row+1][col-2]==0 && x[row-1][col-2]==0||
                            col !=9 && col != 0 && row!=0 &&row!=9 && col!=1 && x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0 && x[row][col - 1]==0 && x[row][col -2]==0&& x[row - 1][col-1]==0
                                    && x[row + 1][col-1]==0 && x[row+1][col-2]==0 && x[row-1][col-2]==0 && x[row+1][col+1]==0 && x[row-1][col+1]==0
                            ||row == 9&&col == 1&& x[row][col]==0 && x[row -1][col]==0&& x[row][col -1]==0&& x[row - 1][col-1]==0&& x[row][col +1]==0 && x[row-1][col+1]==0
                            ||row == 0&&col == 1&& x[row][col]==0 && x[row +1][col]==0&& x[row][col -1]==0&& x[row + 1][col-1]==0&& x[row][col +1]==0 && x[row+1][col+1]==0
                            ||col == 1 && row!=0 && row!=9 && x[row][col]==0 && x[row +1][col]==0&& x[row -1][col]==0&& x[row][col -1]==0&& x[row + 1][col-1]==0&& x[row - 1][col-1]==0&& x[row][col +1]==0 && x[row-1][col+1]==0 && x[row+1][col+1]==0) {
                        x[row][col - 1] = 1;
                        x[row][col] = 1;
                        padejo++;
                    }else if(col==0 && row !=0 && row !=9 &&x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0  && x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row + 1][col+1]==0 && x[row+1][col+2]==0 && x[row-1][col+2]==0
                            ||row == 0 && col == 0 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col +2]==0&& x[row + 1][col+1]==0&& x[row][col +1]==0 && x[row+1][col + 2]==0
                            ||row == 9&&col == 0&& x[row][col]==0 && x[row -1][col]==0&& x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row][col +1]==0 && x[row-1][col + 2]==0
                            ){
                        x[row][col + 1] = 1;
                        x[row][col] = 1;
                        padejo++;



                    } else if (row ==0 && col==9 && x[row][col]==0 && x[row][col-1]==0 && x[row+1][col-1]==0&& x[row+1][col]==0 && x[row+2][col]==0 && x[row+2][col-1]==0
                            ||row ==0 && col==0 && x[row][col]==0 && x[row][col+1]==0 && x[row+1][col+1]==0&& x[row+1][col]==0 && x[row+2][col]==0 && x[row+2][col+1]==0
                            ||col == 0 && row!=0 && row!=9 && x[row][col] ==0 && x[row][col + 1]==0  && x[row + 1][col + 1]==0 && x[row+1][col] ==0 && x[row-1][col] ==0 && x[row+2][col] ==0 && x[row-1][col+1]==0 && x[row+2][col+1]==0
                            ||col == 9 && row!=0 && row!=9 && x[row][col] ==0 && x[row][col - 1]==0  && x[row + 1][col -1]==0 && x[row+1][col] ==0 && x[row-1][col] ==0 && x[row+2][col] ==0 && x[row-1][col-1]==0 && x[row+2][col-1]==0
                            ||row!=8 && col!=9 && col!=0 && row!=0 && row!=9 && x[row][col + 1]==0 && x[row][col - 1]==0 && x[row + 1][col + 1]==0 && x[row + 1][col - 1]==0
                            && x[row][col] ==0 && x[row-1][col] ==0 && x[row+2][col] ==0&& x[row+1][col] ==0 && x[row+2][col+1]==0 && x[row+2][col-1]==0 && x[row-1][col-1]==0 && x[row-1][col+1]==0
                            ||row ==0 && col!=0 && col!=9 && x[row][col] ==0 && x[row+1][col] ==0 && x[row+2][col] ==0 && x[row][col+1] ==0 && x[row][col-1] ==0 && x[row+1][col+1] ==0 && x[row+1][col-1] ==0 && x[row+2][col+1]==0 && x[row+2][col-1]==0
                            ||col==9 && row==8 && x[row][col]==0 && x[row + 1][col]==0 && x[row][col-1]==0 && x[row+1][col]==0 && x[row+1][col-1]==0 && x[row-1][col]==0 && x[row-1][col-1]==0
                            ||col ==0 && row==8 && x[row][col]==0 && x[row + 1][col]==0 && x[row][col+1]==0 && x[row+1][col]==0 && x[row+1][col+1]==0 && x[row-1][col]==0 && x[row-1][col+1]==0
                            ||row == 8 && col!=0 && col!=9 && x[row][col]==0 && x[row + 1][col]==0  && x[row][col-1]==0 && x[row][col+1]==0 && x[row+1][col+1]==0 && x[row+1][col-1]==0 && x[row-1][col]==0&& x[row-1][col+1]==0&& x[row-1][col-1]==0) {

                            x[row + 1][col] = 1;
                            x[row][col] = 1;
                            padejo++;
                        } else if (
                                row ==9 && col==0 && x[row][col]==0 && x[row][col+1]==0 && x[row-1][col+1]==0&& x[row-1][col]==0 && x[row-2][col]==0 && x[row-2][col+1]==0
                                ||row ==9 && col==9 && x[row][col]==0 && x[row][col-1]==0 && x[row-1][col-1]==0&& x[row-1][col]==0 && x[row-2][col]==0 && x[row-2][col-1]==0
                                ||row == 9 && col!=0 && col!=9 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 2][col]==0 && x[row][col+1]==0 && x[row][col-1]==0&& x[row-1][col-1]==0 && x[row-1][col+1]==0 && x[row-2][col+1]==0 && x[row-2][col-1]==0) {
                            x[row - 1][col] = 1;
                            x[row][col] = 1;
                            padejo++;
                        }

                    break;
                case 3:

                    if (
                            row ==9 && col==9 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 1][col-2]==0 && x[row][col -3]==0 && x[row-1][col -3]==0 && x[row - 1][col-1]==0 && x[row][col -1]==0 && x[row][col -2]==0
                                    ||row==0&&col == 9 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col -2]==0 && x[row][col -3]==0 && x[row + 1][col-1]==0&& x[row][col -1]==0&& x[row+1][col-2]==0&& x[row+1][col-3]==0
                                    ||row == 0 && col !=9 && col != 0 && col!=1 && col!=2&& x[row][col]==0 && x[row + 1][col]==0 && x[row][col+1]==0 && x[row + 1][col-1]==0 && x[row][col-2]==0
                                    && x[row][col-1]==0 && x[row+1][col+1]==0&& x[row+1][col-2]==0 && x[row+1][col-3]==0&& x[row][col-3]==0||
                                    row == 9 && col !=9 && col != 0 && col !=1 && col!=2 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 1][col - 1] ==0 && x[row][col+1]==0&& x[row][col-1]==0&& x[row][col-2]==0
                                            && x[row-1][col+1]==0&& x[row-1][col-2]==0 && x[row][col-3]==0 && x[row-1][col-3]==0||
                                    col ==9 && row !=9 && row !=0 && x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col - 1]==0 && x[row][col -2]==0&& x[row - 1][col-1]==0
                                            && x[row + 1][col-1]==0 && x[row+1][col-2]==0 && x[row-1][col-2]==0  && x[row+1][col-3]==0&& x[row-1][col-3]==0&& x[row][col-3]==0||
                                    col !=9 && col != 0 && row!=0 &&row!=9 && col!=1 && col!=2&& x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0 && x[row][col - 1]==0 && x[row][col -2]==0&& x[row - 1][col-1]==0
                                            && x[row + 1][col-1]==0 && x[row+1][col-2]==0 && x[row-1][col-2]==0 && x[row+1][col+1]==0 && x[row-1][col+1]==0 && x[row+1][col-3]==0&& x[row-1][col-3]==0&& x[row][col-3]==0
                                    ||row == 9&&col == 2&& x[row][col]==0 && x[row -1][col]==0&& x[row][col -1]==0&& x[row - 1][col-1]==0&& x[row][col +1]==0 && x[row-1][col+1]==0 && x[row][col-2]==0 && x[row-1][col-2]==0
                                    ||row == 0&&col == 2&& x[row][col]==0 && x[row +1][col]==0&& x[row][col -1]==0&& x[row + 1][col-1]==0&& x[row][col +1]==0 && x[row+1][col+1]==0 && x[row][col-2]==0 && x[row+1][col-2]==0
                                    ||col == 2 && row!=0 && row!=9 && x[row][col]==0 && x[row +1][col]==0&& x[row -1][col]==0&& x[row][col -1]==0&& x[row + 1][col-1]==0
                                    && x[row - 1][col-1]==0&& x[row][col +1]==0 && x[row-1][col+1]==0 && x[row+1][col+1]==0 && x[row][col-2]==0 && x[row-1][col-2]==0&& x[row+1][col-2]==0) {
                        x[row][col - 2] = 1;
                        x[row][col - 1] = 1;
                        x[row][col] = 1;
                        padejo++;
                    }else if(col==0 && row !=0 && row !=9 &&x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0
                            && x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row + 1][col+1]==0 && x[row+1][col+2]==0 && x[row-1][col+2]==0 && x[row+1][col+3]==0 && x[row-1][col+3]==0 && x[row][col+3]==0
                            ||row == 0 && col == 0 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col +2]==0&& x[row + 1][col+1]==0&& x[row][col +1]==0 && x[row+1][col + 2]==0 && x[row][col+3]==0 && x[row+1][col+3]==0
                            ||row == 9&&col == 0&& x[row][col]==0 && x[row -1][col]==0&& x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row][col +1]==0 && x[row-1][col + 2]==0 && x[row][col+3]==0 && x[row-1][col+3]==0
                            || col==1 && row==0 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col +2]==0&& x[row + 1][col+1]==0&& x[row][col +1]==0 && x[row+1][col + 2]==0 && x[row][col+3]==0 && x[row+1][col+3]==0 && x[row][col-1]==0 && x[row+1][col-1]==0
                            || col ==1 && row==9&& x[row][col]==0 && x[row -1][col]==0&& x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row][col +1]==0 && x[row-1][col + 2]==0 && x[row][col+3]==0 && x[row-1][col+3]==0 && x[row][col-1]==0 && x[row-1][col-1]==0
                            ||col ==1 && row!=0 && row!=9 &&x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0
                            && x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row + 1][col+1]==0 && x[row+1][col+2]==0 && x[row-1][col+2]==0 && x[row+1][col+3]==0 && x[row-1][col+3]==0 && x[row][col+3]==0 &&x[row][col-1]==0 &&x[row-1][col-1]==0 &&x[row+1][col-1]==0
                    ){
                        x[row][col + 2] = 1;
                        x[row][col + 1] = 1;
                        x[row][col] = 1;
                        padejo++;



                    } else if (row ==0 && col==9 && x[row][col]==0 && x[row][col-1]==0 && x[row+1][col-1]==0&& x[row+1][col]==0 && x[row+2][col]==0 && x[row+2][col-1]==0
                            ||row ==0 && col==0 && x[row][col]==0 && x[row][col+1]==0 && x[row+1][col+1]==0&& x[row+1][col]==0 && x[row+2][col]==0 && x[row+2][col+1]==0
                            ||col == 0 && row!=0 && row!=9 && x[row][col] ==0 && x[row][col + 1]==0  && x[row + 1][col + 1]==0 && x[row+1][col] ==0 && x[row-1][col] ==0 && x[row+2][col] ==0 && x[row-1][col+1]==0 && x[row+2][col+1]==0
                            ||col == 9 && row!=0 && row!=9 && x[row][col] ==0 && x[row][col - 1]==0  && x[row + 1][col -1]==0 && x[row+1][col] ==0 && x[row-1][col] ==0 && x[row+2][col] ==0 && x[row-1][col-1]==0 && x[row+2][col-1]==0
                            ||row!=8 && col!=9 && col!=0 && row!=0 && row!=9 && x[row][col + 1]==0 && x[row][col - 1]==0 && x[row + 1][col + 1]==0 && x[row + 1][col - 1]==0
                            && x[row][col] ==0 && x[row-1][col] ==0 && x[row+2][col] ==0&& x[row+1][col] ==0 && x[row+2][col+1]==0 && x[row+2][col-1]==0 && x[row-1][col-1]==0 && x[row-1][col+1]==0
                            ||row ==0 && col!=0 && col!=9 && x[row][col] ==0 && x[row+1][col] ==0 && x[row+2][col] ==0 && x[row][col+1] ==0 && x[row][col-1] ==0 && x[row+1][col+1] ==0 && x[row+1][col-1] ==0 && x[row+2][col+1]==0 && x[row+2][col-1]==0
                            ||col==9 && row==8 && x[row][col]==0 && x[row + 1][col]==0 && x[row][col-1]==0 && x[row+1][col]==0 && x[row+1][col-1]==0 && x[row-1][col]==0 && x[row-1][col-1]==0
                            ||col ==0 && row==8 && x[row][col]==0 && x[row + 1][col]==0 && x[row][col+1]==0 && x[row+1][col]==0 && x[row+1][col+1]==0 && x[row-1][col]==0 && x[row-1][col+1]==0
                            ||row == 8 && col!=0 && col!=9 && x[row][col]==0 && x[row + 1][col]==0  && x[row][col-1]==0 && x[row][col+1]==0 && x[row+1][col+1]==0 && x[row+1][col-1]==0 && x[row-1][col]==0&& x[row-1][col+1]==0&& x[row-1][col-1]==0) {
                        x[row + 2][col] = 1;
                        x[row + 1][col] = 1;
                        x[row][col] = 1;
                        padejo++;
                    } else if (
                            row ==9 && col==0 && x[row][col]==0 && x[row][col+1]==0 && x[row-1][col+1]==0&& x[row-1][col]==0 && x[row-2][col]==0 && x[row-2][col+1]==0
                                    ||row ==9 && col==9 && x[row][col]==0 && x[row][col-1]==0 && x[row-1][col-1]==0&& x[row-1][col]==0 && x[row-2][col]==0 && x[row-2][col-1]==0
                                    ||row == 9 && col!=0 && col!=9 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 2][col]==0 && x[row][col+1]==0 && x[row][col-1]==0&& x[row-1][col-1]==0 && x[row-1][col+1]==0 && x[row-2][col+1]==0 && x[row-2][col-1]==0) {
                        x[row - 2][col] = 1;
                        x[row - 1][col] = 1;
                        x[row][col] = 1;
                        padejo++;
                    }
                    break;
                case 4:
                    if (
                            row ==9 && col==9 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 1][col-2]==0 && x[row][col -3]==0 && x[row-1][col -3]==0 && x[row - 1][col-1]==0 && x[row][col -1]==0 && x[row][col -2]==0
                                    ||row==0&&col == 9 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col -2]==0 && x[row][col -3]==0 && x[row + 1][col-1]==0&& x[row][col -1]==0&& x[row+1][col-2]==0&& x[row+1][col-3]==0
                                    ||row == 0 && col !=9 && col != 0 && col!=1 && col!=2&& x[row][col]==0 && x[row + 1][col]==0 && x[row][col+1]==0 && x[row + 1][col-1]==0 && x[row][col-2]==0
                                    && x[row][col-1]==0 && x[row+1][col+1]==0&& x[row+1][col-2]==0 && x[row+1][col-3]==0&& x[row][col-3]==0||
                                    row == 9 && col !=9 && col != 0 && col !=1 && col!=2 && x[row][col]==0 && x[row - 1][col]==0 && x[row - 1][col - 1] ==0 && x[row][col+1]==0&& x[row][col-1]==0&& x[row][col-2]==0
                                            && x[row-1][col+1]==0&& x[row-1][col-2]==0 && x[row][col-3]==0 && x[row-1][col-3]==0||
                                    col ==9 && row !=9 && row !=0 && x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col - 1]==0 && x[row][col -2]==0&& x[row - 1][col-1]==0
                                            && x[row + 1][col-1]==0 && x[row+1][col-2]==0 && x[row-1][col-2]==0  && x[row+1][col-3]==0&& x[row-1][col-3]==0&& x[row][col-3]==0||
                                    col !=9 && col != 0 && row!=0 &&row!=9 && col!=1 && col!=2&& x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0 && x[row][col - 1]==0 && x[row][col -2]==0&& x[row - 1][col-1]==0
                                            && x[row + 1][col-1]==0 && x[row+1][col-2]==0 && x[row-1][col-2]==0 && x[row+1][col+1]==0 && x[row-1][col+1]==0 && x[row+1][col-3]==0&& x[row-1][col-3]==0&& x[row][col-3]==0
                                    ||row == 9&&col == 2&& x[row][col]==0 && x[row -1][col]==0&& x[row][col -1]==0&& x[row - 1][col-1]==0&& x[row][col +1]==0 && x[row-1][col+1]==0 && x[row][col-2]==0 && x[row-1][col-2]==0
                                    ||row == 0&&col == 2&& x[row][col]==0 && x[row +1][col]==0&& x[row][col -1]==0&& x[row + 1][col-1]==0&& x[row][col +1]==0 && x[row+1][col+1]==0 && x[row][col-2]==0 && x[row+1][col-2]==0
                                    ||col == 3 && row!=0 && row!=9 && x[row][col]==0 && x[row +1][col]==0&& x[row -1][col]==0&& x[row][col -1]==0&& x[row + 1][col-1]==0
                                    && x[row - 1][col-1]==0&& x[row][col +1]==0 && x[row-1][col+1]==0 && x[row+1][col+1]==0 && x[row][col-2]==0 && x[row-1][col-2]==0&& x[row+1][col-2]==0) {
                        x[row][col - 3] = 1;
                        x[row][col - 2] = 1;
                        x[row][col - 1] = 1;
                        x[row][col] = 1;
                        padejo++;
                    }else if(col==0 && row !=0 && row !=9 &&x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0
                            && x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row + 1][col+1]==0 && x[row+1][col+2]==0 && x[row-1][col+2]==0 && x[row+1][col+3]==0 && x[row-1][col+3]==0 && x[row][col+3]==0
                            ||row == 0 && col == 0 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col +2]==0&& x[row + 1][col+1]==0&& x[row][col +1]==0 && x[row+1][col + 2]==0 && x[row][col+3]==0 && x[row+1][col+3]==0
                            ||row == 9&&col == 0&& x[row][col]==0 && x[row -1][col]==0&& x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row][col +1]==0 && x[row-1][col + 2]==0 && x[row][col+3]==0 && x[row-1][col+3]==0
                            || col==1 && row==0 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col +2]==0&& x[row + 1][col+1]==0&& x[row][col +1]==0 && x[row+1][col + 2]==0 && x[row][col+3]==0 && x[row+1][col+3]==0 && x[row][col-1]==0 && x[row+1][col-1]==0
                            || col ==1 && row==9&& x[row][col]==0 && x[row -1][col]==0&& x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row][col +1]==0 && x[row-1][col + 2]==0 && x[row][col+3]==0 && x[row-1][col+3]==0 && x[row][col-1]==0 && x[row-1][col-1]==0
                            ||col ==1 && row!=0 && row!=9 &&x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0
                            && x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row + 1][col+1]==0 && x[row+1][col+2]==0 && x[row-1][col+2]==0 && x[row+1][col+3]==0 && x[row-1][col+3]==0 && x[row][col+3]==0 &&x[row][col-1]==0 &&x[row-1][col-1]==0 &&x[row+1][col-1]==0
                            || col==2 && row==0 && x[row][col]==0 && x[row + 1][col]==0&& x[row][col +2]==0&& x[row + 1][col+1]==0&& x[row][col +1]==0 && x[row+1][col + 2]==0 && x[row][col+3]==0 && x[row+1][col+3]==0 && x[row][col-1]==0 && x[row+1][col-1]==0
                            || col ==2 && row==9&& x[row][col]==0 && x[row -1][col]==0&& x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row][col +1]==0 && x[row-1][col + 2]==0 && x[row][col+3]==0 && x[row-1][col+3]==0 && x[row][col-1]==0 && x[row-1][col-1]==0
                            ||col ==2 && row!=0 && row!=9 &&x[row][col]==0 && x[row - 1][col]==0 && x[row + 1][col]==0 && x[row][col + 1]==0
                            && x[row][col +2]==0&& x[row - 1][col+1]==0&& x[row + 1][col+1]==0 && x[row+1][col+2]==0 && x[row-1][col+2]==0 && x[row+1][col+3]==0 && x[row-1][col+3]==0 && x[row][col+3]==0 &&x[row][col-1]==0 &&x[row-1][col-1]==0 &&x[row+1][col-1]==0

                    ){
                        x[row][col + 3] = 1;
                        x[row][col + 2] = 1;
                        x[row][col + 1] = 1;
                        x[row][col] = 1;
                        padejo++;



                    }
                    break;

            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("uz ribu"+e.getMessage());
        }
    }
}
