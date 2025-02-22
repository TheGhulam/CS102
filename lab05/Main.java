import java.awt.GridLayout;

import javax.swing.JFrame;

import cs101.sosgame.SOS;


/**
 * __SOS game___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __02-04-2018__
 */ 
public class Main
{
  public static void main( String[] args)
  {
    //canvas 1
    SOS theGame = new SOS(5);
    SOSCanvas canvas = new SOSCanvas( theGame );
    //all game 1
    SOSGUIPanel panel = new SOSGUIPanel( canvas, "TALAL" , "NOT TALAL");
    
    
    //canvas 2
    SOS theGame1 = new SOS(3);
    SOSCanvas canvas1 = new SOSCanvas( theGame1 );
    //all game 2
    SOSGUIPanel panel1 = new SOSGUIPanel( canvas1, "USMAN" , "NOT USMAN");
    
    JFrame gameSOS = new JFrame( );
    gameSOS.setLayout(new GridLayout(1,2));
    
    //adding first game
    gameSOS.add( panel );
    //adding second game
    gameSOS.add( panel1 );
    
    //packing frame size to stuff inside
    gameSOS.pack();
    
    gameSOS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    gameSOS.setVisible(true);
  }
  
}