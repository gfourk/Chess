package controller;

import java.awt.Color;
import java.util.List;

import model.Bishop;
import model.Board;
import model.Knight;
import model.Move;
import model.Pawn;
import model.Piece;
import model.Point;
import model.Queen;
import model.Rook;

public class CheckIf {
	public static boolean isSax(Board board, Color color, int row, int column) {
		Point threatPoint = new Point();
		if (color.equals(Color.white)) {
			int i = 1;
			while ((threatPoint.setPoint(row - i, column - i)) && ((board.getPiece(row - i, column - i) == null)
					|| (!board.getPiece(row - i, column - i).getColor().equals(color)))) {
				if ((i == 1) && (board.getPiece(row - i, column - i) != null)
						&& (board.getPiece(row - i, column - i) instanceof Pawn
								|| board.getPiece(row - i, column - i) instanceof Queen
								|| board.getPiece(row - i, column - i) instanceof Bishop)) {
					return true;
				} else if ((i != 1) && (board.getPiece(row - i, column - i) != null)
						&& (board.getPiece(row - i, column - i) instanceof Queen
								|| board.getPiece(row - i, column - i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row - i, column - i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row - i, column + i)) && ((board.getPiece(row - i, column + i) == null)
					|| (!board.getPiece(row - i, column + i).getColor().equals(color)))) {
				if ((i == 1) && (board.getPiece(row - i, column + i) != null)
						&& (board.getPiece(row - i, column + i) instanceof Pawn
								|| board.getPiece(row - i, column + i) instanceof Queen
								|| board.getPiece(row - i, column + i) instanceof Bishop)) {
					return true;
				} else if ((i != 1) && (board.getPiece(row - i, column + i) != null)
						&& (board.getPiece(row - i, column + i) instanceof Queen
								|| board.getPiece(row - i, column + i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row - i, column + i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row + i, column + i)) && ((board.getPiece(row + i, column + i) == null)
					|| (!board.getPiece(row + i, column + i).getColor().equals(color)))) {
				if ((board.getPiece(row + i, column + i) != null) && (board.getPiece(row + i, column + i) instanceof Queen
						|| board.getPiece(row + i, column + i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row + i, column + i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row + i, column - i)) && ((board.getPiece(row + i, column - i) == null)
					|| (!board.getPiece(row + i, column - i).getColor().equals(color)))) {
				if ((board.getPiece(row + i, column - i) != null) && (board.getPiece(row + i, column - i) instanceof Queen
						|| board.getPiece(row + i, column - i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row + i, column - i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row + i, column)) && ((board.getPiece(row + i, column) == null)
					|| (!board.getPiece(row + i, column).getColor().equals(color)))) {
				if ((board.getPiece(row + i, column) != null) && (board.getPiece(row + i, column) instanceof Queen
						|| board.getPiece(row + i, column) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row + i, column) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row - i, column)) && ((board.getPiece(row - i, column) == null)
					|| (!board.getPiece(row - i, column).getColor().equals(color)))) {
				if ((board.getPiece(row - i, column) != null) && (board.getPiece(row - i, column) instanceof Queen
						|| board.getPiece(row - i, column) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row - i, column) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row, column + i)) && ((board.getPiece(row, column + i) == null)
					|| (!board.getPiece(row, column + i).getColor().equals(color)))) {
				if ((board.getPiece(row, column + i) != null) && (board.getPiece(row, column + i) instanceof Queen
						|| board.getPiece(row, column + i) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row, column + i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row, column - i)) && ((board.getPiece(row, column - i) == null)
					|| (!board.getPiece(row, column - i).getColor().equals(color)))) {
				if ((board.getPiece(row, column - i) != null) && (board.getPiece(row, column - i) instanceof Queen
						|| board.getPiece(row, column - i) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row, column - i) == null) {
					i++;
				} else {
					break;
				}
			}

			if ((threatPoint.setPoint(row + 2, column + 1)) && (board.getPiece(row + 2, column + 1) != null)
					&& (!board.getPiece(row + 2, column + 1).getColor().equals(color))
					&& board.getPiece(row + 2, column + 1) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row + 1, column + 2)) && (board.getPiece(row + 1, column + 2) != null)
					&& (!board.getPiece(row + 1, column + 2).getColor().equals(color))
					&& board.getPiece(row + 1, column + 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 1, column + 2)) && (board.getPiece(row - 1, column + 2) != null)
					&& (!board.getPiece(row - 1, column + 2).getColor().equals(color))
					&& board.getPiece(row - 1, column + 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 2, column + 1)) && (board.getPiece(row - 2, column + 1) != null)
					&& (!board.getPiece(row - 2, column + 1).getColor().equals(color))
					&& board.getPiece(row - 2, column + 1) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row + 2, column - 1)) && (board.getPiece(row + 2, column - 1) != null)
					&& (!board.getPiece(row + 2, column - 1).getColor().equals(color))
					&& board.getPiece(row + 2, column - 1) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row + 1, column - 2)) && (board.getPiece(row + 1, column - 2) != null)
					&& (!board.getPiece(row + 1, column - 2).getColor().equals(color))
					&& board.getPiece(row + 1, column - 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 1, column - 2)) && (board.getPiece(row - 1, column - 2) != null)
					&& (!board.getPiece(row - 1, column - 2).getColor().equals(color))
					&& board.getPiece(row - 1, column - 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 2, column - 1)) && (board.getPiece(row - 2, column - 1) != null)
					&& (!board.getPiece(row - 2, column - 1).getColor().equals(color))
					&& board.getPiece(row - 2, column - 1) instanceof Knight) {
				return true;
			}
		} else // if( color.equals(Color.black) )
		{
			int i = 1;
			while ((threatPoint.setPoint(row + i, column + i)) && ((board.getPiece(row + i, column + i) == null)
					|| (!board.getPiece(row + i, column + i).getColor().equals(color)))) {
				if ((i == 1) && (board.getPiece(row + i, column + i) != null)
						&& (board.getPiece(row + i, column + i) instanceof Pawn
								|| board.getPiece(row + i, column + i) instanceof Queen
								|| board.getPiece(row + i, column + i) instanceof Bishop)) {
					return true;
				} else if ((i != 1) && (board.getPiece(row + i, column + i) != null)
						&& (board.getPiece(row + i, column + i) instanceof Queen
								|| board.getPiece(row + i, column + i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row + i, column + i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row + i, column - i)) && ((board.getPiece(row + i, column - i) == null)
					|| (!board.getPiece(row + i, column - i).getColor().equals(color)))) {
				if ((i == 1) && (board.getPiece(row + i, column - i) != null)
						&& (board.getPiece(row + i, column - i) instanceof Pawn
								|| board.getPiece(row + i, column - i) instanceof Queen
								|| board.getPiece(row + i, column - i) instanceof Bishop)) {
					return true;
				} else if ((i != 1) && (board.getPiece(row + i, column - i) != null)
						&& (board.getPiece(row + i, column - i) instanceof Queen
								|| board.getPiece(row + i, column - i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row + i, column - i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row - i, column + i)) && ((board.getPiece(row - i, column + i) == null)
					|| (!board.getPiece(row - i, column + i).getColor().equals(color)))) {
				if ((board.getPiece(row - i, column + i) != null) && (board.getPiece(row - i, column + i) instanceof Queen
						|| board.getPiece(row - i, column + i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row - i, column + i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row - i, column - i)) && ((board.getPiece(row - i, column - i) == null)
					|| (!board.getPiece(row - i, column - i).getColor().equals(color)))) {
				if ((board.getPiece(row - i, column - i) != null) && (board.getPiece(row - i, column - i) instanceof Queen
						|| board.getPiece(row - i, column - i) instanceof Bishop)) {
					return true;
				} else if (board.getPiece(row - i, column - i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row + i, column)) && ((board.getPiece(row + i, column) == null)
					|| (!board.getPiece(row + i, column).getColor().equals(color)))) {
				if ((board.getPiece(row + i, column) != null) && (board.getPiece(row + i, column) instanceof Queen
						|| board.getPiece(row + i, column) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row + i, column) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row - i, column)) && ((board.getPiece(row - i, column) == null)
					|| (!board.getPiece(row - i, column).getColor().equals(color)))) {
				if ((board.getPiece(row - i, column) != null) && (board.getPiece(row - i, column) instanceof Queen
						|| board.getPiece(row - i, column) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row - i, column) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row, column + i)) && ((board.getPiece(row, column + i) == null)
					|| (!board.getPiece(row, column + i).getColor().equals(color)))) {
				if ((board.getPiece(row, column + i) != null) && (board.getPiece(row, column + i) instanceof Queen
						|| board.getPiece(row, column + i) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row, column + i) == null) {
					i++;
				} else {
					break;
				}
			}

			i = 1;
			while ((threatPoint.setPoint(row, column - i)) && ((board.getPiece(row, column - i) == null)
					|| (!board.getPiece(row, column - i).getColor().equals(color)))) {
				if ((board.getPiece(row, column - i) != null) && (board.getPiece(row, column - i) instanceof Queen
						|| board.getPiece(row, column - i) instanceof Rook)) {
					return true;
				} else if (board.getPiece(row, column - i) == null) {
					i++;
				} else {
					break;
				}
			}

			if ((threatPoint.setPoint(row + 2, column + 1)) && (board.getPiece(row + 2, column + 1) != null)
					&& (!board.getPiece(row + 2, column + 1).getColor().equals(color))
					&& board.getPiece(row + 2, column + 1) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row + 1, column + 2)) && (board.getPiece(row + 1, column + 2) != null)
					&& (!board.getPiece(row + 1, column + 2).getColor().equals(color))
					&& board.getPiece(row + 1, column + 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 1, column + 2)) && (board.getPiece(row - 1, column + 2) != null)
					&& (!board.getPiece(row - 1, column + 2).getColor().equals(color))
					&& board.getPiece(row - 1, column + 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 2, column + 1)) && (board.getPiece(row - 2, column + 1) != null)
					&& (!board.getPiece(row - 2, column + 1).getColor().equals(color))
					&& board.getPiece(row - 2, column + 1) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row + 2, column - 1)) && (board.getPiece(row + 2, column - 1) != null)
					&& (!board.getPiece(row + 2, column - 1).getColor().equals(color))
					&& board.getPiece(row + 2, column - 1) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row + 1, column - 2)) && (board.getPiece(row + 1, column - 2) != null)
					&& (!board.getPiece(row + 1, column - 2).getColor().equals(color))
					&& board.getPiece(row + 1, column - 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 1, column - 2)) && (board.getPiece(row - 1, column - 2) != null)
					&& (!board.getPiece(row - 1, column - 2).getColor().equals(color))
					&& board.getPiece(row - 1, column - 2) instanceof Knight) {
				return true;
			}

			if ((threatPoint.setPoint(row - 2, column - 1)) && (board.getPiece(row - 2, column - 1) != null)
					&& (!board.getPiece(row - 2, column - 1).getColor().equals(color))
					&& board.getPiece(row - 2, column - 1) instanceof Knight) {
				return true;
			}
		}

		return false;// check king?
	}

	static boolean kingMoves(Board board, Color color, int row, int column) {
		Point point = new Point();
		int k, m;
		for (k = -1; k <= 1; k++) {
			for (m = -1; m <= 1; m++) {
				if ((k == 0) && (m == 0))
					continue;
				else if (!point.setPoint(row + k, column + m))
					continue;
				else if ((board.getPiece(row + k, column + m) == null)
						|| (!board.getPiece(row + k, column + m).getColor().equals(color))) {
					Piece piece = board.getPiece(row + k, column + m);
					board.setPiece(row + k, column + m, board.getPiece(row, column));
					board.setPiece(row, column, null);

					board.setKing(row + k, column + m, color);

					if (!CheckIf.isSax(board, color, row + k, column + m)) {
						board.setPiece(row, column, board.getPiece(row + k, column + m));
						board.setPiece(row + k, column + m, piece);

						board.setKing(row, column, color);

						return true;
					}

					board.setPiece(row, column, board.getPiece(row + k, column + m));
					board.setPiece(row + k, column + m, piece);
				}
			}
		}

		board.setKing(row, column, color);

		return false;
	}

	static boolean anythingMoves(Board board, Color color, int kingRow, int kingColumn) {
		int i, j;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				if ((kingRow == i) && (kingColumn == j))
					continue;

				if ((board.getPiece(i, j) != null) && (board.getPiece(i, j).getColor().equals(color))) {
					Move newMove;
					List<Move> newlist = board.getPiece(i, j).moves(i, j, board);
					while (!newlist.isEmpty()) {
						Board anotherBoard = new Board(board);
						newMove = newlist.get(0);

						Piece newPiece = board.getPiece(i, j).clone();
						newMove.moveToPoint(i, j, newPiece, anotherBoard);

						if (!CheckIf.isSax(anotherBoard, color, kingRow, kingColumn)) {
							return true;
						}

						newlist.remove(0);

					}
				} // end of if

			} // end of for

		} // end of for
		return false;
	}

	static boolean isEql(Board board, Color color) {
		int counter = 0, i, j;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				if ((board.getPiece(i, j) != null) && (board.getPiece(i, j).getColor().equals(color))) {

					if (board.getPiece(i, j) instanceof Queen || board.getPiece(i, j) instanceof Pawn
							|| board.getPiece(i, j) instanceof Rook) {
						return false;
					}

					if (board.getPiece(i, j) instanceof Bishop) {
						counter++;
					}

				}
			}
		}

		if (counter <= 1) {
			return true;
		}

		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				if ((board.getPiece(i, j) != null) && (board.getPiece(i, j).getColor().equals(color))) {
					List<Move> newlist = board.getPiece(i, j).moves(i, j, board);

					if (!newlist.isEmpty())
						return false;

				}
			}
		}

		return true;
	}

}
