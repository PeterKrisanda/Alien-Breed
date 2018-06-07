/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Key;

/**
 *
 * @author Peter
 */
public class EndDoor extends Door {
    
    
    
    
    
    @Override
    public void use(Actor actor){
        otvaranie(actor);
    }
    public void otvaranie(Actor actor){
           Ripley ripley = (Ripley ) actor;
    
          if(ripley.getBackpack().getLastItem() instanceof Key){
              open();
              ripley.getBackpack().remove(ripley.getBackpack().getLastItem());
          }
    }

    
    
}
