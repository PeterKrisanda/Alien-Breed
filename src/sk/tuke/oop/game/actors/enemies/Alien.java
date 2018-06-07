package sk.tuke.oop.game.actors.enemies;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author Peter
 */
public class Alien extends AbstractCharacter implements Enemy, Movable{
   
    private int r1;
    private Random r;
    
    private int j;
    private final Move up, down, left, right;    
    
    public Alien(String name){
       super(name);
       
       Animation animation;
       int x;
       int y;
       int dx, dy;
       int step;
       int energy;
       this.j = 0;
        animation = new Animation("resources/sprites/warrior_alien.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x= 200;
        y=200;
        step = 2;
        energy = 100;
        dx = 0; 
        dy = 0;
        up = new Move(this, step, dx,dy-1);
        down = new Move(this, step, dx, dy+1);
        left = new Move(this, step, dx-1, dy);
        right = new Move(this, step, dx+1, dy);
        setPosition(x,y);
        setEnergy(energy);
    }

   

    @Override
    public void act() {
    
        j++;
        if(j == 50){
         r = new Random();
             r1 = r.nextInt(9);
             j=0;
        } 
            
                pohybY();
                pohybX();
                pohybXY();
                umieranie();
                utok();
              
    }
    
    public void utok(){
        for(Actor actor : getWorld()){
            if(intersects(actor) && actor instanceof Ripley){
                Ripley ripley = (Ripley) actor;
                ripley.setEnergy(ripley.getEnergy()-1);
            }
        }
    }
    
    public void umieranie(){
        for(Actor actor : getWorld()){
            if(intersects(actor) && actor instanceof Bullet){
                Bullet bullet = (Bullet) actor;
                bullet.zasah();
                setEnergy(getEnergy() - 50);
            }
            
        }
        if(getEnergy() <=0){
            getWorld().removeActor(this);
        }
    }
    
    public void pohybX(){
        if(r1 == 0){
            left.execute();
        }
        if(r1 == 1){
            right.execute();
        }
    }
    
    public void pohybY(){
        if(r1 == 2){
            up.execute();
        }
        if(r1 == 3){
            down.execute();
        }
    }
    
    public void pohybXY(){
        if(r1 == 4){
            up.execute();
            right.execute();
        }
        if(r1 == 5){
            right.execute();
            down.execute();
        }
        if(r1 == 6){
            down.execute();
            left.execute();
        }
        if(r1 == 7){
            left.execute();
            up.execute();
        }
     }
    
}
