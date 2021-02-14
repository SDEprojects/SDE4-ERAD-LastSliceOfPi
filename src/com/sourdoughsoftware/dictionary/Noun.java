package com.sourdoughsoftware.dictionary;

import com.sourdoughsoftware.GameState;
import com.sourdoughsoftware.interaction.Actions;
import com.sourdoughsoftware.interaction.Event;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Noun implements DictionaryEntry, Serializable {

    private String name;
    private String description;

    private boolean weildable = false;
    private boolean examinable = false;
    private boolean grabable = false;
    private boolean mergeable = false;
    private boolean attackable = false;
    private boolean findable = false;
    private boolean dropable = false;

    public HashMap<String, ArrayList<Event>> interactions = new HashMap<>();

    public void setAction(String verb, ArrayList<Event> events) {
        interactions.put(verb, events);
    }

    public boolean getAction(String verb) {
        ArrayList<Event> events = interactions.get(verb);
        Actions act = new Actions();
        if(events == null) {
            System.out.println("You can't "  + verb + " a " + getName());
            return false;
        }
        for(Event event : events) {
            try {
                Method method = act.getClass().getMethod(event.verbGroup.toString().strip(), String.class);
                method.invoke(act ,event.message.strip());
                System.out.println(method.getName());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                if(GameState.getInstance().getDevMode()) { e.printStackTrace(); };
                return false;
            }
        }
        return true;
    }

    public Noun(String name, String description) {
        this.name = name.toLowerCase();
        this.description = description;
        addToDictionary();
    }

    public Noun(Noun noun) {
        this.name = noun.getName();
        this.description = noun.getDescription();
    }

    public Noun() {
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    public boolean isFindable() {
        return findable;
    }

    public void setFindable(boolean findable) {
        this.findable = findable;
    }

    public boolean isMergeable() {
        return mergeable;
    }

    public void setMergeable(boolean mergeable) {
        this.mergeable = mergeable;
    }

    public boolean isAttackable() {
        return attackable;
    }

    public void setAttackable(boolean attackable) {
        this.attackable = attackable;
    }

    public boolean isWeildable() {
        return weildable;
    }

    public void setWeildable(boolean weildable) {
        this.weildable = weildable;
    }

    public boolean isExaminable() {
        return examinable;
    }

    public void setExaminable(boolean examinable) {
        this.examinable = examinable;
    }

    public boolean isGrabable() {
        return grabable;
    }

    public void setGrabable(boolean grabable) {
        this.grabable = grabable;
    }

    public boolean isDropable() {
        return dropable;
    }

    public void setDropable(boolean dropable) {
        this.dropable = dropable;
    }
}
