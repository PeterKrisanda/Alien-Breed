/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author Peter
 */
public class Cooler extends AbstractActor implements Usable {

    private final Animation animation;
    private boolean jePokazeni;
    
    public Cooler(){
        
        super("cooler");
        int x;
        int y;
        animation = new Animation("resources/sprites/fan.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        animation.stop();
        jePokazeni = false;
        
    }
    
    @Override
    public void use(Actor actor) {
        if(intersects((Ripley) actor) && (jePokazeni == false) && ((Ripley) actor).getBackpack().getLastItem() instanceof Wrench ){
            
            oprav();
        }
        
    }
    
    public void oprav(){
            animation.start();
            jePokazeni = true;
    }

    @Override
    public void act() {
       
    }
    
}
