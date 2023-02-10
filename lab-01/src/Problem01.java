import java.util.Scanner;

public class Problem01 {
    public static void main(String args[]){
        Turtle [] TurtleArray = new Turtle [1];
        TurtleArray[0]= new Turtle("up",0,0,0);
        //TurtleArray[1]= new Turtle("up",2,19,19);
        Field field = new Field(20,20,1,TurtleArray,0);
        Scanner in = new Scanner(System.in);
        String inString = in.nextLine();

        while(inString!="exit"){
            boolean flag =false;
            if(inString.length()>=4 && inString.substring(0,4).equals("move")){
                try{
                    String num = inString.substring(5,inString.length());
                    try {
                        int val = Integer. parseInt(num);
                        if(val<0){
                            throw new IllegalArgumentException("The number of steps can't be negative. Please, try again.");
                        }
                        field.MoveCurrTurtle(val,field);
                        flag=true;
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("The number of steps is not valid. Please, try again.");
                        flag=true;
                    }
                }
                catch(NumberFormatException nfe){
                    System.out.println("The number of steps was not provided. Please, try again.");
                    flag=true;
                }

            }
            if(inString.length()>=6 && inString.substring(0,6).equals("select")){
                try {
                    String num = inString.substring(7, inString.length());
                    try {
                        int val = Integer.parseInt(num);

                        if(val!=1 || val!=2){
                            throw new IllegalArgumentException("There is no turtle with the number" +val+". Please, try again.");
                        }
                        field.SetCurrTurtle(val);
                        flag=true;
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("The number of steps is not valid. Please, try again.");
                        flag=true;
                    }
                }
                catch (NumberFormatException nfe) {
                    System.out.println("The turtle number was not provided. Please, try again.");
                    flag=true;
                }
            }
            switch(inString){
                case "exit" :
                    System.exit(0);
                    break;
                case "turn-right":
                    field.TurnCurrTurtleRight();
                    flag=true;
                    break;
                case "turn-left":
                    field.TurnCurrTurtleLeft();
                    flag=true;
                    break;
                case "pen-up":
                    field.PenCurrTurtleUp();
                    flag=true;
                    break;
                case "pen-down":
                    field.PenCurrTurtleDown();
                    flag=true;
                    break;
                case "display" :
                    field.Display();
                    flag=true;
                    break;
            }
            if(flag==false){
                throw new IllegalArgumentException("Unknown command. Please, try again.");
            }
            inString = in.nextLine();
            if(inString.length()==0){
                throw new IllegalArgumentException("No commands to execute were provided. Please, try again.");
            }
        }
        System.exit(0);

    }
    public static class Field {
        private int currTurtle = 0;
        private int sizeX = 20;
        private int sizeY = 20;
        private int TurtleCount = 2;
        private char [][]CellState = new char [sizeX][sizeY];
        private Turtle[] TurtleList = new Turtle[TurtleCount];
        public void MoveCurrTurtle(int val,Field field){
            TurtleList[currTurtle].Move(val,field);

        }
        public void TurnCurrTurtleLeft(){
            TurtleList[currTurtle].TurnLeft();

        }
        public void TurnCurrTurtleRight(){
            TurtleList[currTurtle].TurnRight();
        }
        public void PenCurrTurtleUp(){
            TurtleList[currTurtle].PenUp();
        }
        public void PenCurrTurtleDown(){
            TurtleList[currTurtle].PenDown();
        }
        public void SetCurrTurtle(int currTurtle){
            this.currTurtle = currTurtle-1;
        }
        public Field(int sizeX,int sizeY,int TurtleCount,Turtle[] TurtleList,int currTurtle){
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.TurtleCount = TurtleCount;
            this.TurtleList = TurtleList;
            this.currTurtle = currTurtle;
            for(int i = 0 ;i<this.sizeX;i++){
                for(int j=0;j<this.sizeY;j++){
                    this.CellState[i][j]='.';
                }
            }
            for(int i = 0;i<this.TurtleCount;i++){
                CellState[TurtleList[i].posY][TurtleList[i].posX]='T';
            }
        }
        public void ColorCell(int posX,int posY){
            CellState[posY][posX]='*';
        }
        public void ColorCell(int posXFirst,int posYFirst,int posXSecond,int posYSecond){
            for(int i =posXFirst; i<=posXSecond;i++){
                for(int j = posYFirst;j<=posYSecond;j++){
                    CellState[j][i]='*';
                }
            }
            CellState[TurtleList[currTurtle].posY][TurtleList[currTurtle].posX]='T';
        }
        public void Display(){
            for(int i = 0 ; i<sizeX;i++){
                for(int j = 0;j<sizeY;j++){
                    System.out.print(CellState[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static class Turtle {
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
        public void Move(int val, Field field){
            int prevPosX = posX;
            int prevPosY = posY;
            if(turnState==0){
                if(posX+val<field.sizeX)
                    posX+=val;
                else
                    posX = field.sizeX-1;
            }
            if(turnState==1){
                if(posY+val<field.sizeY)
                    posY+=val;
                else
                    posY = field.sizeY-1;
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
            field.CellState[prevPosY][prevPosX]='.';
            if(penState=="down"){
                field.ColorCell(Math.min(prevPosX,posX),Math.min(prevPosY,posY),Math.max(prevPosX,posX),Math.max(prevPosY,posY));
            }
        }

    }


}
