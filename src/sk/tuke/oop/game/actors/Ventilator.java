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
public class Ventilator extends AbstractActor implements Usable {
    
    private final Animation animation;
    private boolean jeZapnuti;
   
    public Ventilator(){
        super("ventilator");
        int x;
        int y;
        animation = new Animation("resources/sprites/ventilator.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 550;
        setPosition(x,y);
        jeZapnuti = false;
        animation.stop();
       
    }

    @Override
    public void act() {
        
    }

   
    
     @Override
    public void use(Actor actor) {
        if(jeZapnuti == false){
            zapnut();
        }else{
            vypnut();
        }
    }
    
    public void zapnut(){
            animation.start();
            jeZapnuti = true;
    }
    
    public void vypnut(){
            animation.stop();
            jeZapnuti = false;
    }
    
    
}
