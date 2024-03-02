// EnemyBoss.java
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {

    private Handler handler;
    private Random r = new Random();
    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 2;
    }

    // Implementing the getBounds method to define the collision bounds of the enemy boss
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 96);
    }

    // Tick method to update the enemy boss logic
    public void tick() {
        x += velX;
        y += velY;

        timer--;

        if (timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }

        if (timer <= 0) {
            timer2--;
            if (timer2 <= 0) {
                if (velX == 0) {
                    velX = 2;
                }
                if (velX > 0) {
                    velX += 0.005f;
                } else if (velX < 0) {
                    velX -= 0.005f;
                }

                // Clamp the velocity to ensure it stays within a specific range
                velX = Game.clamp(velX, -10, 10);

                // Generate a random number to decide whether to spawn an enemy bullet
                int spawn = r.nextInt(10);
                if (spawn == 0) {
                    handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
                }
            }
        }

        // Boundary checks for the enemy boss
        if (x <= 0 || x >= Game.WIDTH - 96) {
            velX *= -1;
        }

        // Add a Trail to create a visual effect behind the enemy boss
        handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 96, 96, 0.002f, handler));
    }

    // Render method to draw the enemy boss on the screen
    public void render(Graphics g) {
        // Set the color to magenta
        g.setColor(Color.magenta);
        
        // Draw a filled rectangle to represent the enemy boss
        g.fillRect((int) x, (int) y, 96, 96);
    }
}
