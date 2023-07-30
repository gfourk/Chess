package controller;

import model.StateHolder;
import view.UserInterface;

public interface GameMaster {

  public void set(UserInterface ui, StateHolder state);

  public void start();

}
