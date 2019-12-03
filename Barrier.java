package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Barrier extends Sprite{


  public Barrier(int x, int y, List<PImage> img){
    super(x, y, 8, 8 , img, 3, 0);

  }

  @Override
  public void draw(App app){
    app.image(this.getImage(), x, y, width, height);
  }

  public PImage getImage() {
    return this.images.get(3 - this.HP);
  }




}
