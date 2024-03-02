// KeyInput.java
package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    // Constructor to initialize the KeyInput with a Handler
    public KeyInput(Handler handler) {
        this.handler = handler;
        // Initialize the array to keep track of key states
        keyDown[0] = false; // W key
        keyDown[1] = false; // S key
        keyDown[2] = false; // D key
        keyDown[3] = false; // A key
    }

    // Called when a key is pressed
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Iterate through game objects to find the Player
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // Handle different key presses to set velocity for Player
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5); // Move up
                    keyDown[0] = true;
                }

                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5); // Move down
                    keyDown[1] = true;
                }

                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5); // Move right
                    keyDown[2] = true;
                }

                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5); // Move left
                    keyDown[3] = true;
                }
            }
        }

        // Exit the game if the Escape key is pressed
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    // Called when a key is released
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        // Iterate through game objects to find the Player
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // Handle different key releases to stop Player movement
                if (key == KeyEvent.VK_W) keyDown[0] = false; // Stop moving up
                if (key == KeyEvent.VK_S) keyDown[1] = false; // Stop moving down
                if (key == KeyEvent.VK_D) keyDown[2] = false; // Stop moving right
                if (key == KeyEvent.VK_A) keyDown[3] = false; // Stop moving left

                // Adjust velocity based on remaining pressed keys
                if (keyDown[0] && !keyDown[1]) tempObject.setVelY(0); // Stop vertical movement if W is pressed and S is not pressed
                if (keyDown[2] && !keyDown[3]) tempObject.setVelX(0); // Stop horizontal movement if D is pressed and A is not pressed
            }
        }
    }
}
