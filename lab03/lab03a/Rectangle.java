//Rcetangle class
public class Rectangle extends Shape implements Selectable
{
//properties
  private int width;
  private int height;
  private boolean selected;
  
  //constructor
  public Rectangle(int width, int height, int x, int y)
  {
    super(x, y);
    this.width = width;
    this.height = height;
    selected = false;
  }
  
  //method
  
  /**
 * The to String methods.
 * @return String which has all info
 */
  public String toString()
  {
    String info = "Shape : Rectangle -- Width : " + width + " -- Height : " + height + " -- Area : " + getArea() + " --Locations = X: " 
      + super.getX() + " and Y: " + super.getY() + " --Is selected: " + selected; 
    return info;
  }
  
  /**
 * Calculates area of the shapes.
 * @return double area value.
 */
  public double getArea()
  {
    return (int) width * height;
  }
  
  /**
 * Whether point is contained in the shape or not.
 * @param x is the x coordinate of the point
 * @param y is the y coordinate of the point
 * @return shape which contains that point
 */
  public Shape contains(int x, int y)
  {
    if (((((width / 2) + super.getX()) >= x) && ((super.getX() - (width / 2)) <= x)) && ((((height / 2) + super.getY()) >= y) || ((super.getY() - (height / 2)) <= y)))
      return this;
    else 
      return null;
  }
  
  
  /**
 * Get value of bolean if shape is selected or not.
 * @return boolean value of selected
 */
  public boolean getSelected()
  {
   return selected;
  }
  
   /**
 * Toggle value of select on the shape.
 * @param a is the boolean to which we have to toggle.
 */
  public void setSelected(boolean a)
  {
    selected = a;
  }
  
}