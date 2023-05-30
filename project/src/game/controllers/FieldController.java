package game.controllers;

import game.models.Apple;
import game.models.Field;
import game.views.AppleView;
import game.views.FieldView;

import java.awt.*;

import static game.Params.*;

public class FieldController {
    private Field field;
    public void setFieldColor(Color color){
        field.setColor(color);
    }
    public FieldController(Field field){
        this.field = field;
    }
    public void setFieldApple(Apple apple){
        field.setApple(apple);
    }
    public void drawField(Graphics2D g, Component component){
        FieldView.draw(g,field,component);
    }
    public void drawApple(Graphics2D g){
        AppleView.draw(g,field.getApple());
    }
}
