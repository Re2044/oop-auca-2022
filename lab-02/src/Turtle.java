
public class Turtle {
    private String penState;
    private int turnState;
    private int posX ;
    private int posY;
    public Turtle(String penState,int turnState,int posX,int posY){
        this.penState = penState;
        this.turnState = turnState;
        this.posX = posX;
        this.posY = posY;
    }
    public void PenDown(){
        penState = "down";
    }
    public void PenUp(){
        penState = "up";
    }
    public void TurnLeft(){
        turnState -=1;
        if(turnState<0)
            turnState=3;
    }
    public void TurnRight(){
        turnState+=1;
        turnState%=4;
    }
    public int GetCord(char Cord) {
        boolean flag = false;
        if(Cord=='x') {
           flag = true;
           return posX;
        }
        if(Cord=='y'){
           flag = true;
           return posY;
        }
        if(flag == false) {
            throw new IllegalArgumentException("Invalid request argument");
        }
        return 1;
    }
    public void Move( int val, Field field){

        int prevPosX = posX;
        int prevPosY = posY;
        if(turnState==0){
            if(posX+val<field.GetSize('x'))
                posX+=val;
            else
                posX = field.GetSize('x')-1;
        }
        if(turnState==1){
            if(posY+val<field.GetSize('y'))
                posY+=val;
            else
                posY = field.GetSize('y')-1;
        }
        if(turnState==2){
            if(posX-val>=0)
                posX-=val;
            else
                posX = 0;
        }
        if(turnState==3){
            if(posY-val>=0)
                posY-=val;
            else
                posX = 0;
        }
        field.EditCell(prevPosY,prevPosX,'.');
        if(penState=="down"){
            field.ColorCell(Math.min(prevPosX,posX),Math.min(prevPosY,posY),Math.max(prevPosX,posX),Math.max(prevPosY,posY));
        }
    }

}


