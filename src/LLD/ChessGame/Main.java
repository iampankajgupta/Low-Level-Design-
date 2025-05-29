package LLD.ChessGame;

public class Main {
    public static void main(String[] args) {
        BoardGame boardGame = new ChessGame();
        BoardGame boardGame2 = new LudoGame();
        boardGame.startGame();
    }
}
