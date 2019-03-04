import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Lobster extends Actor implements Janken
{
  int r;
  public void act()
  {
    boolean edge = isAtEdge();
    boolean touch = isTouching(null);

    if (edge)
    {
      turn(180);
      move (10);
    }

    else
    {
      if ( touch )
      {
        Actor foo = touch_act (this);

        if (foo instanceof Janken)
        {
          Janken jnk = (Janken) foo;

          while (true)
          {
            this.pon();

            if(syoubu(jnk.hand(), this.hand()) != 0)
              break;
          }

          if (syoubu(jnk.hand(), this.hand()) == 2)
          {
            this.turn(75);
            this.move(10);
          }
        }
      }

      else
      {
        move (1);
      }
    }
  }


  public Actor touch_act(Actor me)
  {
    double tmp_i = Integer.MAX_VALUE;
    Actor act = null;

    for (Actor actors: get_World().actor_list)
    {
      double act_X = Math.abs(actors.getX() - me.getX());
      double act_Y = Math.abs(actors.getY() - me.getY());

      if (Math.abs(act_X + act_Y) != 0)
        if (Math.abs(act_X + act_Y) < tmp_i)
        {
          tmp_i = Math.abs(act_X + act_Y);
          act = actors;
        }
    }

    return act;
  }


  public int syoubu (int i, int l)
  {
    int tmp = -1;

    if (i == l)
      tmp = 0;

    else if ((i + 1) % 3 == l)
      tmp = 1;

    else
      tmp = 2;

    return tmp ;
  }


  @Override
  public void pon()
  {
    r = new java.util.Random().nextInt(3);
  }


  @Override
  public int hand()
  {
    return r;
  }
}
