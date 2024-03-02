package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        // Add a Trail to create a visual effect (light yellow color)
        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 32, 32, 0.05f, handler));

        // Check for collisions with enemies
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2; // Deduct health on collision with enemies
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow); // Change the color to light yellow
        g.fillRect((int)x, (int)y, 32, 32); // Draw the player as a filled rectangle
    }
}
