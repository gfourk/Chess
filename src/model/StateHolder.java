package model;

import java.awt.Color;

public class StateHolder {
  private String turn;
  private String player1;
  private String player2;
  private Color currentColor;
  private Color color1;
  private Color color2;
  private Board b;

  public StateHolder() {
    b = new Board();
  }

  public Board getBoard() {
    return b;
  }

  public void newBoard() {
    b = new Board();
  }

  public String getTurn() {
    return turn;
  }

  public void setTurn(String turn) {
    this.turn = turn;
  }

  public String getPlayer1() {
    return player1;
  }

  public void setPlayer1(String player1) {
    this.player1 = player1;
  }

  public String getPlayer2() {
    return player2;
  }

  public void setPlayer2(String player2) {
    this.player2 = player2;
  }

  public Color getColor1() {
    return color1;
  }

  public void setColor1(Color color1) {
    this.color1 = color1;
  }

  public Color getColor2() {
    return color2;
  }

  public void setColor2(Color color2) {
    this.color2 = color2;
  }

  public Color getCurrentColor() {
    return currentColor;
  }

  public void setCurrentColor(Color currentColor) {
    this.currentColor = currentColor;
  }

}
