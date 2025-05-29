package LLD.ChessGame;

import LLD.ChessGame.enums.Color;

public class PlayerColor {
    private Player iPlayer;
    private Color color;

    public PlayerColor(Player iPlayer, Color color) {
        this.iPlayer = iPlayer;
        this.color = color;
    }

    public Player getiPlayer() {
        return iPlayer;
    }

    public void setiPlayer(Player iPlayer) {
        this.iPlayer = iPlayer;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
