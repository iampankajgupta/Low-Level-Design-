package LLD.TicTacToe;

public class StatusManager {

    public static boolean detectState(Grid grid, Piece piece, int x, int y) {
        int n = grid.getGrid().length;
        Piece[][] board = grid.getGrid();

        boolean isHorizontal = true;
        boolean isVertical = true;
        boolean isMainDiagonal = true;
        boolean isAntiDiagonal = true;

        // Check row
        for (int i = 0; i < n; i++) {
            if (!board[i][y].equals(piece)) {
                isHorizontal = false;
                break;
            }
        }

        if(!isHorizontal) {
            // Check column
            for (int i = 0; i < n; i++) {
                if (!board[x][i].equals(piece)) {
                    isVertical = false;
                    break;
                }
            }
        }

        if(!isHorizontal && !isVertical) {
            // Check main diagonal (top-left to bottom-right)
            if (x == y) {
                for (int i = 0; i < n; i++) {
                    if (!board[i][i].equals(piece)) {
                        isMainDiagonal = false;
                        break;
                    }
                }
            } else {
                isMainDiagonal = false;
            }

            // Check anti-diagonal (top-right to bottom-left)
            if (x + y == n - 1) {
                for (int i = 0; i < n; i++) {
                    if (!board[i][n - 1 - i].equals(piece)) {
                        isAntiDiagonal = false;
                        break;
                    }
                }
            } else {
                isAntiDiagonal = false;
            }
        }

        return isHorizontal || isVertical || isMainDiagonal || isAntiDiagonal;
    }

}
