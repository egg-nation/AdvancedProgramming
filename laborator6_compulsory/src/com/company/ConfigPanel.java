package com.company;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Giurgea Elisa
 */
public class ConfigPanel extends javax.swing.JPanel {

    JSpinner sidesField;
    JComboBox colorCombo;
    JLabel label;

    final MainFrame frame;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }


    private void init()
    {
        JLabel sidesLabel = new JLabel("Sides:");
        sidesField = new JSpinner (new SpinnerNumberModel(0,0,10,1));
        sidesField.setValue(6);

        JLabel colorLabel=new JLabel ("Color:");
        String[] colors={"Random", "Red", "Blue", "Green"};
        colorCombo= new JComboBox(colors);

        add(colorLabel);
        add(colorCombo);

        add(sidesLabel);
        add(sidesField);

    }

}


