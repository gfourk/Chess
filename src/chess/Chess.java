package chess;

import java.io.IOException;
import controller.GameMaster;
import controller.GameMasterFactory;
import model.StateHolder;
import view.UserInterface;
import view.UserInterfaceFactory;

public class Chess {
  public static void main(String[] args) throws IOException {

    UserInterface ui = UserInterfaceFactory.get("Console");

    StateHolder state = new StateHolder();

    GameMaster game = GameMasterFactory.get("Console");

    game.set(ui, state);

    game.start();
  }

}
