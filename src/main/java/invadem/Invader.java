package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Invader extends Sprite{
  int count;
  boolean right;
  boolean moving;
  int type;


  public Invader(int x, int y, List<PImage> img, int type, int score, int HP){
    super(x,  y, 16, 16, img, HP, score);
    count = 15;
    right = true;
    moving = true;
    this.type = type;

  }




  public void move(App app){
    if(moving){
      count ++;
      if(count < 30 && right){
        this.x += 1;
      } else if(count < 30 && right == false) {
        this.x -= 1;
      } else if(count < 37){
        this.y += 1;
      } else {
        this.y += 1;
        right = !(right);
        count = 0;
      }
      moving = false;
    } else {
      moving = true;
    }

  }

  @Override
  public void draw(App app){
    if (count < 30) {
      app.image(images.get(0 + ((this.type - 1) * 2)), x, y, width, height);
    } else {
      app.image(images.get(1 + ((this.type - 1) * 2)), x, y, width, height);
    }
  }

  public void shoot(App app){
    if (this.type == 3) {
      app.projectiles.add(new Projectile(app.bigProjectileImage, this.x+8, this.y+16, 3, 1));
    } else {
      app.projectiles.add(new Projectile(app.projectileImage, this.x+8, this.y+16, 1, 1));
    }
  }

}
