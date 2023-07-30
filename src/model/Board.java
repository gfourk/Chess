package model;

import java.awt.Color;

public class Board {
  private Point posOfBlackKing;
  private Point posOfWhiteKing;
  private Piece[][] tableOfPieces;

  public Board() {
    tableOfPieces = new Piece[8][8];

    for (int i = 0; i < 8; i++) {
      tableOfPieces[2][i] = null;
      tableOfPieces[3][i] = null;
      tableOfPieces[4][i] = null;
      tableOfPieces[5][i] = null;
      tableOfPieces[6][i] = new Pawn(Color.white);
      tableOfPieces[1][i] = new Pawn(Color.black);
    }
    tableOfPieces[0][0] = new Rook(Color.black);
    tableOfPieces[0][7] = new Rook(Color.black);
    tableOfPieces[7][0] = new Rook(Color.white);
    tableOfPieces[7][7] = new Rook(Color.white);

    tableOfPieces[0][1] = new Knight(Color.black);
    tableOfPieces[0][6] = new Knight(Color.black);
    tableOfPieces[7][1] = new Knight(Color.white);
    tableOfPieces[7][6] = new Knight(Color.white);

    tableOfPieces[0][2] = new Bishop(Color.black);
    tableOfPieces[0][5] = new Bishop(Color.black);
    tableOfPieces[7][2] = new Bishop(Color.white);
    tableOfPieces[7][5] = new Bishop(Color.white);

    tableOfPieces[0][3] = new Queen(Color.black);
    tableOfPieces[0][4] = new King(Color.black);
    tableOfPieces[7][3] = new Queen(Color.white);
    tableOfPieces[7][4] = new King(Color.white);

    posOfBlackKing = new Point(0, 4);
    posOfWhiteKing = new Point(7, 4);

    for (int i = 0; i < 8; i++) {
      assert (tableOfPieces[2][i] == null);
      assert (tableOfPieces[3][i] == null);
      assert (tableOfPieces[4][i] == null);
      assert (tableOfPieces[5][i] == null);
      assert (tableOfPieces[0][i] != null);
      assert (tableOfPieces[1][i] != null);
      assert (tableOfPieces[6][i] != null);
      assert (tableOfPieces[7][i] != null);
    }
  }

  public Board(Board another) {
    tableOfPieces = new Piece[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.tableOfPieces[i][j] = another.tableOfPieces[i][j].clone();
      }
    }
    posOfBlackKing = new Point(another.posOfBlackKing);
    posOfWhiteKing = new Point(another.posOfWhiteKing);
  }

  public Point getKing(Color color) {
    if (color.equals(Color.white))
      return posOfWhiteKing;
    else
      return posOfBlackKing;
  }

  public Point getOppositeKing(Color color) {
    if (color.equals(Color.black))
      return posOfWhiteKing;
    else
      return posOfBlackKing;
  }

  public void setKing(int row, int column, Color color) {
    if (color.equals(Color.white)) {
      posOfWhiteKing.setRow(row);
      posOfWhiteKing.setColumn(column);
    } else if (color.equals(Color.black)) {
      posOfBlackKing.setRow(row);
      posOfBlackKing.setColumn(column);
    } else {
      assert (false);
    }
  }

  public Piece getPiece(int row, int column) {
    if (new Point().setPoint(row, column))
      return tableOfPieces[row][column];
    else
      return null;
  }

  public boolean setPiece(int row, int column, Piece piece) {
    if (new Point().setPoint(row, column)) {
      tableOfPieces[row][column] = piece;
      return true;
    }
    return false;
  }

}
