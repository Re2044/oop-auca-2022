package game.views;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import game.models.Apple;

import static game.Params.*;
import static game.utilities.DrawingHelpers.*;


public class AppleView {
    private AppleView(){}
    public static void draw(Graphics2D g,Apple apple){
        g.setColor(apple.getColor());
        g.fill(new Rectangle2D.Float(horShift+canvasSize*apple.getCol(),verShift+canvasSize*apple.getRow(),canvasSize-GAP_PX,canvasSize-GAP_PX));
    }
}
