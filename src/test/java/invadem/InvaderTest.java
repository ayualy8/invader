package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class InvaderTest extends App {

  @Before
  public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
  }

   @Test
   public void testInvaderConstruction() {
       Invader inv = new Invader(0, 0, invaderImage, 0, 100, 1);
       assertNotNull(inv);
   }

   @Test
   public void testInvaderMovement() {
       Invader inv = new Invader(16, 0, invaderImage, 0, 100, 1);
       assertEquals(inv.x, 16);
       assertEquals(inv.y, 0);
       for (int i = 0; i < 44; i++) {
         inv.move(this);
       }
       assertEquals(inv.x, 30);
       assertEquals(inv.y, 8);
       for (int i = 0; i < 76; i++) {
         inv.move(this);
       }
       assertEquals(inv.x, 2);
       assertEquals(inv.y, 16);
   }

}
