package model;

import java.awt.Color;
import java.util.List;

public abstract class Piece {
  private Color color;
  private boolean isMoved;

  Piece(Color myColor) {
    this(myColor, false);
  }

  protected Piece(Color myColor, boolean isMoved) {
    if (myColor.equals(Color.white) || myColor.equals(Color.black))
      this.color = myColor;

    this.isMoved = isMoved;
  }

  public abstract List<Move> moves(int row, int column, Board board);

  public abstract String toString();

  public abstract Piece clone();

  public Color getColor() {
    return color;
  }

  boolean isMoved() {
    return isMoved;
  }

  void setMoved() {
    isMoved = true;
  }

}
