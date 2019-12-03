package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import processing.core.*;
import org.junit.Before;

public class SwarmTest extends App {

@Before
public void init() {
    PApplet.runSketch(new String[] {"", ""}, this);
    }

@Test
public void TestSwarmConstruction(){
    Swarm swarm = new Swarm(invaderImage);
    assertNotNull(swarm);
}

}
