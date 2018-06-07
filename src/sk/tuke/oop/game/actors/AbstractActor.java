/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

/**
 *
 * @author Peter
 */
public abstract class AbstractActor implements Actor {
    
    private String name;
    private int x;
    private int y;
    private Animation animation;
    private World world;
    
    
    public AbstractActor(String name){
        setName(name);
    }
    
     public String getName(){
        return name;
    }
     
    public void setName(String name){
        this.name = name;
    }

  
    public int getX() {
        return x;
    }

   
    public int getY() {
        return y;
    }

    
    public int getWidth() {
        return animation.getWidth();
    }

  
    public int getHeight() {
        return animation.getHeight();
    }

  
    public void setPosition(int x, int y) {
         this.x = x;
         this.y = y;
    }

  
    public Animation getAnimation() {
        return animation;
    }


    public void setAnimation(Animation animation) {
         this.animation = animation;
    }
    
   
    public boolean intersects(Actor actor) {
        if( (actor.getX() > (getX()+getWidth())) || ((actor.getX()+actor.getWidth()) < getX()) || (actor.getY() > (getY()+getHeight())) || ((actor.getY()+actor.getHeight()) < getY())  ){
            return false;
        }else {
            return true;
            
        }
    }

    
    public void addedToWorld(World world) {
        this.world = world;
    }
    
    public String toString(){
        return name;
    }

   
    public World getWorld() {
         return this.world;
    }

    public List getIntersectingActors(){
        ArrayList ar = new ArrayList();
        for(Actor actor : getWorld()){
            if(intersects(actor)){
                ar.add(actor);
            }
        }
        return ar;
    } 
    
    public Actor getActorByName(String name){
        
        for(Actor actor : this.getWorld()){
            if(actor.getName().equals(name)){
                return actor;
            }
        }
        return null;
        
    }

}
