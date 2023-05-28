package game.controllers;

import game.models.Field;

import java.awt.*;

import static game.Params.*;

public class FieldController {
    public static void setFieldColor(Color color, Field field){
        field.setColor(color);
    }

}
