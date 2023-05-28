package game.controllers;

public class GameSpeedController {
    private static int speed = 200;
    public static int getSpeed(){
        return speed;
    }
    public static void setSpeed(int newSpeed){
        speed  = newSpeed;
    }
}
