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
public class Laser extends AbstractActor {
    
    private final Animation animation;
    private int i;
    
    public Laser(){
        super("laser");
        
         int x;
        int y;
        animation = new Animation("resources/sprites/laser.png", 16,48,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        this.i=0;
    
    }
    
    
    @Override
    public void act() {
       i++;
       if(i<100){
           animation.stopAt(3);
           animation.start();
           lasserAttack();
       } 
       if(i > 100 && i<200){
           animation.stopAt(0);
           animation.start();
           if(i==199){
            i=0;
           }
       }
        
        
    }
     
    public void lasserAttack(){
          for(Actor actor : getWorld()){
                if(intersects(actor) && actor instanceof Ripley){
                    Ripley ripley = (Ripley) actor;
                    ripley.setEnergy(ripley.getEnergy() - 2);
                }
           }    
    }
   
    
}
