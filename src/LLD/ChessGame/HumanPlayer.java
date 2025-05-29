package LLD.ChessGame;

import LLD.ChessGame.Pieces.Piece;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public boolean makeMove(Board board, Piece piece, Move x, Move y, PlayerColor playerColor) {
        // validate move in a board
        boolean valid = board.validate(piece, x, y, playerColor);
        if(!valid) return false;
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

}
