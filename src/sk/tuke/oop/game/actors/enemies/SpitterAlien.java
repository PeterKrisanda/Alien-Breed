/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.LaserShoot;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.items.Mine;

/**
 *
 * @author Peter
 */
public class SpitterAlien extends Alien implements Movable {
    
      
    
      private int j,l;
      private final Move up, down; 
      private final Animation animation;
      private int i,k;
     
    
    public SpitterAlien(String name){
        super(name);
        
        int x;
        int y;
        animation = new Animation("resources/sprites/spitter_alien.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        setPosition(x,y);
        up = new Move(this, 1, 0, -1);
        down = new Move(this, 1, 0, 1);
        animation.setRotation(90);
        i = 0;
        k=0;
    }
    
    @Override
    public void act(){
          l++;
       
        pohybY();
        
        otacanie();
        utok();
        umieranie();
        
    }
    
    @Override
    public void umieranie(){
        for(Actor actor: getWorld()){
            
            if((intersects(actor) && actor instanceof Mine) ){
                k++;
               if(k>=50 && (intersects(actor) && actor instanceof Mine)){
                    Mine mine = (Mine) actor;
                    mine.use(this);
                    this.getWorld().removeActor(this);
               
                }
            }
        }
    }
    
    
    
    @Override
    public void pohybY(){
        if(j == 0){
            up.execute();
            if(l>=150){
            j=1;
            l=0;
            }
        }
        if(j == 1){
            down.execute();
            if(l>=150){
            j=0;
            l=0;
            }
        }
    }
    
    public void otacanie(){
        for(Actor actor : getWorld()){
            if(actor instanceof Ripley){
        Ripley ripley = (Ripley) actor;
            if(ripley.getX()> this.getX()){
                this.animation.setRotation(90);
            }else
                this.animation.setRotation(270);
            
        }
        }
    }
    
    
    @Override
    public void utok(){
        
        i++;
        
        if( i>=15){
            LaserShoot laser = new LaserShoot(this);
                    laser.execute();
                    i=0;
        }
    }
}
