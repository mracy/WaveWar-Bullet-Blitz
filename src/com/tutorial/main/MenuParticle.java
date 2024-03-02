// MenuParticle.java
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    private Random r = new Random();
    private Color col;

    // Constructor to initialize MenuParticle with position, ID, and Handler
    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        // Set random velocity within the range [-7, 7] for both x and y directions
        velX = (r.nextInt(7 - -7) + -7);
        velY = (r.nextInt(7 - -7) + -7);

        // Ensure velocity is never zero
        if (velX == 0) velX = 1;
        if (velY == 0) velY = 1;

        // Set a random color for the MenuParticle
        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    // Implementing the abstract method to get the bounds of the MenuParticle
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    // Tick method for updating the MenuParticle's position and behavior
    public void tick() {
        x += velX;
        y += velY;

        // Bounce off the top and bottom edges
        if (y <= 0 || y >= Game.HEIGHT - 16) {
            velY *= -1;
        }

        // Bounce off the left and right edges
        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }

        // Create a Trail object to add a trail effect
        handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.05f, handler));
    }

    // Render method for drawing the MenuParticle on the screen
    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
