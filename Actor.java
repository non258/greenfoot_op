import java.util.*;
import java.awt.*;
import java.math.*;
import javax.swing.*;

class Actor
{
  private int setActX = 0;
  private int setActY = 0;
  private double _x = 0;
  private double _y = 0;
  private int actSizeX = 100;
  private int actSizeY = 100;
  private double turn = 0;
  JLabel label;


  public Actor()
  {
    ImageIcon icon1 = new ImageIcon("./wombat.png");
    this.label = new JLabel(icon1);
    this.label.setBounds(0, 0, this.actSizeX, this.actSizeY);
  }

  public void act()
  {

  }


  public double getX() throws java.lang.IllegalStateException
  {
    return this._x;
  }

  public double getY() throws java.lang.IllegalStateException
  {
    return this._y;
  }

  public boolean isAtEdge()
  {
    double x = this._x;
    double y = this._y;
    int wx = World.xWindowSize;
    int wy = World.yWindowSize;
    int sx = this.actSizeX;
    int sy = this.actSizeY;

  // 右端に衝突した
  // ------------------------------------------------------------
    if (x >= wx - 75)
    {
      return true;
    }
  // ------------------------------------------------------------

  // 左端に衝突した際
  // ------------------------------------------------------------
    if (0 > x + 25)
    {
      return true;
    }
  // ------------------------------------------------------------

  // 上に衝突した際
  // ------------------------------------------------------------
    if (0 > y + 25)
    {
      return true;
    }
  // ------------------------------------------------------------

  // 下に衝突した際
  // ------------------------------------------------------------
    if (wy <= y + 100)
    {
      return true;
    }
  // ------------------------------------------------------------

    return false;
  }

  public void init(int x, int y)
  {
    this._x = x;
    this._y = y;
  }

  public void setLocation(int x, int y)
  {
    this.label.setBounds(x, y, 100, 100);
    World.p.add(label);
  }

  public void move(int distance)
  {
      this._x += distance * (Math.cos(this.turn));
      this._y += distance * (Math.sin(this.turn));

      this.setActX = (int)this._x;
      this.setActY = (int)this._y;

      this.setLocation(this.setActX, this.setActY);
  }

  public void turn(int amount)
  {
    double rad = Math.toRadians(amount);
    this.turn += rad;
  }

  public World get_World()
  {
    return Main.w;
  }

  protected <A> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls)
  {
    java.util.List<A> cls_list = new ArrayList<A>();
    for (Actor act: World.actor_list)
    {
      A tmp = (A) act;
      if (tmp == cls)
      cls_list.add(tmp);
    }
    return cls_list;
  }

  protected boolean isTouching(java.lang.Class<?> cls)
  {
    boolean touch = World.isTouching(this);
    return touch;
  }

}
