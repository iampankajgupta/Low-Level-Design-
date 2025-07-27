package LLD.TicTacToe;

import java.util.*;

public class TicTacTore implements BoardGame{
    private Grid grid;

    public TicTacTore(int x, int y) {
        grid = new Grid(x, y);
        initialise(grid);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 please select your piece: ");
        String p1 = scanner.nextLine();
        Player player1 = new Player();
        player1.setName("Manish");
        player1.setAge(10);
        player1.setPiece(Piece.valueOf(p1.toUpperCase()));

        System.out.println("Player 2 please select your piece: ");
        String p2 = scanner.nextLine();
        Player player2 = new Player();
        player2.setName("Pankaj");
        player2.setAge(10);
        player2.setPiece(Piece.valueOf(p2.toUpperCase()));

        Queue<Player> q = new LinkedList<>();
        q.add(player1);
        q.add(player2);
        int moves = grid.getGrid().length * grid.getGrid().length;
        printBoard(grid);
        while(true) {
            Player player = q.peek();
            System.out.println(player.getName() + " Please Select the Location for "+player.getPiece().name());
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean isValid = MoveValidation.validateMove(grid, x, y, player.getPiece());
            moves--;
            if(isValid) {
                grid.getGrid()[x][y] = player.getPiece();
                printBoard(grid);
                if(moves >= grid.getGrid().length - 2) {
                    boolean winner = StatusManager.detectState(grid, player.getPiece(), x, y);
                    if(winner) {
                        System.out.println(player.getName() +" Wins the game");
                        break;
                    }else {
                    }
                }
                if(moves == 0) {
                    System.out.println("Its a draww!!!!!!!!!!!!!!!!!");
                    break;
                }
                q.poll();
                q.add(player);
            }
            else {
                System.out.println(player.getName() + "Please Enter a valid move");
            }

        }
    }

    @Override
    public void initialise(Grid grid) {
        for(int i = 0; i<grid.getGrid().length; i++) {
            for(int j = 0; j<grid.getGrid().length; j++) {
                grid.getGrid()[i][j] = Piece.EMPTY;
            }
        }
    }

    public void printBoard(Grid grid) {
        int n = grid.getGrid().length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                System.out.print(grid.getGrid()[i][j].name().charAt(0) + " ");
            }
            System.out.println();
        }
    }
}
