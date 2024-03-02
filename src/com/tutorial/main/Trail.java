// Trail.java
package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {

    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    private int width, height;

    // Constructor to initialize Trail with position, ID, color, dimensions, life, and Handler
    public Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    // Update the trail's alpha value and remove it when it becomes transparent
    public void tick() {
         if (alpha > life) {
            alpha -= (life - 0.0001f);
        } else {
            handler.removeObject(this); // Remove the trail object when life is expired
        }
    }

    // Render the trail with the specified color and transparency
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        // Draw the colored rectangle representing the trail
        g.setColor(color);
        g.fillRect((int) x, (int) y, width, height);

        g2d.setComposite(makeTransparent(1)); // Reset transparency for subsequent rendering
    }

    // Create a transparent composite for rendering
    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    // Trails don't have collision bounds, so return null
    public Rectangle getBounds() {
        return null;
    }
}
