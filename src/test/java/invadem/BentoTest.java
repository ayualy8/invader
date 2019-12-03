package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class BentoTest extends App {

  @Before
  public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
  }

  @Test
  public void TestBentoConstruction(){
    Bento bento = new Bento(0, 0, leftImages, rightImages, solidImages, topImages);
    assertNotNull(bento);
  }
}
