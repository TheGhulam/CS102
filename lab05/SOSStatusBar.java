import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//SOS canvas
public class SOSStatusBar extends JPanel
{
  //properties
  
  static final int PANEL_WIDTH = 400;
  static final int PANEL_HEIGHT = 50;
  
  //constructors
  public SOSStatusBar(JLabel player1, JLabel player2, JRadioButton button1, JRadioButton button2)
  {

    this.setLayout(new BorderLayout());
    this.setMaximumSize( new Dimension( PANEL_WIDTH, PANEL_HEIGHT ) );

    this.add(player1, BorderLayout.LINE_START);
    this.add(getButtonsPanel(button1, button2), BorderLayout.CENTER);
    this.add(player2, BorderLayout.LINE_END);
    
  }
  
  //methods
  
  /**
   * Makes a panel with two radio buttons.
   * @param button1 as the first radio button. 
   * @param button2 as the second radio button. 
   * @return JPanel as the panel which has two radio buttons.
   */
  public JPanel getButtonsPanel(JRadioButton button1, JRadioButton button2)
  {
    JPanel panel = new JPanel();
    this.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
    panel.add(button1);
    panel.add(button2);
    return panel;
  }
}

