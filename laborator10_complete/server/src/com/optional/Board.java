package com.optional;

public class Board {
    private Tile[][] tiles;
    private int size;

    public Board (int size){
        this.size = size;
        tiles = new Tile[size][size];
        init();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void init(){
        int i, j;

        for (i=0;i<size;i++){
            for (j=0;j<size;j++){
                tiles[i][j] = new Tile(i, j);
            }
        }
    }
}
