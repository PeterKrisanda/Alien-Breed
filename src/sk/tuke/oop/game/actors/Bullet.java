/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;


import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Move;


/**
 *
 * @author Peter
 */
public class Bullet extends AbstractActor implements Movable {
    
    
    private Ripley ripley;
    private int x,y;
   
    private final Move left,right,up,down;
    private int angle ;
    private boolean zasiahla;
    
    
    public Bullet(String name){
        super(name);
        Animation animation;
        animation = new Animation("resources/sprites/bullet.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        setPosition(x,y);
        up = new Move(this, 8, 0,-1);
        down = new Move(this, 8, 0, 1);
        left = new Move(this, 8, -1, 0);
        right = new Move(this, 8, 1, 0);
        this.angle = 0;
        this.zasiahla = false;
        
    }
    
    public int getRotation(){
        return angle;
    }
    
    public void setRotation(int angle){
        this.angle = angle;
    }

    @Override
    public void act() {
       stret(ripley);
    }
    
    public void stret(Ripley ripley){
       
        pohyb();
        pohybDiagonal();        
        
        if ( zasiahla){
            getWorld().removeActor(this);
        }
    }
    
    public void zasah(){
        zasiahla = true;
    }
    
    public void pohyb(){
        if(getAnimation().getRotation() == 180){
            down.execute();
        }
        if(getAnimation().getRotation() == 0){
            up.execute();
        }
        if(getAnimation().getRotation() == 90){
            right.execute();
        }
        if(getAnimation().getRotation() == 270){
            
            left.execute();
        }
    }
    
    public void pohybDiagonal(){
        if(getAnimation().getRotation() == 225){
            left.execute();
            down.execute();
        }
        if(getAnimation().getRotation() == 45){
            right.execute();
            up.execute();
        }
        if(getAnimation().getRotation() == 315){
            left.execute();
            up.execute();
        }
        if(getAnimation().getRotation() == 135){
            right.execute();
            down.execute();
        }
    }
            
}