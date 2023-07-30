package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import controller.CheckIf;

class King extends Piece {

  King(Color color) {
    super(color);
  }

  private King(Color color, boolean isMoved) {
    super(color, isMoved);
  }

  @Override
  public Piece clone() {
    return new King(super.getColor(), super.isMoved());
  }

  @Override
  public String toString() {
    if (getColor().equals(Color.white))
      return "W";
    else
      return "w";
  }

  @Override
  public List<Move> moves(int row, int column, Board board) {
    List<Move> newlist = new LinkedList<Move>();
    Point pointToMove = new Point();
    Move newMove = null;

    if (board.getPiece(row, column).getColor().equals(Color.white)) {
      if (pointToMove.setPoint(row + 1, column + 1)
          && ((board.getPiece(row + 1, column + 1) == null) || (board
              .getPiece(row + 1, column + 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row, column + 1)
          && ((board.getPiece(row, column + 1) == null) || (board
              .getPiece(row, column + 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column + 1)
          && ((board.getPiece(row - 1, column + 1) == null) || (board
              .getPiece(row - 1, column + 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column)
          && ((board.getPiece(row + 1, column) == null) || (board
              .getPiece(row + 1, column).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column)
          && ((board.getPiece(row - 1, column) == null) || (board
              .getPiece(row - 1, column).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column - 1)
          && ((board.getPiece(row + 1, column - 1) == null) || (board
              .getPiece(row + 1, column - 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row, column - 1)
          && ((board.getPiece(row, column - 1) == null) || (board
              .getPiece(row, column - 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column - 1)
          && ((board.getPiece(row - 1, column - 1) == null) || (board
              .getPiece(row - 1, column - 1).getColor().equals(Color.black)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

    } // end of if

    // if( b.getPiece(row,column).getColor().equals(Color.black) )
    else {

      if (pointToMove.setPoint(row + 1, column + 1)
          && ((board.getPiece(row + 1, column + 1) == null) || (board
              .getPiece(row + 1, column + 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row, column + 1)
          && ((board.getPiece(row, column + 1) == null) || (board
              .getPiece(row, column + 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column + 1)
          && ((board.getPiece(row - 1, column + 1) == null) || (board
              .getPiece(row - 1, column + 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column)
          && ((board.getPiece(row + 1, column) == null) || (board
              .getPiece(row + 1, column).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column)
          && ((board.getPiece(row - 1, column) == null) || (board
              .getPiece(row - 1, column).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row + 1, column - 1)
          && ((board.getPiece(row + 1, column - 1) == null) || (board
              .getPiece(row + 1, column - 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row, column - 1)
          && ((board.getPiece(row, column - 1) == null) || (board
              .getPiece(row, column - 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

      if (pointToMove.setPoint(row - 1, column - 1)
          && ((board.getPiece(row - 1, column - 1) == null) || (board
              .getPiece(row - 1, column - 1).getColor().equals(Color.white)))) {
        newMove = new Move(pointToMove);
        newlist.add(newMove);
      }

    } // end of else

    if (!board.getPiece(row, column).isMoved()) {
      Color color = board.getPiece(row, column).getColor();
      if ((board.getPiece(row, column - 4) != null)
          && (board.getPiece(row, column - 1) == null)
          && (board.getPiece(row, column - 2) == null)
          && (board.getPiece(row, column - 3) == null)
          && (!board.getPiece(row, column - 4).isMoved())) {
        if (!CheckIf.isSax(board, color, row, column)) {
          if (!CheckIf.isSax(board, color, row, column - 1)) {
            if (!CheckIf.isSax(board, color, row, column - 2)) {
              pointToMove.setPoint(row, column - 2);
              newMove =
                  new BigCastling(pointToMove, new Point(row, column - 4));
              newlist.add(newMove);
            }
          }
        }
      } // end of if

      if ((board.getPiece(row, column + 3) != null)
          && (board.getPiece(row, column + 1) == null)
          && (board.getPiece(row, column + 2) == null)
          && (!board.getPiece(row, column + 3).isMoved())) {
        if (!CheckIf.isSax(board, color, row, column)) {
          if (!CheckIf.isSax(board, color, row, column + 1)) {
            if (!CheckIf.isSax(board, color, row, column + 2)) {
              pointToMove.setPoint(row, column + 2);
              newMove =
                  new SmallCastling(pointToMove, new Point(row, column + 3));
              newlist.add(newMove);
            }
          }
        }
      } // end of if

    } // end of if
    return newlist;
  }

}
