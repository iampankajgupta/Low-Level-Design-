package LLD.TicTacToe;

public class Grid {
    private Piece[][] grid;

    public Grid(int x, int y) {
        grid = new Piece[x][y];
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public void setGrid(Piece[][] grid) {
        this.grid = grid;
    }


}
