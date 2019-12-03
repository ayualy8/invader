package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Bento{
  Barrier top1;
  Barrier top2;
  Barrier top3;
  Barrier right;
  Barrier left;
  Barrier bottom1;
  Barrier bottom2;



  public Bento(int x, int y, List<PImage> image1,List<PImage> image2, List<PImage> image3, List<PImage> image4){
    top1 = new Barrier(x, y,  image1);
    top2 = new Barrier(x+8, y,  image2);
    top3 = new Barrier(x+16, y,  image3);
    right = new Barrier(x, y+8,  image4);
    left = new Barrier(x+16, y+8, image4);
    bottom1 = new Barrier(x, y+16, image4);
    bottom2 = new Barrier(x+16, y+16, image4);

  }

  public void draw(App app){
    top1.draw(app);
    top2.draw(app);
    top3.draw(app);
    right.draw(app);
    left.draw(app);
    bottom1.draw(app);
    bottom2.draw(app);
  }






}
