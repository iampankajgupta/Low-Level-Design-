package LLD.ChessGame.Factory;

import LLD.ChessGame.AIPlayer;
import LLD.ChessGame.HumanPlayer;
import LLD.ChessGame.Player;

public class PlayerFactory {

    public static Player createPlayer(String name) {
        if(name.equals("AI")) return new AIPlayer(name);
        else return new HumanPlayer(name);
    }
}
