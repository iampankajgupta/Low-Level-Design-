package LLD.ChessGame;

import LLD.ChessGame.Factory.PieceFactory;
import LLD.ChessGame.Factory.PlayerFactory;
import LLD.ChessGame.Pieces.Piece;
import LLD.ChessGame.enums.Color;
import LLD.ChessGame.enums.Pieces;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChessGame implements BoardGame{

    public ChessGame() {

    }

    // validation
    // take input from user
    // piece, color
    // currentPos, destPos

    // Validation
    // Incorrect Piece passed -- covered
    // Different color than chosen color --> covered
    // currentPos which is passed is of diff color --> covered
    // currentPos which is passed is of diff piece or empty -> covered

    // destPos for that piece is possible
    // destPos is not empty and diff color is present -> remove and set current piece color -> check gameState for checkMate
    // destPos is not empty and same color is present -> Invalid ask to select piece and position again
    // destPos is empty --> if valid set

    @Override
    public void startGame() {
        // Ask Player
        // if it is AI then automa name should be considered and start move

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Player1 name: ");
        String name1 = scanner.nextLine();
        System.out.println("Please Enter Side Color Enter White or Black");
        String color = scanner.next();
        scanner.nextLine();
        System.out.println("Please Enter Player2 name: ");
        String name2 = scanner.nextLine();
        Player player1 = PlayerFactory.createPlayer(name1);
        Player player2 = PlayerFactory.createPlayer(name2);

        // can use boolean variables to rotate turn by turn

        Queue<PlayerColor> q = new LinkedList<>();
        q.add(new PlayerColor(player1, Color.valueOf(color.toUpperCase())));
        String leftColor = color.equals(Color.WHITE.toString()) ? Color.BLACK.name() :  Color.WHITE.name();
        q.add(new PlayerColor(player2, Color.valueOf(leftColor)));

        Board board = createBoard();
        PlayerColor winner = null;

        // Piece count at any point of time
        // complete move of each one

        while(true) {

            printBoard(board.getBoard());

            PlayerColor player = q.peek();
            System.out.println(player.getiPlayer().name+" Your piece color should be : "+player.getColor());
            System.out.println("Enter the Piece name you want to move from your:"+player.getColor()+"color: ");
            String pieceName = scanner.nextLine();
            Pieces pie = null;
            try {
                pie = Pieces.valueOf(pieceName.toUpperCase());
            }catch (Exception e) {
                System.out.println("Please enter valid piece name");
                continue;

            }

            System.out.println("Move from");
            System.out.print("Enter x position of piece: ");
            int a = scanner.nextInt();
            System.out.print("Enter y position of piece: ");
            int b = scanner.nextInt();
            System.out.println("Move to ");
            System.out.print("Enter x position of piece: ");
            System.out.println();
            int x = scanner.nextInt();
            System.out.print("Enter y position of piece: ");
            int y = scanner.nextInt();
            System.out.println();

            Move currentPos = new Move(a,b);
            Move destPos = new Move(x,y);

            boolean outOfBoard = board.outOfBoardMove(currentPos);
            boolean outOfBoardDest = board.outOfBoardMove(destPos);

            if(outOfBoard) {
                System.out.println("Please Enter the valid Move from coordinates");
                continue;
            }

            if(outOfBoardDest) {
                System.out.println("Please Enter the valid Move to coordinates");
                continue;
            }
            // check that piece exist on that coordinate

            Piece currentPosPiece = board.getPiece(currentPos);
            String colorPiece = currentPosPiece.getColor().name();
            Piece piece = PieceFactory.getPiece(pie, Color.valueOf(color.toUpperCase()));

            boolean isCurrentPieceMatch = currentPosPiece.getClass().equals(piece.getClass());
            boolean isCurrentPieceColMatch = colorPiece.equals(Color.valueOf(color.toUpperCase()).name());

            if(!isCurrentPieceMatch || !isCurrentPieceColMatch) {
                System.out.println("Piece on the cell mismatch or color mismatch");
                continue;
            }

            boolean validMove = player.getiPlayer().makeMove(board,piece, currentPos, destPos, player);
            if(!validMove) {
                System.out.println("Invalid move for the piece "+pie.name());
                continue;
            }
            q.poll();

            board.getBoard()[x][y].setPiece(PieceFactory.getPiece(pie, Color.valueOf(color.toUpperCase())));
            // check game state
            



            // checkMate or draw

            printBoard(board.getBoard());
            q.add(player);
            break;
        }

//        System.out.println("Winner is :"+winner.getiPlayer().getName());

        resetBoard(board);

    }

    private void printBoard(Cell[][]board) {
        System.out.println();
        for (Cell[] cells : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(cells[j].getPiece().getPieceName().name() + ":" + cells[j].getPiece().getColor() + " | ");
            }
            System.out.println();
        }
    }


    private Board createBoard() {
        return new Board();
    }


    private void resetBoard(Board board) {
        board.resetBoard();
    }


}
