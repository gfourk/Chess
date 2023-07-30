package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {

  Queen(Color color) {
    super(color);
  }

  private Queen(Color color, boolean isMoved) {
    super(color, isMoved);
  }

  @Override
  public Piece clone() {
    return new Queen(super.getColor(), super.isMoved());
  }

  @Override
  public String toString() {
    if (getColor().equals(Color.white))
      return "Q";
    else
      return "q";
  }

  @Override
  public List<Move> moves(int row, int column, Board board) {
    List<Move> newlist = new LinkedList<Move>();
    Point pointToMove = new Point();
    Move newMove = null;

    if (board.getPiece(row, column).getColor().equals(Color.white)) {
      int i = 1;
      while (pointToMove.setPoint(row + i, column + i)) {
        if (board.getPiece(row + i, column + i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row + i, column + i).getColor()
            .equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row + i, column - i)) {
        if (board.getPiece(row + i, column - i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row + i, column - i).getColor()
            .equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row - i, column + i)) {
        if (board.getPiece(row - i, column + i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row - i, column + i).getColor()
            .equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row - i, column - i)) {
        if (board.getPiece(row - i, column - i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row - i, column - i).getColor()
            .equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row + i, column)) {
        if (board.getPiece(row + i, column) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row + i, column).getColor().equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row - i, column)) {
        if (board.getPiece(row - i, column) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row - i, column).getColor().equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row, column + i)) {
        if (board.getPiece(row, column + i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row, column + i).getColor().equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row, column - i)) {
        if (board.getPiece(row, column - i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row, column - i).getColor().equals(Color.black)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

    } // end of if

    // if( b.getPiece(row,column).getColor().equals(Color.black) )
    else {

      int i = 1;
      while (pointToMove.setPoint(row + i, column + i)) {
        if (board.getPiece(row + i, column + i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row + i, column + i).getColor()
            .equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row + i, column - i)) {
        if (board.getPiece(row + i, column - i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row + i, column - i).getColor()
            .equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row - i, column + i)) {
        if (board.getPiece(row - i, column + i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row - i, column + i).getColor()
            .equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row - i, column - i)) {
        if (board.getPiece(row - i, column - i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row - i, column - i).getColor()
            .equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row + i, column)) {
        if (board.getPiece(row + i, column) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row + i, column).getColor().equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row - i, column)) {
        if (board.getPiece(row - i, column) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row - i, column).getColor().equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row, column + i)) {
        if (board.getPiece(row, column + i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row, column + i).getColor().equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

      i = 1;
      while (pointToMove.setPoint(row, column - i)) {
        if (board.getPiece(row, column - i) == null) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          i++;
        } else if (board.getPiece(row, column - i).getColor().equals(Color.white)) {
          newMove = new Move(pointToMove);
          newlist.add(newMove);
          break;
        } else
          break;
      } // end of while

    } // end of else

    return newlist;
  }

}
