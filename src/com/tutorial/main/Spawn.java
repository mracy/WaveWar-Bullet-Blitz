// Spawn.java
package com.tutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;

    // Constructor to initialize Spawn with Handler and HUD
    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    // Tick method to handle spawning of enemies based on the player's score
    public void tick() {
        scoreKeep++;

        // Check if the score threshold is reached
        if (scoreKeep >= 100) {
            scoreKeep = 0; // Reset the score counter
            hud.setLevel((int) (hud.getLevel() + 1)); // Increment the level in the HUD

            // Spawn different types of enemies based on the player's level
            if (hud.getLevel() == 2 || hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 4 || hud.getLevel() == 6 || hud.getLevel() == 7) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 5) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 10) {
                // Clear existing enemies and spawn a boss when the player reaches level 10
                handler.clearEnemys();
                handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
            }
        }
    }
}
