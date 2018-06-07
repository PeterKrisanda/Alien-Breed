/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.items.Usable;


/**
 *
 * @author Peter
 */
public class Door extends AbstractActor implements Usable , Openable {
    
    private final Animation animation;
    private boolean isClosed;
    
    
    public Door(){
        super("door");
        animation = new Animation("resources/sprites/vdoor.png", 16,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        animation.stop();
        isClosed = true;
       
        
    }
    
    @Override
    public boolean isOpen(){
        return (!isClosed);
    }

    @Override
    public void use(Actor actor) {
        otvaranie(actor);
    }
    
    public void otvaranie(Actor actor){
         if(isClosed == true){
            open();
            
        }
    }
    
   

    @Override
    public void act() {
      getWorld().setWall(getX()/16, getY()/16, isClosed);
      getWorld().setWall(getX()/16, (getY()/16)+1, isClosed);
    }   

    @Override
    public void open() {
       animation.stopAt(3);
       animation.start();
       isClosed = false;
    }

    @Override
    public void close() {
      animation.stopAt(3);
       animation.start();
    }
    
}
