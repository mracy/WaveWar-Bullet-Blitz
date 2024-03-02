// HUD.java
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    // Health value (static to share across all instances)
    public static float HEALTH = 100;

    // Initial green value for health bar color
    private float greenValue = 255f;

    // Player's score and level
    private int score = 0;
    private int level = 1;

    // Update the HUD components
    public void tick() {
        // Ensure HEALTH stays within valid range (0 to 100)
        HEALTH = Game.clamp(HEALTH, 0, 100);

        // Update greenValue based on HEALTH (adjusting health bar color)
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;

        // Increment the score (example: based on some condition or event)
        score++;
    }

    // Render the HUD on the screen
    public void render(Graphics g) {
        // Draw the gray background for the health bar
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);

        // Draw the health bar with color based on greenValue
        g.setColor(new Color(75, (int) greenValue, 0));
        g.fillRect(15, 15, (int) HEALTH * 2, 32);

        // Draw the outline of the health bar
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);

        // Display the player's score and level
        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
    }

    // Setter method to set the player's score
    public void setScore(int score) {
        this.score = score;
    }

    // Getter method to retrieve the player's score
    public int getScore() {
        return score;
    }

    // Getter method to retrieve the player's level
    public int getLevel() {
        return level;
    }

    // Setter method to set the player's level
    public void setLevel(int level) {
        this.level = level;
    }
}
