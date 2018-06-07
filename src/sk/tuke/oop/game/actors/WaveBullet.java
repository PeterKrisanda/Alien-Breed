/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;


/**
 *
 * @author Peter
 */
public class WaveBullet extends Bullet implements Movable {

     
   
    
    public WaveBullet(String name){
        super(name);int x,y;
        x=150;
        y=150;
        Animation animation;
        animation = new Animation("resources/sprites/energy_wave.png", 16,16,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        setPosition(x,y);
       
    }
    
    
    
}
