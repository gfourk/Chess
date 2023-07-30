package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Pawn extends Piece {

  Pawn(Color color) {
    super(color);
  }

  private Pawn(Color color, boolean isMoved) {
    super(color, isMoved);
  }

  @Override
  public Piece clone() {
    return new Pawn(super.getColor(), super.isMoved());
  }

  @Override
  public String toString() {
    if (getColor().equals(Color.white))
      return "P";
    else
      return "p";
  }

  @Override
  public List<Move> moves(int row, int column, Board board) {

    List<Move> newlist = new LinkedList<Move>();
    Point pointToMove = new Point();
    Move newMove = null;

    if (board.getPiece(row, column).getColor().equals(Color.white)) {

      if (pointToMove.setPoint(row - 1, column)
          && (board.getPiece(row - 1, column) == null)) {
        if (row - 1 == 0)
          newMove = new Promotion(pointToMove);
        else
          newMove = new Move(pointToMove);

        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column + 1)
          && (board.getPiece(row - 1, column + 1) != null) && (board
              .getPiece(row - 1, column + 1).getColor().equals(Color.black))) {
        if (row - 1 == 0)
          newMove = new Promotion(pointToMove);
        else
          newMove = new Move(pointToMove);

        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column - 1)
          && (board.getPiece(row - 1, column - 1) != null) && (board
              .getPiece(row - 1, column - 1).getColor().equals(Color.black))) {
        if (row - 1 == 0)
          newMove = new Promotion(pointToMove);
        else
          newMove = new Move(pointToMove);

        newlist.add(newMove);
      }

      if (!board.getPiece(row, column).isMoved()
          && pointToMove.setPoint(row - 2, column)
          && (board.getPiece(row - 1, column) == null)
          && (board.getPiece(row - 2, column) == null)) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

    } // end of if color is white

    // if( b.getPiece(row,column).getColor().equals(Color.black) )
    else {

      if (pointToMove.setPoint(row + 1, column)
          && (board.getPiece(row + 1, column) == null)) {
        if (row + 1 == 7)
          newMove = new Promotion(pointToMove);
        else
          newMove = new Move(pointToMove);

        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column + 1)
          && (board.getPiece(row + 1, column + 1) != null) && (board
              .getPiece(row + 1, column + 1).getColor().equals(Color.white))) {
        if (row + 1 == 7)
          newMove = new Promotion(pointToMove);
        else
          newMove = new Move(pointToMove);

        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column - 1)
          && (board.getPiece(row + 1, column - 1) != null) && (board
              .getPiece(row + 1, column - 1).getColor().equals(Color.white))) {
        if (row + 1 == 7)
          newMove = new Promotion(pointToMove);
        else
          newMove = new Move(pointToMove);

        newlist.add(newMove);
      }

      if (!board.getPiece(row, column).isMoved()
          && pointToMove.setPoint(row + 2, column)
          && (board.getPiece(row + 1, column) == null)
          && (board.getPiece(row + 2, column) == null)) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

    } // end of else color is black

    return newlist;
  }

}
