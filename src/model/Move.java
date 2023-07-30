package model;

public class Move extends Point {
	
	Move(Point toMove) {
		super(toMove);
	}

	public void moveToPoint(int fromRow, int fromColumn, Piece piece, Board board) {
		board.setPiece(fromRow, fromColumn, null);
		piece.setMoved();

		int row = this.getRow();
		int column = this.getColumn();

		board.setPiece(row, column, piece);
		if (piece instanceof King)
			board.setKing(row, column, piece.getColor());
	}

}
