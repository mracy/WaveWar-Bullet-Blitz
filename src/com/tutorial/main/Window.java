// Window.java
package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {

    private static final long serialVersionUID = -240840600533728354L;

    // Constructor to create a window with specified dimensions, title, and associated game instance
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation on window close
        frame.setResizable(false); // Window not resizable
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.add(game); // Add the game (Canvas) to the window
        frame.setVisible(true); // Make the window visible
        game.start(); // Start the game loop
    }
}
