/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.ripley;

import java.util.Iterator;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.LaserBeam;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.NextItem;
import sk.tuke.oop.game.commands.Shoot;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.game.commands.WaveShoot;
import sk.tuke.oop.game.items.Key;

/**
 *
 * @author Peter
 */
public class Running implements RipleyState {

    private final Ripley ripley;
    
    private final Move up, down, left, right;
    private boolean buyed;
    
    public Running(Ripley ripley){
        
        this.ripley = ripley;
        int x,y;
        int step;
        int dx,dy;
        x=50;
        y=50;
        dx=0;
        dy=0;
        step = 2;
        
        up = new Move(ripley, step, dx,dy-1);
        down = new Move(ripley, step, dx, dy+1);
        left = new Move(ripley, step, dx-1, dy);
        right = new Move(ripley, step, dx+1, dy);
        buyed=false;
        ripley.setPosition(x,y);
    }
    
    @Override
    public void act() {
        ripley.getAnimation().stop();
        useDown();
        takeItem();
        dropItem();
        nextItem();
        shoot();
        shootSpecial();
        pohyb();
        pohybDiagonalUp();
        pohybDiagonalDown();
        utokSpitter();
       
    }
    

    
    public void utokSpitter(){
        for(Actor actor : ripley.getWorld()){
            if(ripley.intersects(actor) && actor instanceof LaserBeam){
                LaserBeam laser = (LaserBeam) actor;
                laser.zasah();
                ripley.setEnergy(ripley.getEnergy() - 10);
            }
        }
    }
    
    public void shootSpecial(){
        Input input = Input.getInstance();
        
        if(ripley.getSpecialAmmo()<=10 && ripley.getSpecialAmmo()>0 &&input.isKeyPressed(Input.Key.C)){
            WaveShoot wave = new WaveShoot(ripley);
                    wave.execute();
                    ripley.setSpecialAmmo(ripley.getSpecialAmmo() -1);
        }
    }
    
    public void shoot(){
        Input input = Input.getInstance();
        
        if(ripley.getAmmo()<100 && ripley.getAmmo()>0 && input.isKeyPressed(Input.Key.SPACE)){
       
            Shoot shoot = new Shoot(ripley);
                    shoot.execute();
                    ripley.setAmmo(ripley.getAmmo() -1);
        }
    }
    
    
    
    public void useDown(){
        Input input = Input.getInstance();
        
        if(input.isKeyPressed(Input.Key.E)){
            for(Actor actor : ripley.getWorld()){
                if(ripley.intersects(actor) ){
               
                    Use use = new Use(actor, ripley);
                    use.execute();
                }
            
           }
        }
    }
    
    public void takeItem(){
        Input input = Input.getInstance();
        
        if(input.isKeyPressed(Input.Key.ENTER)){
        
        Iterator iter = ripley.getIntersectingActors().iterator();
               
        while (iter.hasNext()){
            Object object = iter.next();
            if (object instanceof Item){
                if(object instanceof Key && (ripley.getMoney() >= 250) && buyed == false){
                    Item ite = (Item) object;
                    TakeItem takeitem;
                    takeitem = new TakeItem(ripley.getBackpack(), ite);
                    takeitem.execute();
                    buyed=true;
                    ripley.setMoney(ripley.getMoney()-250);
                }else if(object instanceof Key && buyed==true){
                    Item ite = (Item) object;
                    TakeItem takeitem;
                    takeitem = new TakeItem(ripley.getBackpack(), ite);
                    takeitem.execute();
                }else{
                   take(object);
                }
            }
        }
            
        }
        
    }
    
    public void take(Object object){
         if(!(object instanceof Key)){
                Item ite = (Item) object;
                TakeItem takeitem;
                takeitem = new TakeItem(ripley.getBackpack(), ite);
                takeitem.execute();
                }
    }
    
    public void dropItem(){
        Input input = Input.getInstance();
        
        if(input.isKeyPressed(Input.Key.M)){
                    
                    DropItem drop = new DropItem(ripley.getBackpack(), ripley.getWorld(),ripley.getX(),ripley.getY());
                    drop.execute();
                
        }
    }
    
    public void nextItem(){
        Input input = Input.getInstance();
        
        if(input.isKeyPressed(Input.Key.N)){
                 
                    NextItem next = new NextItem(ripley.getBackpack());
                    next.execute();
                
        }
    }
    
    public void pohyb(){  
        
        
        
        Input input = Input.getInstance();
        if(input.isKeyDown(Input.Key.UP) ){
            
            up.execute();
            ripley.getAnimation().start();
            if(ripley.getAnimation().getRotation() != 0)
            ripley.getAnimation().setRotation(0);
        }
        
        if(input.isKeyDown(Input.Key.DOWN)){
            down.execute();
            ripley.getAnimation().start();
            if(ripley.getAnimation().getRotation() != 180)
            ripley.getAnimation().setRotation(180);
            
        }
        if(input.isKeyDown(Input.Key.LEFT)){
            left.execute();
           ripley.getAnimation().start();
            if(ripley.getAnimation().getRotation() != 270)
            ripley.getAnimation().setRotation(270);
        }
        if(input.isKeyDown(Input.Key.RIGHT)){
            ripley.getAnimation().start();
            right.execute();
           
            if(ripley.getAnimation().getRotation() != 90)
            ripley.getAnimation().setRotation(90);
        }
        
        
        
    }
    
    public void pohybDiagonalUp(){
        
        
        Input input = Input.getInstance();
        if(input.isKeyDown(Input.Key.UP) &&  input.isKeyDown(Input.Key.RIGHT) && ripley.getAnimation().getRotation() != 45){
             ripley.getAnimation().start();
            ripley.getAnimation().setRotation(45);
        }
        if(input.isKeyDown(Input.Key.UP) &&  input.isKeyDown(Input.Key.LEFT) && ripley.getAnimation().getRotation() != 315){
            ripley.getAnimation().start();
            ripley.getAnimation().setRotation(315);
        }
    }
    
    public void pohybDiagonalDown(){
        
        
        Input input = Input.getInstance();
        if(input.isKeyDown(Input.Key.DOWN) &&  input.isKeyDown(Input.Key.RIGHT) && ripley.getAnimation().getRotation() != 135){
            ripley.getAnimation().start();
            ripley.getAnimation().setRotation(135);
        }
        if(input.isKeyDown(Input.Key.DOWN) &&  input.isKeyDown(Input.Key.LEFT) && ripley.getAnimation().getRotation() != 225){
          ripley.getAnimation().start();
            ripley.getAnimation().setRotation(225);
        }
    }
    
}
