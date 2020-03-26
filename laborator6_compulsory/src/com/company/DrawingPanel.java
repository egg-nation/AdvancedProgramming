package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.lang.Object;
import java.awt.Color;

/**
 *
 * @author Giurgea Elisa
 */
public class DrawingPanel extends javax.swing.JPanel {

    final MainFrame frame;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel (MainFrame frame){
        this.frame = frame;
        initializeWindow();
    }

    private void initializeWindow() {
        setPreferredSize(new Dimension(1200,1000));
        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void createOffscreenImage()
    {
        image = new BufferedImage(1200,1000,BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1200,1000);
    }

    private void drawShape(int x,int y){
        Random rand=new Random();
        int red, blue, green;
        int radius = rand.nextInt(90);
        int sides = (int) frame.configurationPanel.sidesField.getValue();
        Color colorRGB;

        if(frame.configurationPanel.colorCombo.getSelectedItem()=="Green")
        {
            colorRGB = Color.GREEN;
        }else
        if(frame.configurationPanel.colorCombo.getSelectedItem()=="Blue")
        {
            colorRGB = Color.BLUE;
        }
        else
        if(frame.configurationPanel.colorCombo.getSelectedItem()=="Red")
        {
            colorRGB = Color.RED;
        }
        else
        {
            red = rand.nextInt(255-128)+128;
            green = rand.nextInt(255-128)+128;
            blue = rand.nextInt(255-128)+128;
            colorRGB = new Color(red, green, blue);
        }
        graphics.setColor(colorRGB);
        graphics.fill(new RegularPolygon(x, y, radius, sides));

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    @Override
    public void update(Graphics graphics) {
    }

}


