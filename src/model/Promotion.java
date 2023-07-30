package model;

import java.awt.Color;
import java.util.Scanner;

class Promotion extends Move {

  Promotion(Point toMove) {
    super(toMove);
  }

  @Override
  public void moveToPoint(int fromRow, int fromColumn, Piece piece,
      Board board) {
    board.setPiece(fromRow, fromColumn, null);

    int row = getRow();
    int column = getColumn();
    piece = promote(piece.getColor());
    piece.setMoved();
    board.setPiece(row, column, piece);
  }

  private Piece promote(Color color) {
    Scanner scanner = new Scanner(System.in);
    Piece newPiece = null;
    String what = "To what do you want to change the Pawn\n";
    System.out.println(
        what + "press\n1 for Queen\n2 for Rook\n3 for Bishop\n4 for Knight");

    int choice;
    while (true) {
      try {
        choice = scanner.nextInt();
        if ((choice >= 1) && (choice <= 4))
          break;
        else {
          System.out.println("Invalid input");
          System.out
              .println(what + "press\n 1 for Queen\n2 for Rook\n3 for Bishop\n"
                  + "4 for Knight");
        }
      } catch (Exception e) {
        System.out.println("Invalid input");
        System.out
            .println(what + "press\n 1 for Queen\n2 for Rook\n3 for Bishop\n"
                + "4 for Knight\n");
        continue;
      }
    }

    switch (choice) {
      case 1:
        newPiece = new Queen(color);
        break;
      case 2:
        newPiece = new Rook(color);
        break;
      case 3:
        newPiece = new Bishop(color);
        break;
      case 4:
      default:
        newPiece = new Knight(color);
        break;
    }
    scanner.close();
    return newPiece;
  }

}
