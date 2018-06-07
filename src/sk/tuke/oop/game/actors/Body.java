/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author Peter
 */
public class Body extends AbstractActor implements Usable {
   
    
    public Body(){
        super("body");
        
         int x,y;
         Animation animation;
         BackpackImpl backpackBody;
         
        animation = new Animation("resources/sprites/body.png", 64,48,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x= 300;
        y=50;
        setPosition(x,y);
        backpackBody = new BackpackImpl(3);
        Hammer h = new Hammer();
        backpackBody.add(h);
       
    }
    
    @Override
    public void act() {
        
    }
    
    @Override
    public void use(Actor actor) {
        
     
    }    
}
