package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class TankTest extends App {

  @Before
  public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
  }

  @Test
  public void testTankConstruction() {
    Tank tank = new Tank(tankImage);
    assertNotNull(tank);
  }

  @Test
  public void testTankCanFire() {
    Tank tank = new Tank(tankImage);
    assertTrue(tank.fireable);
  }

  @Test
  public void testTankMovement(){
    Tank tank = new Tank(tankImage);
    assertEquals(tank.x, 309);
    tank.move(20);
    assertEquals(tank.x, 329);
    tank.move(1000);
    assertEquals(tank.x, 438);
    tank.move(-1000);
    assertEquals(tank.x, 180);
  }

}
