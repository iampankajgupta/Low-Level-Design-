package LLD.ChessGame.Pieces;

import LLD.ChessGame.Cell;
import LLD.ChessGame.Move;
import LLD.ChessGame.PlayerColor;
import LLD.ChessGame.enums.Color;
import LLD.ChessGame.enums.Pieces;

public abstract class Piece {

//    Ideally, use protected so child classes (BishopPiece, PawnPiece) can access it easily.
//    Adding final means after creating a Piece, its color cannot be changed (more safe).
    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean move(Cell[][] board, Move x, Move y, PlayerColor playerColor);


    public Color getColor() {
        return this.color;
    }

    public abstract Pieces getPieceName();

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                '}';
    }
}
