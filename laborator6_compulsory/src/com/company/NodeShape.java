package com.company;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Giurgea Elisa
 */

public class NodeShape extends Ellipse2D.Double {
    public NodeShape(double x, double y, double radius)
    {
        super(x - radius/2,y - radius/2, radius, radius);
    }
}
