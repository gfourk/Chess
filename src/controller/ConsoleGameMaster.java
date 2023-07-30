package controller;

import java.awt.Color;
import java.util.List;
import java.util.Scanner;
import model.Board;
import model.Move;
import model.Piece;
import model.Point;
import model.StateHolder;
import view.UserInterface;

public class ConsoleGameMaster implements GameMaster {
  private String turn;
  private String player1;
  private String player2;
  private Color color1;
  private Color color2;
  private Scanner scanner;
  private UserInterface ui;
  private StateHolder state;


  public ConsoleGameMaster() {}

  public void set(UserInterface ui, StateHolder state) {
    this.ui = ui;
    this.state = state;
  }

  public void start() {
    int choice;
    scanner = new Scanner(System.in);

    do {
      System.out.print("Give first player name ");
      player1 = scanner.nextLine();
    } while (player1.equals(""));

    do {
      System.out.print("Give second player name ");
      player2 = scanner.nextLine();
    } while (player2.equals(""));

    System.out.println("Who want's to play with the white pieces ");
    System.out.println("press");
    System.out.println("1 for first player");
    System.out.println("2 for second player");
    System.out.println("3 for random choice");

    while (true) {
      choice = scanner.nextInt();
      if ((choice >= 1) && (choice <= 3))
        break;
      else {
        System.out.println("Invalid input");
        System.out.println("Who want's to play with the white pieces ");
        System.out.println("press");
        System.out.println("1 for first player");
        System.out.println("2 for second player");
        System.out.println("3 for random choice");
      }
    }

    switch (choice) {
      case 1:
        turn = player1;
        color1 = Color.white;
        color2 = Color.black;
        break;
      case 2:
        turn = player2;
        color1 = Color.black;
        color2 = Color.white;
        break;
      case 3:
      default:
        if (Math.random() >= 0.5) {
          turn = player1;
          color1 = Color.white;
          color2 = Color.black;
        } else {
          turn = player2;
          color1 = Color.black;
          color2 = Color.white;
        }
        break;
    }

    while (true) {
      choice = play();

      if (choice == 2)
        break;

      state.newBoard();
    }

    scanner.close();
    return;
  }

  private int play() {
    Board board = state.getBoard();

    String check = "Not";

    while (check.equals("Not") || check.equals("Sax")) {
      if (check.equals("Sax")) {
        System.out.println("\nSax");
      }
      if (turn == player1) {
        ui.show(state);
        System.out.println(player1);
        System.out
            .println("1. New\n2. Exit\nMove(for example a2->a3 or h7->h6)");

        String choice;
        choice = scanner.next();

        if (choice.equals("1"))
          return 1;
        else if (choice.equals("2"))
          return 2;
        else if (!makeAppropriateMove(choice, color1, player1, board)) {
          turn = player1;
          continue;
        }
        turn = player2;
        check = checkWin(board, color1);
        continue;
      } // end of if
      else {
        ui.show(state);
        System.out.println(player2);
        System.out
            .println("1. New\n2. Exit\nMove(for example a2->a3 or h7->h6)");

        String choice;
        choice = scanner.next();

        if (choice.equals("1"))
          return 1;
        else if (choice.equals("2"))
          return 2;
        else if (!makeAppropriateMove(choice, color2, player2, board)) {
          turn = player2;
          continue;
        }
        turn = player1;
        check = checkWin(board, color2);
      } // end of else

    } // end of while

    if (check.equals("Mat"))
      System.out.println("Mat");
    else
      System.out.println("Isopalia");

    return 0;
  }

  private boolean makeAppropriateMove(String choice, Color color, String player,
      Board board) {
    Point from = new Point();
    Point to = new Point();

    if (choice.startsWith("a"))
      from.setColumn(0);
    else if (choice.startsWith("b"))
      from.setColumn(1);
    else if (choice.startsWith("c"))
      from.setColumn(2);
    else if (choice.startsWith("d"))
      from.setColumn(3);
    else if (choice.startsWith("e"))
      from.setColumn(4);
    else if (choice.startsWith("f"))
      from.setColumn(5);
    else if (choice.startsWith("g"))
      from.setColumn(6);
    else if (choice.startsWith("h"))
      from.setColumn(7);
    else {
      System.out.println("from column invalid");
      return false;
    }

    if (!from.setRow(8 - Integer.parseInt(choice.substring(1, 2)))) {
      System.out.println("from raw invalid");
      return false;
    }

    if (choice.substring(4, 5).equals("a"))
      to.setColumn(0);
    else if (choice.substring(4, 5).equals("b"))
      to.setColumn(1);
    else if (choice.substring(4, 5).equals("c"))
      to.setColumn(2);
    else if (choice.substring(4, 5).equals("d"))
      to.setColumn(3);
    else if (choice.substring(4, 5).equals("e"))
      to.setColumn(4);
    else if (choice.substring(4, 5).equals("f"))
      to.setColumn(5);
    else if (choice.substring(4, 5).equals("g"))
      to.setColumn(6);
    else if (choice.substring(4, 5).equals("h"))
      to.setColumn(7);
    else {
      System.out.println("to column invalid");
      return false;
    }

    if (!to.setRow(8 - Integer.parseInt(choice.substring(5, 6)))) {
      System.out.println("to raw invalid");
      return false;
    }

    if (board.getPiece(from.getRow(), from.getColumn()) == null) {
      System.out.println("Invalid input");
      return false;
    }

    System.out.println(
        "from row " + from.getRow() + " from column " + from.getColumn());
    System.out
        .println("to row " + to.getRow() + " to column " + to.getColumn());

    Piece pieceOfPlayer =
        isPieceOfPlayer(board, color, from.getRow(), from.getColumn());

    if (pieceOfPlayer != null) {
      Move newMove = testTypeOfMove(board, pieceOfPlayer, from, to);

      if (newMove == null) {
        System.out.println("Invalid move");
        return false;
      }

      newMove.moveToPoint(from.getRow(), from.getColumn(), pieceOfPlayer,
          board);

      System.out.println("opp King row " + board.getOppositeKing(color).getRow()
          + " opp King column " + board.getOppositeKing(color).getColumn()
          + " color is " + color.toString());
      if ((to.getRow() == board.getOppositeKing(color).getRow())
          && (to.getColumn() == board.getOppositeKing(color).getColumn())) {
        ui.show(state);
        System.out.println("The Winner is player: " + player);
        System.exit(0);
      }

      return true;

    } else {
      System.out.println("This piece is the opponents!");
      return false;
    }

  }

  private Move testTypeOfMove(Board board, Piece pieceOfPlayer, Point from,
      Point to) {
    List<Move> listOfMoves =
        pieceOfPlayer.moves(from.getRow(), from.getColumn(), board);

    if (listOfMoves == null)
      return null;

    while (!listOfMoves.isEmpty()) {
      Move currentMove = listOfMoves.get(0);

      System.out.println("currentMove row " + currentMove.getRow()
          + " currentMove column " + currentMove.getColumn());

      listOfMoves.remove(0);
    }

    listOfMoves = pieceOfPlayer.moves(from.getRow(), from.getColumn(), board);

    if (listOfMoves == null)
      return null;

    while (!listOfMoves.isEmpty()) {
      Move currentMove = listOfMoves.get(0);

      if (currentMove.getRow() == to.getRow()
          && currentMove.getColumn() == to.getColumn()) {
        return currentMove;
      }

      listOfMoves.remove(0);
    }
    return null;
  }

  private Piece isPieceOfPlayer(Board board, Color color, int row, int column) {
    if (board.getPiece(row, column).getColor().equals(color)) {
      return board.getPiece(row, column);
    }
    return null;
  }

  private String checkWin(Board board, Color color) {
    int row = board.getKing(color).getRow();
    int column = board.getKing(color).getColumn();

    if (CheckIf.isSax(board, color, row, column)) {
      if (CheckIf.kingMoves(board, color, row, column))
        return "Sax";

      if (CheckIf.anythingMoves(board, color, row, column))
        return "Sax";
      else
        return "Mat";
    }

    if (CheckIf.isEql(board, color))
      return "Eql";
    else
      return "Not";
  }

}
