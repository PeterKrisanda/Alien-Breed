/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;


/**
 *
 * @author Peter
 */
public class Locker extends AbstractActor implements Usable {
    
    //private ActorFactoryImpl factory;
    
    public Locker(){
       super("locker");
        Animation animation;
        animation = new Animation("resources/sprites/locker.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
    }

    @Override
    public void act() {
        
    }

    @Override
    public void use(Actor actor) {
        //factory.create(null, ((Hammer) actor).getName());
        
    }
    
}
