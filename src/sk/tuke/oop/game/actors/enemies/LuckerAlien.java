/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.enemies;

import java.util.Random;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.WaveBullet;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author Peter
 */
public class LuckerAlien extends Alien implements Movable {
    
        private int r1;
    private Random r;
    
    private int j;
      private final Move left, right;    
    
        public LuckerAlien(String name){
            super(name);
        Animation animation;
        int x;
        int y;
        int energy;
        animation = new Animation("resources/sprites/lurker_alien.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        x = 150;
        y = 350;
        energy = 1000;
        setEnergy(energy);
        int step = 4;
        int dx=0;
        int dy = 0;
        left = new Move(this, step, dx-1, dy);
        right = new Move(this, step, dx+1, dy);
        setPosition(x,y);
        }
        
        @Override
        public void act(){
              j++;
        if(j == 20){
         r = new Random();
             r1 = r.nextInt(2);
             j=0;
        } 
            pohybX();
            utok();
            umieranieWave();
            umieranie();
        }
        
        @Override
        public void pohybX(){
        if(r1 == 0){
            left.execute();
        }
        if(r1 == 1){
            right.execute();
        }
        
        }

        @Override
        public void utok(){
        for(Actor actor : getWorld()){
            if(intersects(actor) && actor instanceof Ripley){
                Ripley ripley = (Ripley) actor;
                ripley.setEnergy(ripley.getEnergy()-2);
            }
        }
    }
        
    
    public void umieranieWave(){
        for(Actor actor : getWorld()){
            if(intersects(actor) && actor instanceof WaveBullet){
                WaveBullet wave = (WaveBullet) actor;
                wave.zasah();
                setEnergy(getEnergy() - 500);
            }
            
        }
        if(getEnergy() <=0){
            getWorld().removeActor(this);
        }
    }
       
}
