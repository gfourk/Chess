package model;

class SmallCastling extends Move {
	
	private Point rookPoint;

	SmallCastling(Point toMove, Point rook) {
		super(toMove);
		rookPoint = rook;
	}

	@Override
	public void moveToPoint(int fromRow, int fromColumn, Piece king, Board board) {
		Piece rook = board.getPiece(rookPoint.getRow(), rookPoint.getColumn());

		board.setPiece(rookPoint.getRow(), rookPoint.getColumn(), null);
		board.setPiece(fromRow, fromColumn, null);

		king.setMoved();
		rook.setMoved();

		int row = getRow();
		int column = getColumn();

		board.setPiece(row, column, king);
		board.setPiece(row, column + 1, rook);
		board.setKing(row, column, king.getColor());
	}

}
