package sort.gui;

import sort.startPage.StartPage;

import javax.swing.*;

import static sort.constants.Constants.*;

public class Frame extends JFrame {
    public Frame(String title) {
        super(title);
        this.add(new StartPage(this));
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
