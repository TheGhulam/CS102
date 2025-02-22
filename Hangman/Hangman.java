import java.lang.StringBuffer;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Hangman class
 * @author Mian Usman Naeem Kakakhel, section 3
 * @version 8/2/2018
 */

public class Hangman
{
  //properties
  private static StringBuffer secretWord;
  private static StringBuffer allLetters;
  private static StringBuffer usedLetters;
  private static int numberOfIncorrectTries;
  private static int maxAllowedIncorrectTries;
  private static StringBuffer knownSoFar;  
  
  //Constructor
  
  public Hangman () throws FileNotFoundException
  {
    allLetters = new StringBuffer( "abcdefghijklmnopqrstuvwxyz");
    maxAllowedIncorrectTries = 6;
    numberOfIncorrectTries = 0;
    usedLetters = new StringBuffer( "");
    secretWord = new StringBuffer( chooseSecretWord());
    knownSoFar = new StringBuffer( "");
    for ( int i = 0; i < secretWord.length(); i++ ) {
      knownSoFar.append( "*");
    }
  }
  
//Methods
  /**
   * method returns number of occurences of this letter in the secret word
   * @param letter is the charater that has to be checked to play game.
   * @return integer 
   */
  public int tryThis (char letter) 
  {
    // variables
    int count;
    boolean flag;
    
    // initiating variables
    count = 0;
    flag = true;
    
    // checks whether the letter entered is valid or not
    for( int k = 0; k < allLetters.length(); k++)
    {
      if(allLetters.charAt(k) == letter)
      {
        flag = false;
      }
    }
    
    if (flag)
      return -1;
    
    // checks if the letter has already been used or not
    for( int j = 0; j < usedLetters.length(); j++)
    {
      if( usedLetters.charAt(j) == letter)
      {
        //System.out.println(usedLetters.charAt(j) + "   " + letter);
        return -2;
      }
    } 
    
    // if the letter is not used it adds it to usedletters 
    usedLetters.append( letter);
    
    // counts the number of times the letter has been used in the secret word(s)
    for( int k = 0; k < secretWord.length(); k++)
    {
      if( secretWord.charAt(k) == letter)
      {
        count++;
        knownSoFar = new StringBuffer(knownSoFar.substring(0,k) + letter + knownSoFar.substring(k + 1,secretWord.length())); 
      }
    }
    
    // if the letter is not used in the secret word, the number of incorrect tries is increased
    if(count == 0) 
    {
      numberOfIncorrectTries++;
    }
    
    // if the number of incorrect tries is maxed, gives the game over signal
    if( numberOfIncorrectTries == maxAllowedIncorrectTries)
    { 
      return -3;
    }
    
    // returns the number of times the letter is used in the secret word
    return count;       
  }
  
  /**
   * method returns True if the game is over and False otherwise
   * @return boolean
   */
  public boolean isGameOver()
  {
    if (hasLost() == true || knownSoFar.toString().equals(secretWord.toString()))
    {
      knownSoFar = secretWord;
      return true;
    }
    else
    {
      return false;
    }
  }
  
  /**
   * method returns True if player has lost and False otherwise
   * @return boolean
   */
  public boolean hasLost()
  {
    if (numberOfIncorrectTries == maxAllowedIncorrectTries)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  /**
   * method chooses secret word from file if file present, and from array if file not present
   * @return String
   * @throws FileNotFoundException as it picks words from file for the game so file may not be present.
   */
  public String chooseSecretWord() throws FileNotFoundException
  {
    try 
    {
      //opening a file to get input
      File inputFile = new File("words.txt");
      final int SIZE_OF_ARRAY = 100;
      Scanner scan = new Scanner(inputFile);
      String[] secretWordsCollection = new String[SIZE_OF_ARRAY] ;
      int indexOfWords = 0;
      
      // making a collection of words for random selection.
      while (scan.hasNext())
      {
        secretWordsCollection[indexOfWords] = scan.next();
        indexOfWords++;
      }
      
      // returning a random word from the collection.
      return secretWordsCollection[ ( int ) ( Math.random() * indexOfWords ) ];
    }
    catch(FileNotFoundException ex)
    {
      // making a collection of words for random selection.
      String[] secretWordsCollection = { "apple" , "university" , "student" , "atmosphere" , "english" , "computer" , "mathematics" };
      
      // returning a random word from the collection.
      return secretWordsCollection[ ( int ) ( Math.random() * secretWordsCollection.length ) ];
    }
    
  }
  
  
//Getter methods
  /**
   * method returns all letters(alphabet)
   * @return string of all letters
   */
  public String getAllLetters()
  {
    return allLetters.toString();
  }
  
  /**
   * method returns all used letters
   * @return string of used letters
   */
  public String getUsedLetters()
  {
    return usedLetters.toString();
  }
  
  /**
   * method returns number of incorrect tries
   * @return integer
   */
  public int getNumOfIncorrectTries()
  {
    return numberOfIncorrectTries;
  }
  
  /**
   * method returns maximum number of allowed incorrect tries
   * @return integer
   */
  public int getMaxAllowedIncorrectTries()
  {
    return maxAllowedIncorrectTries;
  }
  
  /**
   * method returns all letters found so far
   * @return string 
   */
  public String getKnownSoFar()
  {
    return knownSoFar.toString();
  }
}
