package cardgame;

import java.util.ArrayList;

// Cardgame
// author:
// date:
public class CardGame
{
  // properties
  Cards             fullPack;
  ArrayList<Player> players;
  ScoreCard         scoreCard;
  Cards[]           cardsOnTable;
  int               roundNo;
  int               turnOfPlayer;
  
  // constructors
  public CardGame( Player p1, Player p2, Player p3, Player p4)
  {
    fullPack = new Cards(true);
    fullPack.shuffle();
    players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    players.add(p3);
    players.add(p4);
    scoreCard = new ScoreCard(players.size());
    roundNo = 0;
    turnOfPlayer = 0;
    cardsOnTable = new Cards[players.size()];
    for (int i = 0; i < cardsOnTable.length; i++)
    {
      cardsOnTable[i] = new Cards(false);
    }
    for (int j = 0; j < fullPack.NOOFCARDSINFULLPACK / players.size(); j++)
    {
      for (int z = 0; z < players.size(); z++)
      {
        players.get(z).add(fullPack.getTopCard());
      }
    }
    
  }
  
  // methods
  public boolean playTurn( Player p, Card c)
  {
    Card temp = new Card(0);
    if ((!isGameOver()) && (isTurnOf(p)))
    {
      System.out.println("Player : " + (turnOfPlayer+1) + "  threw : " + c.toString());
      cardsOnTable[turnOfPlayer].addTopCard(c);
      if (turnOfPlayer == 3)
      {
        roundNo++;
        for (int i = 0; i < players.size(); i++)
        {
          temp = new Card(cardsOnTable[i].cards[cardsOnTable[i].valid - 1].compareTo(temp));
        }
        for (int j = 0; j < players.size(); j++)
        {
          if (cardsOnTable[j].cards[cardsOnTable[j].valid - 1].equals(temp))
          { 
           scoreCard.update(j,1); 
          }
        }
      } 
      turnOfPlayer++;
      turnOfPlayer = turnOfPlayer % 4;
      return true;
    }
    else
    {
      System.out.println("wrong turn....please play on your own turn.");
      return false;
    }
    
  }
  
  public boolean isTurnOf( Player p)
  {
    if (players.get(turnOfPlayer).getName().equals(p.getName()))
      return true;
    else
      return false;
  }
  
  public boolean isGameOver()
  {
    if (roundNo >= fullPack.NOOFCARDSINFULLPACK / players.size())
      return true;
    else
      return false;
  }
  
  public int getScore( int playerNumber)
  {
    return scoreCard.getScore(playerNumber);
  }
  
  public String getName( int playerNumber)
  {
    return players.get(playerNumber).getName();
  }
  
  public int getRoundNo()
  {
    return roundNo;
  }
  
  public int getTurnOfPlayerNo()
  {
    return turnOfPlayer;
  }
  
  public Player[] getWinners()
  {
    int[] temp = scoreCard.getWinners();
    Player[] tmp = new Player[temp.length];
    for (int i = 0; i < temp.length; i++)
    {
      tmp[i] = players.get(temp[i]);
    }
    return tmp;
  }
  
  public String showScoreCard()
  {
    return scoreCard.toString();
  }
  
}