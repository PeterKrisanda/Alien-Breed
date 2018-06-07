/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Peter
 */
public class Hole extends AbstractActor {
    
    private final Animation animation;
    private int i;
    private boolean otvorena;
    
    public Hole(){
        super("Hole");
     
         int x;
        int y;
        animation = new Animation("resources/sprites/hole.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        animation.stop();
        this.i=0;
        this.otvorena = false;
        
    }

    @Override
    public void act() {
      odpocetSmrti(otvorena);
      pasca();
      diera();
    }
    
    public void diera(){        
         for(Actor actor : getWorld()){
            if(intersectsForDeath(actor) && actor instanceof Ripley){
               Ripley ripley = (Ripley) actor;
                 if(i>=40){
                    ripley.setEnergy(ripley.getEnergy()-100);
                }
            }
        }        
    }
    
    public void pasca(){
        if(otvorena == false){
        for(Actor actor : getWorld()){
            if(intersects(actor) && actor instanceof Ripley){
                otvorena = true;
               
                animation.stopAt(5);
                animation.start();
                 
            }
        }
        }
    }
    
    public void odpocetSmrti(boolean otvorena){
        if(otvorena == true)
        i++;
    }
    
    
    public boolean intersectsForDeath(Actor actor) {
        if( (actor.getX() > (getX()+(getWidth()/4))) || ((actor.getX()+(actor.getWidth()/4)) < getX()) || (actor.getY() > (getY()+(getHeight()/4))) || ((actor.getY()+(actor.getHeight()/4)) < getY())  ){
            return false;
        }else {
            return true;
            
        }
    }
    
    
    
}
