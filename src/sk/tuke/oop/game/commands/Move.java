/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.Movable;

/**
 *
 * @author Peter
 */
public class Move implements Command {

private final int step;
private final int dx;
private final int dy;
private final Actor actors;

    public Move(Movable actor, int step, int dx, int dy){
        actors = (Actor) actor; 
        this.step = step;
        this.dx = dx;
        this.dy = dy;
    }
    
    @Override
    public void execute() {
         
           Boolean moze = actors.getWorld().intersectWithWall(actors);
        if(moze == false){
           
            actors.getAnimation().start();
            
            int x = actors.getX();
            int y = actors.getY();
            
            actors.setPosition(x, y+dy*step);
            
            x = actors.getX();
            y = actors.getY();
            
            actors.setPosition(x+dx*step,y);
           
            moze = actors.getWorld().intersectWithWall(actors);
             if(moze == true){
            getOneStepBack();
            
        }
        }
    }
    
    public void getOneStepBack(){
        if(actors instanceof Bullet){
            Bullet bullet = (Bullet) actors;
            bullet.zasah();
        }else{
        int x = actors.getX();
        int y = actors.getY();
        actors.setPosition(x, y-(step)*dy);
        x = actors.getX();
        y = actors.getY();
        actors.setPosition(x-(step)*dx,y);
        }
    }
    
    
    
}
