import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//SOS canvas
public class SOSCanvas extends JPanel
{
  //properties
  SOS theSOSGame;
  
  static final int FRAME_WIDTH = 500;
  static final int FRAME_HEIGHT = 500;
  
  //constructors
  public SOSCanvas(SOS theSOSGame)
  {
    this.theSOSGame = theSOSGame;
    this.setPreferredSize( new Dimension( FRAME_WIDTH + 30, FRAME_HEIGHT + 30 ) );
    
  }
  
  //methods
  
  /**
   * Plays the turn of a player.
   * @param a as the char required in game play. 
   * @param x as the x location of box clicked in. 
   * @param y as the y location of box clicked in.
   */
  public void play(char a, int x, int y)
  {
    theSOSGame.play(a, x, y);
    repaint();
  }
  
  /**
   * Prints all the Grid on the panel.
   * @return SOS as the game simulation used to draw canvas. 
   */
  public SOS getGame()
  {
    return theSOSGame;
  }
  
  /**
   * Prints all the Grid on the panel.
   * @param g as the graphics which are used to draw stuff. 
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    int x = 15;
    int y = 15;
    int row = 0;
    int column = 0;
    for (int i = 1; i <= (theSOSGame.getDimension() * theSOSGame.getDimension()); i++)
    {
      g.drawRect(x , y, FRAME_WIDTH / theSOSGame.getDimension() , FRAME_HEIGHT / theSOSGame.getDimension());
      g.setFont(new Font("Calibri", Font.PLAIN, 26));
      g.drawString(theSOSGame.getCellContents(row, column) + "", (x + (FRAME_WIDTH / theSOSGame.getDimension()) / 2), 
                   (y + (FRAME_HEIGHT / theSOSGame.getDimension()) / 2));
      
      x = x + (FRAME_WIDTH / theSOSGame.getDimension());
      row++;
      
      if ((i % theSOSGame.getDimension() == 0) && (i != 0))
      {
        y = y + (FRAME_HEIGHT / theSOSGame.getDimension());
        y++;
        x = 15;
        row = 0;
        column++;
      }
      
    }
    
  }
  
}