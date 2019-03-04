import java.util.*;
import java.awt.*;
import javax.swing.*;

class Wombat extends Actor
{
  @Override
  public void act()
  {
    if (isAtEdge())
    {
      turn(75);
    }

    move(1);
  }

}
