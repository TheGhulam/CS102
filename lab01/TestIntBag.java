import java.util.Scanner;

/**
 * __Testing the INT Bag___ 
 * @author __Mian Usman Naeem Kakakhel___
 * @version __12-02-2018__
 */ 
public class TestIntBag
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);
    
    // constants
    
    // variables
    IntBag bag1 = new IntBag();
    IntBag bag2 = new IntBag(5);
    
    
    // program code
    
    
    System.out.println(bag1.toString());
    System.out.println(bag2.toString());
    
    bag1.add(9,0);
    bag1.add(6);
    bag1.add(90);
    bag1.add(1234);
    
    System.out.println(bag1.toString());
    
    bag1.add(767676,2);
    System.out.println(bag1.toString());
    bag1.remove(1);
    System.out.println(bag1.toString());
    
  }
  
}