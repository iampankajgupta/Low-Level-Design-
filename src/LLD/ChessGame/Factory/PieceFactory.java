package LLD.ChessGame.Factory;

import LLD.ChessGame.Pieces.*;
import LLD.ChessGame.Pieces.Piece;
import LLD.ChessGame.enums.Color;
import LLD.ChessGame.enums.Pieces;


public class PieceFactory {

    public static Piece getPiece(Pieces piece, Color color) {
        if(piece.equals(Pieces.BISHOP)) {
            return new BishopPiece(color);
        }else if(piece.equals(Pieces.KING)) {
            return new KingPiece(color);
        }
        else if(piece.equals(Pieces.PAWN)) {
            return new PawnPiece(color);
        }
        else if(piece.equals(Pieces.KNIGHT)) {
            return new KnightPiece(color);
        }
        else if(piece.equals(Pieces.QUEEN)) {
            return new QueenPiece(color);
        }
        else if(piece.equals(Pieces.ROOK)) {
            return new RookPiece(color);
        }
        return new Empty(color);
    }
}
