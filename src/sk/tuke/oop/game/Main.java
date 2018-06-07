package sk.tuke.oop.game;

import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.actors.Computer;
import sk.tuke.oop.game.actors.Desktop;
import sk.tuke.oop.game.actors.End;
import sk.tuke.oop.game.actors.Engine;
import sk.tuke.oop.game.actors.Hole;
import sk.tuke.oop.game.actors.Laser;
import sk.tuke.oop.game.actors.LaserBeam;
import sk.tuke.oop.game.actors.WaveBullet;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.LuckerAlien;
import sk.tuke.oop.game.actors.enemies.SpitterAlien;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.openables.EndDoor;
import sk.tuke.oop.game.actors.openables.SpecialDoor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Cables;
import sk.tuke.oop.game.items.Key;
import sk.tuke.oop.game.items.Mine;
import sk.tuke.oop.game.items.Money;
/*
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.Body;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.actors.Ventilator;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.items.Wrench;

*/
/**
 *
 * @author Manager
 */
//cviko 6-7-8
/*
public class Main {
    private static SlickWorld world;
    
    public static void main(String[] args) {
        
       world = new SlickWorld("aliens", 800, 600); 
       
       Ripley ripley = new Ripley();
       world.addActor(ripley);
       ripley.addedToWorld(world);
       
       Alien alien = new Alien();
       world.addActor(alien);
       alien.addedToWorld(world);
       
       Energy energy = new Energy();
       world.addActor(energy);
       energy.addedToWorld(world);
       
       Ammo ammo = new Ammo();
       world.addActor(ammo);
       ammo.addedToWorld(world);
       
       Ventilator ventilator = new Ventilator();
       world.addActor(ventilator);
       ventilator.addedToWorld(world);
       
       Body body = new Body();
       world.addActor(body);
       body.addedToWorld(world);
       
       Hammer hammer = new Hammer();
       world.addActor(hammer);
       hammer.addedToWorld(world);
       
       Money money = new Money();
       world.addActor(money);
       money.addedToWorld(world);
       
       Wrench wrench = new Wrench();
       world.addActor(wrench);
       wrench.addedToWorld(world);
       
       Cooler c = new Cooler();
       world.addActor(c);
       c.addedToWorld(world);
       
       world.run();
    }
    
}
*/

//ostatne cvika a vlastna mapa
public class Main {
  

    public static void main(String[] args) {
        SlickWorld world;
        String input = "ALiens";
        int width = 800;
        int height = 600;
        ActorFactory factory;
        
        world = new SlickWorld(input,width,height);
        factory = new ActorFactoryImpl();
        world.setFactory(factory);
        world.setMap("resources/levels/map.tmx");
        //world.setMap("resources/levels/level1.tmx.xml");
        //world.setMap("resources/levels/temple.of.doom.tmx");
        //world.setMap("resources/levels/deck03.tmx");
        world.run();
    }
    
    public static void scenario(){
        // Hrac vezme naboje
        Ripley ripley = new Ripley();
        Ammo ammo = new Ammo();
        ammo.act();
        //hrac otvori dvere a zabije alienov
        Door door = new Door();
        door.open();
        Alien alien = new Alien("alien");
        alien.act();
        //hrac vezme kabel 
        Cables kabel = new Cables();
        TakeItem takeitem = new TakeItem(ripley.getBackpack(), kabel);
        takeitem.execute();
    
        //hrac otvori dvere 
        Door door2 = new Door();
        door2.open();
        
        //pouzijem kabel na desktop a tim sa odomknu dvere a moze ich otvorit
        Desktop desktop = new Desktop();
        desktop.use(ripley);
        SpecialDoor spDoor = new SpecialDoor();
        spDoor.open();
    
        //podlaha sa prepadava a ripleyova sa jej musi vyhnut inak zomrie
        Hole hole = new Hole();
        hole.act();
        //ripley vezme peniaze lebo ich bude neskor potrebovat
        Money money = new Money();
        TakeItem takeitemMoney = new TakeItem(ripley.getBackpack(), money);
        takeitemMoney.execute();
        //ripley sa musi vyhnut laserom
        Laser laser = new Laser();
        laser.act();
        //ripley pouzije computer na vypnutie engine inak by zhorela
        Engine engine = new Engine();
        engine.act();
        Computer comp = new Computer();
        comp.use(ripley);
        //ripley vezme minu a peniaze a minu polozi do drahy spitter aliena 
        //ktory po ripleyovej striela "laserbeam" strely to ho zabije
        Money money2 = new Money();
        TakeItem takeitemMoney2 = new TakeItem(ripley.getBackpack(), money2);
        takeitemMoney2.execute();
        
        SpitterAlien spitter = new SpitterAlien("spitter");
        spitter.act();
        
        Mine mine = new Mine();
        mine.act();
        mine.use(ripley);
        
      
        LaserBeam laserbeam = new LaserBeam("laserbeam");
        laserbeam.act();
        
        //ripley si kupi kluc od dvie ku koncu levelu a takisto lepsie naboje
        //naboje waveBullet su ucinnejsie na Lucker alienov
        Key key = new Key();
        key.act();
        
        LuckerAlien luckerAlien = new LuckerAlien("lucker");
        luckerAlien.act();
        
        WaveBullet wave = new WaveBullet("wave");
        wave.act();
        //pouzi kluc na dvere do ciela a pouzi tunel na ukoncenie levelu 
        EndDoor endoor = new EndDoor();
        endoor.use(ripley);
        End end = new End();
        end.use(ripley);
        
    }
}
