/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.LaserBeam;
import sk.tuke.oop.game.actors.enemies.SpitterAlien;

/**
 *
 * @author Peter
 */
public class LaserShoot implements Command {
    
    private final SpitterAlien alien;
    public LaserShoot(SpitterAlien alien){
        this.alien = alien;
    }
    
    @Override
    public void execute() {
      
        LaserBeam laser = new LaserBeam("laserbeam");
        laser.setPosition(alien.getX(), alien.getY());
        laser.getAnimation().setRotation(alien.getAnimation().getRotation());
        this.alien.getWorld().addActor(laser);
        
      
    }
}
