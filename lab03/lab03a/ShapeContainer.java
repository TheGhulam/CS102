import java.util.*;

//ShapeContainer class
public class ShapeContainer
{
  //properties
  private double totalArea;
  private ArrayList<Shape> container;
  
  //constructors
  public ShapeContainer()
  {
    totalArea = 0;
    container = new ArrayList<Shape>();
  }
  
  //methods
  
  /**
 * The total area of all the shapes.
 * @return totalArea which is the area of all the shapes.
 */
  public double getArea()
  {
//    for (Shape z : container)
//    {
//      totalArea = totalArea + z.getArea();
//    }
    Iterator i = new ShapeContainerIterator(this);
    
    while(i.hasNext() )
    {
      totalArea = totalArea + ((Shape) i.next()).getArea();
    }
    
    if (container.isEmpty())
      System.out.println("Since no shape has been entered area is zero.");
    
    return totalArea;
  }
  
  /**
 * The to String methods.
 * @return String which has all info
 */
  public String toString()
  {
    String info = "|";
    int i = 1;
    
    for (Shape z : container)
    {
      info = info + " " + i + "- " + z.toString() + "|";
      i++;
    }
    if (container.isEmpty())
      info = "no shapes available";
    
    return info;
  }
  
  /**
 * Adding shapes in arrayList.
 * @param s is the shape that is being added.
 */
  public void add(Shape s)
  {
    container.add(s);
  }
  
  /**
 * Sets location of the shape.
 * @param shapeNum as the shape number to identify it.
 * @param x as the x co ordinate 
 * @param y as the y co ordinate  
 */
  public void setLocation(int shapeNum, int x, int y)
  {
    container.get(shapeNum).setLocation(x, y);
  }
  
  /**
 * Whether point is contained in the shape or not.
 * @param x is the x coordinate of the point
 * @param y is the y coordinate of the point
 * @return shape which contains that point
 */
  public Shape contains(int x, int y)
  {
     for (Shape z : container)
    {
       Selectable s = (Selectable)z;
       
      if ((s != null) && (s.contains(x,y) != null))
      {
        return (Shape)s.contains(x,y);
      }
    }
    if (container.isEmpty())
      System.out.println("There is no shape available to check from.");
    return null;
    
  }
 
  /**
 * Deletes all selected shapes.
 */
  public void deleteShapes()
  {
    for (int i = 0; i < container.size(); i++)
    {
       Selectable s = (Selectable)container.get(i);
       
      if ((s != null) && (s.getSelected()))
      {
      container.remove(i);
      }
      
    }
    if (container.isEmpty())
      System.out.println("There is no shape available to check from.");
  }
  
  /**
 * Gives back shape at that position in arraylist.
 * @param location gives location at which shape required is present
 * @return shape which is specified
 */
  public Shape getShape(int location)
  {
    return container.get(location);
  }
  
  /**
 * Shows size of the arraylist.
 * @return int size of arraylist
 */
  public int size()
  {
    return container.size();
  }
  
}