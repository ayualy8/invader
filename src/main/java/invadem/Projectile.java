package invadem;
import java.util.List;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Projectile extends Sprite{
  int velocity;
  int dmg;

  public Projectile(PImage img, int x, int y, int dmg, int vel){
    super(x, y, img.width, img.height, img, 1, 0);
    this.velocity = vel;
    this.dmg = dmg;
  }

  public void move(App app){
    this.y += this.velocity;
  }

  public void collide(App app) {
    boolean collidesWithBarrier1 = app.barrier1.top1.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier1.top2.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier1.top3.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier1.right.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier1.left.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier1.bottom1.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier1.bottom2.collision(app, this.x, this.y, this.width, this.height, this.dmg);

    boolean collidesWithbarrier2 = app.barrier2.top1.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier2.top2.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier2.top3.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier2.right.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier2.left.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier2.bottom1.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier2.bottom2.collision(app, this.x, this.y, this.width, this.height, this.dmg);

    boolean collidesWithbarrier3 = app.barrier3.top1.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier3.top2.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier3.top3.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier3.right.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier3.left.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier3.bottom1.collision(app, this.x, this.y, this.width, this.height, this.dmg) ||
      app.barrier3.bottom2.collision(app, this.x, this.y, this.width, this.height, this.dmg);

    boolean collidesWithInvader = false;
    boolean collidesWithTank = false;
    if (this.velocity < 0) {
      collidesWithInvader = app.invader.collide(app, this.x, this.y, this.width, this.height, this.dmg);
    } else {
      collidesWithTank = app.tank.collision(app, this.x, this.y, this.width, this.height, this.dmg);
    }

    if (collidesWithBarrier1 || collidesWithbarrier2 || collidesWithbarrier3 || collidesWithInvader || collidesWithTank) {
      this.kill();
    }
  }


}
