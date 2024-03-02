package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

    private Handler handler;
    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        // Uncomment and set appropriate initial values for velocity
        velX = 5;
        velY = 5;
    }

    // Uncomment and implement the getBounds method if needed
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        // Uncomment and implement boundary checks if needed
        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }

        // Uncomment if you want boundary checks for x-axis
        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }

        // Uncomment if you have a Handler and want to add a Trail
        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g) {
        
        
        
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
