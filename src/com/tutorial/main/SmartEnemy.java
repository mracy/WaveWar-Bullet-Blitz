// SmartEnemy.java
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    // Constructor to initialize SmartEnemy with position, ID, and Handler
    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        // Find the player object in the handler
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
    }

    // Implementing the abstract method to get the bounds of the SmartEnemy
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    // Tick method for updating the SmartEnemy's position and behavior
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        // Calculate the velocity based on player's position
        velX = (int) ((-2.0 / distance) * diffX);
        velY = (int) ((-2.0 / distance) * diffY);

        // Boundary checks
        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }

        // Create a Trail object to add a trail effect
        handler.addObject(new Trail(x, y, ID.Trail, new Color(139, 69, 19), 16, 16, 0.02f, handler));
        // Set the color to mud (RGB values: 139, 69, 19)
    }

    // Render method for drawing the SmartEnemy on the screen
    public void render(Graphics g) {
        g.setColor(new Color(139, 69, 19)); // Set the color to mud (RGB values: 139, 69, 19)
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
