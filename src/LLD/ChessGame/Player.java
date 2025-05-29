package LLD.ChessGame;

import LLD.ChessGame.Pieces.Piece;

public abstract class Player {

//    Ideally, use protected so child classes (Human, AI) can access it easily.
//    Adding final means after creating a Piece, its color cannot be changed (more safe).
    protected final String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract boolean makeMove(Board board, Piece piece, Move x, Move y, PlayerColor playerColor);
    public String getName(){
        return this.name;
    }
}
