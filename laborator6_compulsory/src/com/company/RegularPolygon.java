package com.company;

import java.awt.Polygon;

/**
 *
 * @author Giurgea Elisa
 * Stackoverflow for this function
 */
public class RegularPolygon extends Polygon {

    public RegularPolygon(int x, int y, int radius, int sides)
    {
        double a=2*Math.PI/sides;
        int i;
        for(i = 0; i < sides; ++i)
        {
            double xVertex = radius*Math.cos(a*i) + x;
            double yVertex = radius*Math.sin(a*i) + y;

            this.addPoint((int) xVertex, (int) yVertex);
        }
    }

}
