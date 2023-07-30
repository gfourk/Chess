package controller;

public class GameMasterFactory {

  public static GameMaster get(String string) {
    switch (string) {
      case "Console":
        return new ConsoleGameMaster();
      default:
        return null;
    }
  }

}
