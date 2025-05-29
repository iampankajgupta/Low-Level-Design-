package LLD.ChessGame.Pieces;

import LLD.ChessGame.Cell;
import LLD.ChessGame.Move;
import LLD.ChessGame.PlayerColor;
import LLD.ChessGame.enums.Color;
import LLD.ChessGame.enums.Pieces;

public class QueenPiece extends Piece{

    public QueenPiece(Color color) {
        super(color);
    }

    @Override
    public boolean move(Cell[][] board, Move x, Move y, PlayerColor playerColor) {
        return false;
    }

    @Override
    public Pieces getPieceName() {
        return Pieces.QUEEN;
    }
}
