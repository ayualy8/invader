package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;


public class Swarm{
  List<Invader> invaders;


  public Swarm(List<PImage> invadersImages){
    invaders = new ArrayList();

    for(int j = 0; j < 4; j ++){
      for(int i = 0; i < 10; i ++){
        if (j == 0) {
          invaders.add(new Invader((194+(i*26)), (j*26), invadersImages, 2, 250, 3));
        } else if (j == 1) {
          invaders.add(new Invader((194+(i*26)), (j*26), invadersImages, 3, 250, 1));
        } else {
          invaders.add(new Invader((194+(i*26)), (j*26), invadersImages, 1, 100, 1));
        }

      }
    }
  }

  public void draw(App app){
    for(Invader i : invaders){
      i.draw(app);
    }
  }
  public void move(App app){
    for(Invader i : invaders){
      i.move(app);
    }
  }
  public boolean collide(App app, int x, int y, int w, int h, int dmg) {
    for(Invader i : invaders){
      if (i.collision(app, x, y, w, h, dmg)) {
        return true;
      }
    }
    return false;
  }




}
