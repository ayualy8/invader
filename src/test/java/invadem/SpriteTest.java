package invadem;
import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class SpriteTest extends App {

  @Before
  public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
  }

  @Test
  public void TestSpriteKill(){
    Invader inv = new Invader(0, 0, invaderImage, 0, 0, 1);
    inv.kill();
    assertEquals(inv.HP, 0);
  }

  @Test
  public void TestCollision(){
    Invader inv = new Invader(0, 0, invaderImage, 0, 0, 1);
    assertTrue(inv.collision(this, 0, 0, 1, 1, 0));
    assertTrue(inv.collision(this, 16, 16, 1, 1, 0));
    assertFalse(inv.collision(this, -1, -1, 1, 1, 0));
    assertFalse(inv.collision(this, 17, 17, 1 , 1, 0));
  }


}
