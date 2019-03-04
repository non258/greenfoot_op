import java.util.*;

class Main
{
  static World w = new World("World");
  public static void main(String[] args)
  {
    Actor janken1 = new Lobster();
    Actor janken2 = new Lobster();
    Actor janken3 = new Lobster();

    w.addObject(janken1, 200, 150);
    w.addObject(janken2, 200, 100);
    w.addObject(janken3, 300, 150);
    w.setVisible(true);

    w.act();

  }
}
