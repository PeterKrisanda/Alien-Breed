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
public class Money extends AbstractActor implements Item, Usable{

    
    
    public Money(){
        super("money");
        
        Animation animation;
        int x;
        int y;
        
        animation = new Animation("resources/sprites/money.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 350;
        y = 80;
        setPosition(x,y);
    }
    
    @Override
    public void act() {
        for( Actor actor : getWorld() ){
            if( (intersects(actor)) && (actor instanceof Ripley)){
                     Ripley ripley = (Ripley) actor;
                     
                     
                     if(ripley.getAmmo() < 100){
                       ripley.setMoney(ripley.getMoney()+250);
                        getWorld().removeActor(this);
                     }
            break;
            }                 
        }
    }

    @Override
    public void use(Actor actor) {
       
    }
    
}
