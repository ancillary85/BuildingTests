/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancillary.cavebuilding;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mike
 */
public class CaveEngine extends Engine {
       
    private ArrayList<InactiveEntity> inactives;
    private ArrayList<ActiveEntity> actives;
    private ArrayList<Room> rooms;
    
    public CaveEngine(){
        setUpEntities(null);
        setUpRooms(null);
    }
    
    public CaveEngine(List<Room> initRooms, List<Entity> initEntities) {
        setUpEntities(initEntities);
        setUpRooms(initRooms);
    }
    
    @Override
    public void addRoom(Room r) {
        rooms.add(r);
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public void removeRoom(Room r) {
        rooms.remove(r);
    }

    @Override
    public void setRooms(List<Room> newRooms) {
        rooms = new ArrayList<Room>(newRooms);
    }
    
    @Override
    public void addEntity(Entity e) {
        if(e.isActive()) {
            actives.add(new ActiveEntity(e));
        }
        else {
            inactives.add(new InactiveEntity(e));
        }
    }

    @Override
    public List<Entity> getEntities() {
        ArrayList<Entity> entities = new ArrayList();
        entities.addAll(actives);
        entities.addAll(inactives);        
        return entities;
    }

    @Override
    public void setEntities(List<Entity> newEntities) {
        inactives = null;
        actives = null;
        setUpEntities(newEntities);
    }

    @Override
    public void removeEntity(Entity e) {
        if(e.isActive()) {
            actives.remove(e);
        }
        else {
            inactives.remove(e);
        }
    }
    
    public void addActive(ActiveEntity a) {
        actives.add(a);
    }  

    public List<ActiveEntity> getActives() {
        return actives;
    }

    public void setActives(List<ActiveEntity> newActives) {
        actives = new ArrayList<ActiveEntity>(newActives);
    }
    
    public void removeActive(ActiveEntity a) {
        actives.remove(a);
    }
    
    public void addInactive(InactiveEntity i) {
        inactives.add(i);
    }
    
    public List<InactiveEntity> getInactives() {
        return inactives;
    }
    
    public void setInactives(List<InactiveEntity> newInactives) {
        inactives = new ArrayList<InactiveEntity>(newInactives);
    }
            
    public void removeInactive(InactiveEntity i) {
        inactives.remove(i);
    }

    @Override
    public void update() {
        for(ActiveEntity a :actives) {
            a.entityUpdate(null);
        }
        
        for(Room r : rooms) {
            // CURRENTLY NOTHING!
        }
    }
    
    private void setUpRooms(List<Room> initRooms) {
        if(initRooms == null) {
            rooms = new ArrayList<Room>();
        }
        else {
            rooms = new ArrayList<Room>(initRooms);
        }
    }
    
    private void setUpEntities(List<Entity> initEntities) {
        if(initEntities == null) {
            actives = new ArrayList<ActiveEntity>();
            inactives = new ArrayList<InactiveEntity>();
        }
        else {
            for(Entity e : initEntities) {
                addEntity(e);
            }
        }
    }

 

}
