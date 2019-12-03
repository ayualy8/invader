package invadem;
import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class ProjectileTest extends App {

  @Before
  public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
  }

   @Test
   public void testProjectileConstruction() {
       this.setup();
       Projectile proj = new Projectile(projectileImage, 0, 0, 0, 0);
       assertNotNull(proj);
   }

   @Test
   public void testProjectileMovement() {
     this.setup();
     Projectile proj = new Projectile(projectileImage, 0, 0, 0, 1);
     assertEquals(proj.y, 0);
     proj.move(this);
     assertEquals(proj.y, 1);
   }

}
