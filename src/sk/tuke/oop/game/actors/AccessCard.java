/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;

/**
 *
 * @author Peter
 */
public class AccessCard extends AbstractActor implements Item,Usable {

   
    
    public AccessCard(){
        super("access card");
        Animation animation;
        animation = new Animation("resources/sprites/key.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
    }
    
    @Override
    public void act() {
       
    }

    @Override
    public void use(Actor actor) {
       
    }
    
}
