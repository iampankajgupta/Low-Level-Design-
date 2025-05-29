package LLD.ChessGame.Pieces;

import LLD.ChessGame.Cell;
import LLD.ChessGame.Factory.PieceFactory;
import LLD.ChessGame.Move;
import LLD.ChessGame.PlayerColor;
import LLD.ChessGame.enums.Color;
import LLD.ChessGame.enums.Pieces;

public class BishopPiece extends Piece {
    @Override
    public boolean move(Cell[][] board, Move x, Move y, PlayerColor playerColor) {

        int i = x.getX();
        int j = x.getY();
        int a = y.getX();
        int b = y.getY();

        boolean first = false;
        boolean second = false;
        boolean third = false;

        int k = i;
        int l = j;

        while(k<=board.length-1 && l<=board.length-1 && k>=0 && l>=0 && k<=a && l<=b) {
            if(!board[k][l].getPiece().getClass().equals(Empty.class) && !board[k][l].getPiece().getColor().equals(playerColor.getColor())) {
                board[k][l].setPiece(PieceFactory.getPiece(Pieces.BISHOP, playerColor.getColor()));
                first = true;
                break;
            }else if(!board[k][l].getPiece().getClass().equals(Empty.class) && board[k][l].getPiece().getColor().equals(playerColor.getColor())) {
                break;
            }
            k++;l++;

        }
        k = i;
        l = j;

        while(!first && k>=0 && l>=0 && k<=board.length-1 && l<=board.length-1 && k<=a && l<=b) {
            if(!board[k][l].getPiece().getClass().equals(Empty.class) && !board[k][l].getPiece().getColor().equals(playerColor.getColor())) {
                board[k][l].setPiece(PieceFactory.getPiece(Pieces.BISHOP, playerColor.getColor()));
                second = true;
                break;
            }
            k++;l--;
        }


        k = i;
        l = j;

        while(!first && !second && k>=0 && l>=0 && k<=board.length-1 && l<=board.length-1 && k<=a && l<=b) {
            if(!board[k][l].getPiece().getClass().equals(Empty.class) && !board[k][l].getPiece().getColor().equals(playerColor.getColor())) {
                board[k][l].setPiece(PieceFactory.getPiece(Pieces.BISHOP, playerColor.getColor()));
                third = true;
                break;
            }
            k--;l--;
        }

        k = i;
        l = j;

        while(!first && !second && !third && k>=0 && l>=0 && k<=board.length-1 && l<=board.length-1 && k<=a && l<=b) {
            if(!board[k][l].getPiece().getClass().equals(Empty.class) && !board[k][l].getPiece().getColor().equals(playerColor.getColor())) {
                board[k][l].setPiece(PieceFactory.getPiece(Pieces.BISHOP, playerColor.getColor()));
                break;
            }
            k--;l++;
        }

        return first || second || third;

    }

    @Override
    public Pieces getPieceName() {
        return Pieces.BISHOP;
    }

    public BishopPiece(Color color) {
        super(color);
    }
}
