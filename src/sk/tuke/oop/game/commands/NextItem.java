/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.commands;



import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author Peter
 */
public class NextItem implements Command {

    private final BackpackImpl backpack;
    
    public NextItem(BackpackImpl backpack){
        this.backpack = backpack;
    }
    
    @Override
    public void execute() {
        Item item;
        
        item = backpack.getLastItem();
        backpack.remove(item);
        backpack.addToEnd(item);
        
        
        /*
        Iterator litr = backpack.iterator();
       while(litr.){
	litr.next();
        next item si zoberies posledny item a ulozis 
        do lokalnej premennej.. potom ho vymazes z 
        batoha a pridas na posledne miesto.. .
	
    }*/
    }
    
}
