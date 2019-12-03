package invadem;
import java.util.List;
import java.util.ArrayList;
//import processing.core.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.util.concurrent.TimeUnit;
import java.lang.Math;

public class App extends PApplet {
    Tank tank;
    PImage tankImage;
    List<Integer> keyboard;
    Swarm invader;
    List<PImage> invaderImage;
    Bento barrier1;
    Bento barrier2;
    Bento barrier3;
    List<PImage> leftImages;
    List<PImage> rightImages;
    List<PImage> solidImages;
    List<PImage> topImages;
    List<Projectile> projectiles;
    PImage projectileImage;
    PImage bigProjectileImage;
    PImage gameover;
    PImage nextlevel;
    int gameStartFrame;
    String gameState;
    int level = 1;
    int score = 0;
    int highscore = 10000;
    PFont font;


    public App() {


        //Set up your objects
    }

    public void setup() {
        frameRate(60);
        tankImage = loadImage("tank1.png");
        tank = new Tank(tankImage);
        keyboard = new ArrayList();
        invaderImage = new ArrayList();
        invaderImage.add(loadImage("invader1.png"));
        invaderImage.add(loadImage("invader2.png"));
        invaderImage.add(loadImage("invader1_armoured.png"));
        invaderImage.add(loadImage("invader2_armoured.png"));
        invaderImage.add(loadImage("invader1_power.png"));
        invaderImage.add(loadImage("invader2_power.png"));
        invader = new Swarm(invaderImage);
        leftImages = new ArrayList();
        rightImages = new ArrayList();
        topImages = new ArrayList();
        solidImages = new ArrayList();
        leftImages.add(loadImage("barrier_left1.png"));
        leftImages.add(loadImage("barrier_left2.png"));
        leftImages.add(loadImage("barrier_left3.png"));
        leftImages.add(loadImage("empty.png"));
        topImages.add(loadImage("barrier_top1.png"));
        topImages.add(loadImage("barrier_top2.png"));
        topImages.add(loadImage("barrier_top3.png"));
        topImages.add(loadImage("empty.png"));
        rightImages.add(loadImage("barrier_right1.png"));
        rightImages.add(loadImage("barrier_right2.png"));
        rightImages.add(loadImage("barrier_right3.png"));
        rightImages.add(loadImage("empty.png"));
        solidImages.add(loadImage("barrier_solid1.png"));
        solidImages.add(loadImage("barrier_solid2.png"));
        solidImages.add(loadImage("barrier_solid3.png"));
        solidImages.add(loadImage("empty.png"));
        barrier1 = new Bento(200, 420, leftImages, topImages, rightImages, solidImages);
        barrier2 = new Bento(308, 420, leftImages, topImages, rightImages, solidImages);
        barrier3 = new Bento(416, 420, leftImages, topImages, rightImages, solidImages);
        gameover = loadImage("gameover.png");
        nextlevel = loadImage("nextlevel.png");
        font = createFont("PressStart2P-Regular.tff", 16);
        textFont(font);


        projectileImage = (loadImage("projectile.png"));
        bigProjectileImage = loadImage("projectile_lg.png");
        projectiles = new ArrayList();

        gameStartFrame = frameCount - 1;

        gameState = "playing";
    }

    public void settings() {
        size(640, 480);
    }

    public void draw() {
        if (gameState.equals("gameover") || gameState.equals("nextlevel")) {
          delay(3000);
          setup();
        }
        background(0);
        textAlign(LEFT, TOP);
        text("Current Score: " + score, 0, 0);
        textAlign(RIGHT, TOP);
        text("High Score: " + highscore, width, 0);
        //Main Game Loop

        if ((frameCount - gameStartFrame) % (Math.max(6 - level, 1) * 60) == 0) {
          invader.invaders.get((int)(Math.random() * invader.invaders.size())).shoot(this);
        }

        if(keyboard.contains(37)) {
          tank.move(-1);

        }
        if(keyboard.contains(39)){
          tank.move(1);
        }

        tank.draw(this);
        invader.move(this);
        invader.draw(this);
        barrier1.draw(this);
        barrier2.draw(this);
        barrier3.draw(this);



        for(int i = 0; i < projectiles.size(); i++){
          projectiles.get(i).move(this);
          projectiles.get(i).collide(this);
          projectiles.get(i).draw(this);
        }
        projectiles.removeIf(n -> n.HP <= 0);
        invader.invaders.removeIf(n -> n.HP <= 0);

        if (invader.invaders.size() == 0) {
          level += 1;
          gameState = "nextlevel";
          background(0);
          image(nextlevel, 264, 202, 112, 16);
        } else if (tank.HP == 0 || invader.invaders.get(invader.invaders.size() - 1).y >= 394) {
          gameState = "gameover";
          background(0);
          image(gameover, 264, 202, 112, 16);
          if (score > highscore) {
            highscore = score;
            score = 0;
          }
        }

    }

    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }

    public void keyPressed(){
      if(keyboard.contains(keyCode) != true){
        keyboard.add(keyCode);
      }
      if(keyboard.contains(32) && tank.fireable){
        tank.fire(this);
        tank.fireable = false;
      }
    }

    public void keyReleased(){
      keyboard.remove(Integer.valueOf(keyCode));
      if (keyCode == 32){
        tank.fireable = true;

      }

    }




}
