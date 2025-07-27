package LLD.TicTacToe;

public class PlayerImpl implements IPlayer{
    @Override
    public boolean move(int x, int y, Grid grid, Piece piece) {

        grid.getGrid()[x][y] = piece;
        return true;
    }
}
