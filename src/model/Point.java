package model;

public class Point {

  private int row;
  private int column;

  public Point() {
    row = (column = -1);// -1 is good for start because it is out of bounds in the board table
  }

  Point(int anotherRow, int anotherColumn) {
    this();
    setRow(anotherRow);
    setColumn(anotherColumn);
  }

  Point(Point another) {
    this(another.getRow(), another.getColumn());
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public boolean setRow(int anotherRow) {
    if ((anotherRow >= 0) && (anotherRow <= 7)) {
      row = anotherRow;
      return true;
    }
    return false;
  }

  public boolean setColumn(int anotherColumn) {
    if ((anotherColumn >= 0) && (anotherColumn <= 7)) {
      column = anotherColumn;
      return true;
    }
    return false;
  }

  public boolean setPoint(int anotherRow, int anotherColumn) {
    return (setRow(anotherRow) && setColumn(anotherColumn));
  }

}
