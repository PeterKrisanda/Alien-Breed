/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author Peter
 */
public class Wrench extends AbstractActor implements Item {

    
    
    public Wrench(){
        super("wrench");
        
        Animation animation;
        int x;
        int y;
        
        animation = new Animation("resources/sprites/wrench.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 300;
        y = 120;
        setPosition(x,y);
    }
    
    @Override
    public void act() {
        
    }
    
}
