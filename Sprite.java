package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import java.lang.Math;

public abstract class Sprite{
  protected int x;
  protected int y;
  protected int height;
  protected int width;
  protected PImage img;
  protected List<PImage> images;
  protected int HP;
  protected int score;


  public Sprite(int x, int y, int width, int height, PImage img, int HP, int score){
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
    this.img = img;
    this.HP = HP;
    this.score = score;
  }

  public Sprite(int x, int y, int width, int height, List<PImage> images, int HP, int score){
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
    this.images = images;
    this.HP = HP;
    this.score = score;
  }

  public void draw(App app){
    app.image(img, x, y, width, height);
  }

  public boolean collision(App app, int x, int y, int w, int h, int dmg) {
    boolean collides = this.HP > 0 && Math.abs((this.x + this.width/2) - (x + w/2)) <= (this.width + w)/2 &&
           Math.abs((this.y + this.height/2) - (y + h/2)) <= (this.height + h)/2;
    if (collides) {
      this.HP = Math.max(0, this.HP - dmg);
      if (this.HP == 0) {
        app.score += this.score;
      }
    }
    return collides;
  }


  public void kill(){
    this.HP = 0;
  }

}
