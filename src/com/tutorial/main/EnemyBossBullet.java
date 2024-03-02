// EnemyBossBullet.java
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private Handler handler;
    private Random r = new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        // Set the initial velocity for the bullet
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }

    // Implementing the getBounds method to define the collision bounds of the bullet
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    // Tick method to update the bullet logic
    public void tick() {
        x += velX;
        y += velY;

        // Check if the bullet is out of bounds (below the screen)
        if (y >= Game.HEIGHT) {
            // Remove the bullet from the handler when it goes out of bounds
            handler.removeObject(this);
        }

        // Add a Trail to create a visual effect behind the bullet
        handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 16, 16, 0.02f, handler));
    }

    // Render method to draw the bullet on the screen
    public void render(Graphics g) {
        // Set the color to blue
        g.setColor(Color.blue);

        // Draw a filled rectangle to represent the bullet
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
