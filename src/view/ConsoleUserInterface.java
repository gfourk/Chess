package view;

import model.StateHolder;

public class ConsoleUserInterface implements UserInterface {

  @Override
  public void show(StateHolder state) {
    int i = 0;
    int j = 0;
    StringBuilder builder = new StringBuilder();
    builder.append("\n");
    builder.append("|");
    for (; j < 8; j++) {
      builder.append("---|");
    }
    for (; i < 8; i++) {
      builder.append("\n|");
      for (j = 0; j < 8; j++) {
        if (state.getBoard().getPiece(i, j) != null) {
          builder.append(" ");
          builder.append(state.getBoard().getPiece(i, j).toString());
          builder.append(" |");
        } else {
          builder.append("   |");
        }
      }
      builder.append("\n|");
      for (j = 0; j < 8; j++) {
        builder.append("---|");
      }
    }
    builder.append("\n\n");
    System.out.println(builder);
  }

}
