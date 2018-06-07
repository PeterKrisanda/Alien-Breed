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
public class Cables extends AbstractActor implements Usable, Item {

    public Cables(){
        super("cables");
        Animation animation;
         int x;
        int y;
        animation = new Animation("resources/sprites/cables.png", 48,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
    }
    
    @Override
    public void act() {
        
    }

    @Override
    public void use(Actor actor) {
      
        
    }
    
}
