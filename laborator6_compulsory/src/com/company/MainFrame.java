package com.company;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static javafx.geometry.Side.TOP;
import static javax.swing.SwingConstants.BOTTOM;

/**
 *
 * @author Giurgea Elisa
 */
public class MainFrame extends javax.swing.JFrame {

    ConfigPanel configurationPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Laboratory 6 Compulsory");
        initializeMainFrame();
    }

    private void initializeMainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel=new ControlPanel(this);
        configurationPanel=new ConfigPanel(this);
        canvas= new DrawingPanel(this);

        add(canvas, CENTER);
        add(configurationPanel, NORTH);
        add(controlPanel, SOUTH);
        pack();
    }


}