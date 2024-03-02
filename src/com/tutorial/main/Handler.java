// Handler.java
package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    // List to store game objects
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    // Update the logic of all game objects
    public void tick() {
        // Iterate through a copy of the object list to avoid ConcurrentModificationException
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            // Update the logic of the current game object
            tempObject.tick();
        }
    }

    // Render all game objects on the screen
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            
            // Render the current game object
            tempObject.render(g);
        }
    }

    // Clear all enemy objects (specifically, Player objects) from the list
    public void clearEnemys() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            // Check if the current object is a Player
            if (tempObject.getId() == ID.Player) {
                // Clear the object list
                object.clear();

                // Add a new Player object to the list if the game state is not 'End'
                if(Game.gameState != Game.STATE.End)
                    addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
            }
        }
    }

    // Add a game object to the list
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    // Remove a game object from the list
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
