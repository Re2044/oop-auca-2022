package game.views;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import game.models.Snake;

import static game.Params.GAP_PX;
import static game.utilities.DrawingHelpers.*;
import static game.utilities.DrawingHelpers.canvasSize;

public class SnakeView {
    private SnakeView(){}
    public static void draw(Graphics2D g,Snake snake){
        for(var point : snake.getBody() )   {
            int row = point.x;
            int col = point.y;
            g.setColor(snake.getColor());

            g.fill(new Rectangle2D.Float(horShift+canvasSize*row,verShift+canvasSize*col,canvasSize-GAP_PX,canvasSize-GAP_PX));
        }
    }
}
