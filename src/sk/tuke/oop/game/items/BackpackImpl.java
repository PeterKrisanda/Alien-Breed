/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item;

/**
 *
 * @author Peter
 */
public class BackpackImpl implements Backpack {

    private final List<Item> backpack = new ArrayList<Item>();
    private final int capacity;
    private int i;
    public BackpackImpl(int capacity){
        this.capacity = capacity;
    }
    
    @Override
    public void add(Item item) {
        
        if(item instanceof Item && i < capacity){
           
            backpack.add(0, item);
        
            i++;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void addToEnd(Item item){
      
           
            backpack.add(i, item);
        
            i++;
      
    }

    @Override
    public void remove(Item item) {
        
        if(backpack != null && backpack.contains(item)){
            backpack.remove(item);
            i--;     
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return backpack.iterator();
    }
    
    public Item getLastItem(){
        return backpack.get(0);
    }
    
}