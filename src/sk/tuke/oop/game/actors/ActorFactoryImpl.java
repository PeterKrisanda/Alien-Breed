/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Cables;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.LuckerAlien;
import sk.tuke.oop.game.actors.enemies.SpitterAlien;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.openables.EndDoor;
import sk.tuke.oop.game.actors.openables.SpecialDoor;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Key;
import sk.tuke.oop.game.items.Mine;
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.items.SpecialAmmo;

/**
 *
 * @author Peter
 */
public class ActorFactoryImpl implements ActorFactory {
    
   
    
    public ActorFactoryImpl(){
        
    }
    
    @Override
    public Actor create(String arg0, String arg1) {
      return creator(arg1);
    }
    
    public Actor creator(String arg1){
        return create1(arg1);
    }
   
    public Actor create1(String arg1){
         Actor actor;
         
         
        switch(arg1){
             case "energy": actor = new Energy();
                break;
             case "hammer": actor = new Hammer();
                break;
             case  "cooler": actor = new Cooler();
                break;
            case "ellen": actor = new Ripley();
                break;
            case "access card": actor = new AccessCard();
                break;
            case "door":  actor =  new Door();
               break;
            case "alien": actor = new Alien("alien");
                break;
            case "ammo": actor = new Ammo();
                break;
                         
            default: actor = create2(arg1);
                 break;
        }
        return actor;
        
       
    }
    
    public Actor create2(String arg1){
         Actor actor;
        switch(arg1){
            case "Door": actor = new Door();
                break;
             case "money": actor = new Money();
                break;
            case "cables": actor = new Cables();
                break;
            case "desktop": actor = new Desktop();
                break;
            case "hole": actor = new Hole();
                break;
            case "laser": actor = new Laser();
                break;
            case "engine": actor = new Engine();
                break;
            case "mine": actor = new Mine();
                break;
             default: actor = create3(arg1);
                 break;
        }
        return actor;
    }
    
    public Actor create3(String arg1){
         Actor actor;
        switch(arg1){
           
            case "key": actor = new Key();
                break;
            case "computer": actor = new Computer();
                break;
            case "wave": actor = new SpecialAmmo();
                break;
            case "spitter": actor = new SpitterAlien("spitter");
                break;
            case "lucker": actor = new LuckerAlien("lucker");
                break;
            case "end": actor = new End();
                break;
            case "SpecialDoor1": actor = new SpecialDoor();
                break;
            case "SpecialDoor2" : actor = new EndDoor();
                break;
             default: actor = null;
                 break;
        }
        return actor;
    }
    
    
    
}
