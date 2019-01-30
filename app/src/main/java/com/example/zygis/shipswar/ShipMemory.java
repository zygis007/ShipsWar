package com.example.zygis.shipswar;

public class ShipMemory {
    private int[][] myships =null;
    private int[][] comships=null;
    public static ShipMemory i;
    public static ShipMemory getI() {
        if(i ==null)
            i=new ShipMemory();
            return i;


    }

    public int[][] getMyships() {
        return myships;
    }
    private ShipMemory(){
        myships= new int[10][10];
        comships =new int[10][10];

    }
    public void setMyships(int row, int col, int x) {

        this.myships[row][col]=x;
    }
    public void setComships(int[][] comships){
        this.comships =comships;
    }

    public void setMyships(int[][] myships) {
        this.myships = myships;
    }

    public int check(int row, int col){
        return comships[row][col];
    }
    public int[][] getComships() {
        return comships;
    }

    public void setComships(int row, int col) {
        this.comships = comships;
    }
}
