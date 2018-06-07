/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Message;

/**
 *
 * @author Peter
 */
public class Dying implements RipleyState {

    
    private final Ripley ripley;
    
    public Dying(Ripley ripley){
        this.ripley = ripley;
        
        
    }
    
    @Override
    public void act() {
       if(ripley.getEnergy() <= 0){
            
        
            ripley.setEnergy(0);
            ripley.getAnimationDie().setLooping(false);
           ripley.getAnimationDie().start();
            ripley.setAnimation(ripley.getAnimationDie());
            
           Message message;
        message = new Message ("You die! try again.",330,200);
        ripley.getWorld().showMessage(message);
            
        }
      
    }
    
}
