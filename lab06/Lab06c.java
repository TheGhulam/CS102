import java.util.*;
/**
 * __Lab06c___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __17-04-2018__
 */ 

public class Lab06c
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner(System.in);
    final int STARTPOSITION = 0;
    ArrayList<String> list = new ArrayList<String>();
    
    list.add("ali");
    list.add("hamza");
    list.add("talal");
    list.add("usman");
    list.add("umer");
    
    System.out.println(orderList(list, STARTPOSITION));
  }
  /**
     * Finds if list is alphabetically ordered.
     * @param list is the list of names required.
     * @param i is the StartPlace in the list to start searching.
     * @return check is the boolean returned when ordered.
     */
  public static boolean orderList(ArrayList<String> list, int i)
  {
    boolean check = true;
    if (i < list.size() - 1)
    {
    if (list.get(i).compareTo(list.get(i + 1)) > 0)
      check = false;
    i++;
    if (check)
      check = orderList(list, i);
    }
    return check;
  }
}