/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Desktop;

/**
 *
 * @author Peter
 */
public class SpecialDoor extends Door {
    
    
    
    @Override
    public void use(Actor actor){
        otvaranie();
    }
    
    public void otvaranie(){
         for(Actor actor : getWorld()){
         if(actor instanceof Desktop){
        Desktop desktop = (Desktop)actor;
        if(desktop.getDesktopIsRepaired() == true && isOpen() == false){
            open();
        }
        }}
    }

}
