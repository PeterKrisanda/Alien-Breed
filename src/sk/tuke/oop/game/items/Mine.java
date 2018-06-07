/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author Peter
 */
public class Mine extends AbstractActor implements Usable, Item {

    private final Animation explosion;
    private int i;
    
    public Mine(){
        super("mine");
        
        Animation animation;
         int x;
        int y;
        explosion = new Animation("resources/sprites/small_explosion.png", 16,16,100);
        animation = new Animation("resources/sprites/mine.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        i=0;
      
    }
    
    public Animation getExplosion(){
        return explosion;
    }
    
    @Override
    public void act() {
       if(getAnimation()==explosion){
           i++;
       }
       if(i>=100){
           getWorld().removeActor(this);
       }
    }

    @Override
    public void use(Actor actor) {
         setAnimation(explosion);
   
    }
    
}
