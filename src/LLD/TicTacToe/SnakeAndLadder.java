package LLD.TicTacToe;

public class SnakeAndLadder implements BoardGame{
    private Grid grid;

    public SnakeAndLadder(int x, int y) {
        grid = new Grid(x, y);
       initialise(grid);
    }

    @Override
    public void startGame() {

    }

    @Override
    public void initialise(Grid grid) {
        for(int i = 0; i<grid.getGrid().length; i++) {
            for(int j = 0; j<grid.getGrid().length; j++) {
                grid.getGrid()[i][j] = Piece.EMPTY;
            }
        }
    }
}
