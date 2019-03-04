import java.util.*;
import java.awt.*;
import javax.swing.*;

class World extends JFrame
{
  static java.util.List<Actor> actor_list = new ArrayList<Actor>();
  static int xWindowSize = 500;
  static int yWindowSize = 500;
  static JPanel p;

  public World(String title)
  {
    super.setTitle(title);
    super.setBounds(100, 100, World.xWindowSize, World.yWindowSize);
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    World.p = new JPanel();

    World.p.setLayout(null);

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }

  public void addObject (Actor object, int x, int y)
  {
    object.init(x, y);
    object.setLocation(x, y);
    p.add(object.label);

    World.actor_list.add(object);
  }

  public static boolean isTouching(Actor act)
  {
    double xy = Integer.MAX_VALUE;
    Actor tmp_act;
    for (Actor actors: World.actor_list)
    {
      if (actors == act)
        continue;

      double act_X = Math.abs(actors.getX() - act.getX());
      double act_Y = Math.abs(actors.getY() - act.getY());

      if (act_X <= 50 && act_Y <= 50)
      {
        // System.out.println("true");
        // System.out.println("act.getX: " + act.getX());
        // System.out.println("actors.getX: " + actors.getX());
        // System.out.println("act.getY: " + act.getY());
        // System.out.println("actors.getY: " + actors.getY());
        return true;
      }

    }

    return false;
  }


  public void act()
  {
    while (true)
    {
      try
      {
        Thread.sleep(10);
        for (Actor a : World.actor_list)
        {
          a.act();
        }
      }
      catch(InterruptedException ie)
      {
        System.out.println(ie);
      }
    }
  }

}
