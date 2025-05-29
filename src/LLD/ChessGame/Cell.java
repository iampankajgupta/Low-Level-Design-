package LLD.ChessGame;

import LLD.ChessGame.Pieces.Piece;

public class Cell {
    private int x;
    private int y;
    private Piece piece;

    public Cell(int x, int y, Piece piece, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
