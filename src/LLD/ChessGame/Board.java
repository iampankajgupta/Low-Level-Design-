    package LLD.ChessGame;

    import LLD.ChessGame.Factory.PieceFactory;
    import LLD.ChessGame.Pieces.*;
    import LLD.ChessGame.Pieces.Piece;
    import LLD.ChessGame.enums.Color;
    import LLD.ChessGame.enums.Pieces;

    public class Board {
        private Cell[][] board;

        public Board() {
                board = new Cell[8][8];
                createCellOnBoard();
                placePiecesInBoard();
        }

        private void placePiecesInBoard() {
            setPawns();
            setRooks();
            setBishop();
            setKnights();
            setKing();
            setQueen();
        }

        private void setQueen() {
            board[0][3].setPiece(PieceFactory.getPiece(Pieces.QUEEN, Color.BLACK));
            board[board.length-1][3].setPiece(PieceFactory.getPiece(Pieces.QUEEN, Color.WHITE));
        }

        private void setKing() {
            board[0][4].setPiece(PieceFactory.getPiece(Pieces.KING, Color.BLACK));
            board[board.length-1][4].setPiece(PieceFactory.getPiece(Pieces.KING, Color.WHITE));
        }

        private void setKnights() {
            board[0][1].setPiece(PieceFactory.getPiece(Pieces.KNIGHT, Color.BLACK));
            board[0][board.length-2].setPiece(PieceFactory.getPiece(Pieces.KNIGHT, Color.BLACK));

            board[board.length-1][1].setPiece(PieceFactory.getPiece(Pieces.KNIGHT, Color.WHITE));
            board[board.length-1][board.length-2].setPiece(PieceFactory.getPiece(Pieces.KNIGHT, Color.WHITE));
        }

        private void setBishop() {
            board[0][2].setPiece(PieceFactory.getPiece(Pieces.BISHOP, Color.BLACK));
            board[0][board.length-3].setPiece(PieceFactory.getPiece(Pieces.BISHOP, Color.BLACK));

            board[board.length-1][2].setPiece(PieceFactory.getPiece(Pieces.BISHOP, Color.WHITE));
            board[board.length-1][board.length-3].setPiece(PieceFactory.getPiece(Pieces.BISHOP, Color.WHITE));
        }

        private void setRooks() {
            board[0][0].setPiece(PieceFactory.getPiece(Pieces.ROOK, Color.BLACK));
            board[0][7].setPiece(PieceFactory.getPiece(Pieces.ROOK, Color.BLACK));
            board[7][0].setPiece(PieceFactory.getPiece(Pieces.ROOK, Color.WHITE));
            board[7][7].setPiece(PieceFactory.getPiece(Pieces.ROOK, Color.WHITE));
        }

        private void createCellOnBoard() {
            Color color = Color.WHITE;
            for(int i = 0; i<board.length; i++) {
                for(int j = 0; j<board.length; j++) {
                    if(i == 1) {
                        // set Piece as well
                    }
                    if( i == 6) {

                    }
                    board[i][j] = new Cell(i,j,PieceFactory.getPiece(Pieces.EMPT, color), color.equals(Color.WHITE));
                    color = color.equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
                }
                color = color.equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
            }
        }

        private void setPawns() {
            for(int i = 0; i<board.length; i++) {
                board[1][i].setPiece(PieceFactory.getPiece(Pieces.PAWN, Color.BLACK));
            }
            for(int i = 0; i<board.length; i++) {
                board[board.length-2][i].setPiece(PieceFactory.getPiece(Pieces.PAWN, Color.WHITE));
            }
        }

    //    similarly will other pieces
        public boolean validate(Piece piece, Move x, Move y, PlayerColor playerColor) {
            return !piece.move(board, x, y, playerColor);
        }


        public boolean outOfBoardMove(Move move) {
            return move.getX() < 0 || move.getX() > board.length - 1 || move.getY() > board.length - 1 || move.getY() < 0;
        }

        public Piece getPiece(Move currPos) {
            return board[currPos.getX()][currPos.getY()].getPiece();
        }

        // validate if user said piece is correct and of color they have chosen;


        public void resetBoard(){
            placePiecesInBoard();
        }

        public Cell[][] getBoard() {
            return board;
        }
    }
