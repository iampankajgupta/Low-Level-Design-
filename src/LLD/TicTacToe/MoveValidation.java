package LLD.TicTacToe;

public class MoveValidation {

    public static boolean validateMove(Grid grid, int x, int y, Piece piece) {
        if(x < 0 || y < 0 || x>grid.getGrid().length || y>= grid.getGrid().length) return false;
        if(!grid.getGrid()[x][y].equals(Piece.EMPTY)) return false;
        return true;
    }

}
