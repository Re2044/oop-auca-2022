package game.controllers;

public class GameSpeedController {
    private  int speed = 200;
    private int dSpeed = 50;
    public GameSpeedController(int speed,int dSpeed){
        setDSpeed(dSpeed);
        setSpeed(speed);
    }
    public int getSpeed(){
        return speed;
    }
    public void setDSpeed(int dSpeed ){
        this.dSpeed = dSpeed;
    }
    public  void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public int getDSpeed(){
        return dSpeed;
    }

}
