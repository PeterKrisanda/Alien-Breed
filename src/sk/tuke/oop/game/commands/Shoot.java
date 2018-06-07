/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Peter
 */
public class Shoot implements Command {

    private final Ripley ripley;
    
    public Shoot(Ripley ripley){
        this.ripley = ripley;
    }
    
    @Override
    public void execute() {
      
        Bullet bullet = new Bullet("bullet");
        bullet.setPosition(ripley.getX(), ripley.getY());
        bullet.getAnimation().setRotation(ripley.getAnimation().getRotation());
        this.ripley.getWorld().addActor(bullet);
        
      
    }
    
    
    
}
