/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author Peter
 */
public class Ripley extends AbstractCharacter implements Movable {
    
   
    private final Animation  animationdie;
    
   
    private  int energy;
    private int ammo, specialAmmo;
    private int money;
    private final BackpackImpl backpack;
    private World world;
 
    private final RipleyState ripleyRun;
    private final RipleyState ripleyDie;
    
    public Ripley(){
         super("ellen ripley");
         Animation animation;
        animationdie = new Animation("resources/sprites/player_die.png", 32,32,100);
        
        animation = new Animation("resources/sprites/player.png", 32,32,100);
        animation.setLooping(true);
        animation.setPingPong(true);
        setAnimation(animation);
        this.energy = 100;
        ripleyRun = new Running(this);
        ripleyDie = new Dying(this);
        this.ammo = 30;
        this.world = getWorld();
        backpack = new BackpackImpl(5);
        this.specialAmmo = 0;
        this.money = 0;
        animation.stop();
       
      
       
     
   }
   
    @Override
    public int getEnergy(){
        return energy;
    }
    
    @Override
    public void setEnergy(int energy){
        this.energy= energy;
    }
    
   public int getAmmo(){
       return ammo;
   }
   
   public void setAmmo(int ammo){
       this.ammo = ammo;
   }
   
   public int getMoney(){
       return money;
   }
   
   public void setMoney(int money){
       this.money = money;
   }
   
   
   public int getSpecialAmmo(){
       return specialAmmo;
   }
   
   public void setSpecialAmmo(int specialAmmo){
       this.specialAmmo = specialAmmo;
   }
   
   public Animation getAnimationDie(){
       return animationdie;
   }    

    @Override
    public void act() {
        Message message;
        message = new Message ("Energy:"+energy+"  Ammo:"+ammo + "  Special Ammo:"+specialAmmo + " Money:" + money  ,100,10);
        Input input = Input.getInstance();
        if(input.isKeyPressed(Input.Key.ESCAPE)){
            System.exit(0);            
        }
        getWorld().showMessage(message);
        
       
        
        if(getEnergy() > 0){
            ripleyRun.act();
        }
        else if(getEnergy() <= 0){ 
            ripleyDie.act();
    
        }
        
        if(getEnergy() <= 0){   
            ripleyDie.act();
        }
    }
    
   
    public BackpackImpl getBackpack(){
        return backpack;
    }
    
    
    @Override
    public void addedToWorld(World world) {
       
       super.addedToWorld(world);
       this.world = world;
       this.world.showBackpack(backpack);
       this.world.centerOn(this);
    }
    
   public Item getItemByName(String name){
        for (Item item : backpack) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
   }
    
}
