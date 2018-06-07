/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Peter
 */
public class Computer extends Desktop implements Usable {

    public Computer(){
       
        Animation animation;
        int x;
        int y;
        animation = new Animation("resources/sprites/desk.png", 48,48,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        animation.setRotation(180);
    }
    
    @Override
    public void act() {
       
    }

    @Override
    public void use(Actor actor) {
         if(intersects(actor) && actor instanceof Ripley){    
                   prepnut();
            } 
    }
    
    public void prepnut(){
        for(Actor actors:getWorld()){
                    if(actors instanceof Engine){
                        Engine engine = (Engine) actors;
                        engine.prepinac();
                    }
                }           
    }
}
