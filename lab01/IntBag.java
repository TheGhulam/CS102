// Int Bag class
public class IntBag
{
  // properties
  private int[] bag;
  private int valid;
  
  // constructors
  //no inputs 
  public IntBag()
  {
    bag = new int[100];
    for (int j = 0; j < 100; j++)
    {
      bag[j] = 0;
    }
    valid = 0;
  }
  //
  public IntBag(int maxParameter)
  {
    bag = new int[maxParameter];
    for (int j = 0; j < maxParameter; j++)
    {
      bag[j] = 0;
    }
    valid = 0;
  }
  
  // methods
  
  /**
   * To string method of class.
   * @return string with class data.
   */
  public String toString() 
  {
    String output;
    output = "[";
    for (int i = 0; i <= valid - 2; i++)
    {
      output = output + bag[i] + ", ";
    }
    if (valid > 0)
      output = output + bag[valid - 1];
    output = output + "]";
    return output;
  }
  
  
  /**
   * Adds data to top end of array.
   * @param data is data that has to be added.
   */
  public void add(int data) 
  {
      bag[valid] = data;
      valid++;
  }
  
  
  /**
   * Adds data at given location in array.
   * @param data is data that has to be added.
   * @param location is the location in array. 
   */
  public void add(int data, int location) 
  {
    if (location > valid)
    {
      System.out.println("You cannot add in location that is not present.");
    }
    else
    {
      for (int j = valid - 1; j >= location; j--)
      {
        bag[j + 1] = bag[j];
      }
      bag[location] = data;
      valid++;
    }
  }
  
  /**
   * Removes data in array at given location.
   * @param location is location in the array.
   */
  public void remove(int location) 
  {
    for (int j = location; j < valid - 1; j++)
    {
      bag[j] = bag[j + 1];
    }
    bag[valid - 1] = 0;
    valid--;
  }
  
  
  /**
   * Checks availability of data in array.
   * @param data id data that has to be checked. 
   * @return boolean if data avilable or not.
   */
  public boolean contains(int data) 
  {
    for(int i : bag)
    {
      if(i == data)
        return true;
    }
    return false;
  }
  
  
  /**
   * Gives the size of Array.
   * @return int size of array.
   */
  public int size() 
  {
    return valid;
  }
  
  /**
   * Gets value in array at given location.
   * @param location is the location in array. 
   * @return int value in array at location.
   */
  public int getValue(int location) 
  {
    return bag[location];
  }
  
   /**
   * Finds indexes of locations in array for given data.
   * @param value is the data to be found.
   * @return IntBag which has the locations of given number stored.
   */
  public IntBag findAll(int value) 
  {
    IntBag locations = new IntBag();
    if (contains(value))
    {
      for (int i = 0; i < valid; i++)
      {
        if (getValue(i) == value)
        {
          locations.add(i);
        }
      }
    }
    return locations;
  }
}
