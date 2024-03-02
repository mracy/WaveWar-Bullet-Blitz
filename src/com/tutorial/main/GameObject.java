// GameObject.java
package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

// Abstract class representing a game object
public abstract class GameObject {

    // Coordinates of the object
    protected float x, y;

    // Unique identifier for the object
    protected ID id;

    // Velocity in the x and y directions
    protected float velX, velY;

    // Constructor to initialize the object's position and ID
    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    // Abstract method to update the object's logic
    public abstract void tick();

    // Abstract method to render the object on the screen
    public abstract void render(Graphics g);

    // Abstract method to get the bounding box of the object for collision detection
    public abstract Rectangle getBounds();

    // Setter method to set the x-coordinate of the object
    public void setX(int x) {
        this.x = x;
    }

    // Setter method to set the y-coordinate of the object
    public void setY(int y) {
        this.y = y;
    }

    // Getter method to retrieve the x-coordinate of the object
    public float getX() {
        return x;
    }

    // Getter method to retrieve the y-coordinate of the object
    public float getY() {
        return y;
    }

    // Setter method to set the ID of the object
    public void setId(ID id) {
        this.id = id;
    }

    // Getter method to retrieve the ID of the object
    public ID getId() {
        return id;
    }

    // Setter method to set the velocity in the x-direction
    public void setVelX(int velX) {
        this.velX = velX;
    }

    // Setter method to set the velocity in the y-direction
    public void setVelY(int velY) {
        this.velY = velY;
    }

    // Getter method to retrieve the velocity in the x-direction
    public float getVelX() {
        return velX;
    }

    // Getter method to retrieve the velocity in the y-direction
    public float getVelY() {
        return velY;
    }

}
