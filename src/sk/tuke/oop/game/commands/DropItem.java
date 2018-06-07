/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.commands;


import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author Peter
 */
public class DropItem implements Command {

    private final BackpackImpl backpack;
    private final World world;
    private final int x;
    private final int y;
    
    public DropItem(BackpackImpl backpack, World world, int x, int y){
        this.backpack = backpack;
        this.world = world;
        this.x = x;
        this.y = y;
       
    }
    
    
    @Override
    public void execute() {
       //Ripley ripley = new Ripley();
       Item i = backpack.getLastItem();
       
       //Ripley ripley = (Ripley) actor;
       world.addActor(i);
       i.addedToWorld(world);
       i.setPosition(x,y);
       backpack.remove(i);
    }
    
}
