package LLD.ChessGame;

import LLD.ChessGame.Pieces.Piece;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    @Override
    public boolean makeMove(Board board, Piece piece, Move x, Move y, PlayerColor playerColor) {
        return false;
    }

    @Override
    public String getName() {
        return "AI";
    }
}
