/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.WaveBullet;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Peter
 */
public class WaveShoot implements Command {
     private final Ripley ripley;
    
    public WaveShoot(Ripley ripley){
        this.ripley = ripley;
    }
    
    @Override
    public void execute() {
      
        WaveBullet wave = new WaveBullet("wave");
        wave.setPosition(ripley.getX(), ripley.getY());
        wave.getAnimation().setRotation(ripley.getAnimation().getRotation());
        this.ripley.getWorld().addActor(wave);
        
      
    }
}
