/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Peter
 */
public class Engine extends AbstractActor {

    private boolean hot;
    
    public Engine(){  
        super("engine");
        Animation animation;
         int x;
        int y;
        animation = new Animation("resources/sprites/engine.png", 96,64,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        
        hot = true;
    }
    
    public boolean isHot(){
        return hot;
    }
    
    @Override
    public void act() {
        if(isHot()==true){
            hott();
        }
    }
    
    public void hott(){
         for(Actor actor : getWorld()){
                if(intersects(actor) && actor instanceof Ripley){
                    Ripley ripley = (Ripley) actor;
                    ripley.setEnergy(ripley.getEnergy() - 2);
                }
           }    
    }
    
    public void prepinac(){
        if(hot==true){
            hot=false;
        }else
            hot=true;
    }
    
}
