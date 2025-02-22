import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import shapes.*;

//frame with the game layout

public class GameFrame extends JFrame
{
  //properties
  private JPanel balloonPanel;
  
  static final int FRAME_WIDTH = 800;
  static final int FRAME_HEIGHT = 600;
  
  //constructors
  public GameFrame()
  {
    balloonPanel = new BalloonsGamePanel();
    this.add(balloonPanel);
    setTitle("Bubble game.");
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
  }
}

