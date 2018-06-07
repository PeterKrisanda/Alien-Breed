/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Peter
 */
public class End extends AbstractActor implements Usable {
private boolean isEnd;
private final Animation animation;

    public End(){
        super("end");
        
        int x;
        int y;
        animation = new Animation("resources/sprites/tunnel_black.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        isEnd = false;
        animation.stop();
       
    }
    
    @Override
    public void act() {
     
      if(isEnd == true){
          animation.stopAt(5);
          animation.start();
          Message message;
        message = new Message ("Well done you win!",300,300);
        getWorld().showMessage(message);
        
      }
    }

    @Override
    public void use(Actor actor) {
        if(intersects(actor) && actor instanceof Ripley){
              isEnd = true;
              
        }
    }
    
}
