package com.company;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author Giurgea Elisa
 */
public class ControlPanel extends javax.swing.JPanel {

    final MainFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton  resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    public ControlPanel( MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1,4));

        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);

        loadButton.addActionListener(this::load);
        saveButton.addActionListener(this::save);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);
    }

    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("loading.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.repaint();
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("~/somefolder"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void reset(ActionEvent e)
    {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0,0,1200,1000);

        frame.canvas.repaint();
    }

    private void exit(ActionEvent e)
    {
        System.exit(0);
    }

}
