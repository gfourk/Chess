package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece {

  Knight(Color color) {
    super(color);
  }

  private Knight(Color color, boolean isMoved) {
    super(color, isMoved);
  }

  @Override
  public Piece clone() {
    return new Knight(super.getColor(), super.isMoved());
  }

  @Override
  public String toString() {
    if (getColor().equals(Color.white))
      return "K";
    else
      return "k";
  }

  @Override
  public List<Move> moves(int row, int column, Board board) {
    List<Move> newlist = new LinkedList<Move>();
    Point pointToMove = new Point();
    Move newMove = null;

    if (board.getPiece(row, column).getColor().equals(Color.white)) {
      if (pointToMove.setPoint(row + 2, column + 1)
          && ((board.getPiece(row + 2, column + 1) == null) || (board
              .getPiece(row + 2, column + 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column + 2)
          && ((board.getPiece(row + 1, column + 2) == null) || (board
              .getPiece(row + 1, column + 2).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column + 2)
          && ((board.getPiece(row - 1, column + 2) == null) || (board
              .getPiece(row - 1, column + 2).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 2, column + 1)
          && ((board.getPiece(row - 2, column + 1) == null) || (board
              .getPiece(row - 2, column + 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 2, column - 1)
          && ((board.getPiece(row + 2, column - 1) == null) || (board
              .getPiece(row + 2, column - 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column - 2)
          && ((board.getPiece(row + 1, column - 2) == null) || (board
              .getPiece(row + 1, column - 2).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column - 2)
          && ((board.getPiece(row - 1, column - 2) == null) || (board
              .getPiece(row - 1, column - 2).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 2, column - 1)
          && ((board.getPiece(row - 2, column - 1) == null) || (board
              .getPiece(row - 2, column - 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

    } // end of if

    // if( b.getPiece(row,column).getColor().equals(Color.black) )
    else {

      if (pointToMove.setPoint(row + 2, column + 1)
          && ((board.getPiece(row + 2, column + 1) == null) || (board
              .getPiece(row + 2, column + 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column + 2)
          && ((board.getPiece(row + 1, column + 2) == null) || (board
              .getPiece(row + 1, column + 2).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column + 2)
          && ((board.getPiece(row - 1, column + 2) == null) || (board
              .getPiece(row - 1, column + 2).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 2, column + 1)
          && ((board.getPiece(row - 2, column + 1) == null) || (board
              .getPiece(row - 2, column + 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 2, column - 1)
          && ((board.getPiece(row + 2, column - 1) == null) || (board
              .getPiece(row + 2, column - 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column - 2)
          && ((board.getPiece(row + 1, column - 2) == null) || (board
              .getPiece(row + 1, column - 2).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column - 2)
          && ((board.getPiece(row - 1, column - 2) == null) || (board
              .getPiece(row - 1, column - 2).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 2, column - 1)
          && ((board.getPiece(row - 2, column - 1) == null) || (board
              .getPiece(row - 2, column - 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

    } // end of else

    return newlist;
  }

}
