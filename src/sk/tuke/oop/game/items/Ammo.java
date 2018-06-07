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
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Peter
 */
public class Ammo extends AbstractActor implements Item {
    
    
    
    public Ammo(){
        super("ammo");
        
         Animation animation;
         int x;
         int y;
        
        animation = new Animation("resources/sprites/ammo.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 450;
        y = 250;
        setPosition(x,y);
    }
    
    @Override
    public void act() {
         for( Actor actor : getWorld() ){
            if( (intersects(actor)) && (actor instanceof Ripley)){
                     Ripley e = (Ripley) actor;
                      
                     if(e.getAmmo() < 100){
                        e.setAmmo(e.getAmmo()+10);
                        getWorld().removeActor(this);
                     }
            break;
            }                 
        }
    }
    
}
