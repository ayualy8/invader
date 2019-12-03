package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class BarrierTest extends App {

  @Before
  public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
  }

   @Test
   public void barrierConstruction() {
       Barrier b = new Barrier(0, 0, topImages);
       assertNotNull(b);
   }

   @Test
   public void barrierImages() {
       Barrier b = new Barrier(0, 0, topImages);
       assertEquals(b.HP, 3);
       for (int i = 2; i >= 0; i--) {
         b.collision(this, 0, 0, 1, 1, 1);
         assertEquals(b.HP, i);
       }
   }


}
