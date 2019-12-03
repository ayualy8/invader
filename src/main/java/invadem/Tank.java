package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Tank extends Sprite{
  boolean fireable = true;
  int shotCount;


  public Tank(PImage img){
    super(309, 464, 22, 16, img, 3, 0);
    this.shotCount = 0;
  }


  public void move(int x){
    this.x += x;

    if(this.x <= 180){
      this.x = 180;
    } else if( this.x >= 438){
      this.x = 438;
    }
  }

  public void fire(App app){
    this.shotCount+=1;
    if (this.shotCount % 3 == 0) {
      app.projectiles.add(new Projectile(app.bigProjectileImage, this.x+11, this.y, 3, -1));
    } else {
      app.projectiles.add(new Projectile(app.projectileImage, this.x+11, this.y, 1, -1));
    }

  }





}
