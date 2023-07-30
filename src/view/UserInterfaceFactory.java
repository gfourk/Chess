package view;

import java.io.IOException;

public class UserInterfaceFactory {

  public static UserInterface get(String string) throws IOException {
    switch (string) {
      case "Console":
        return new ConsoleUserInterface();
      default:
        return null;
    }
  }

}
