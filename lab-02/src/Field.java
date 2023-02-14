

public class Field {
    private int currTurtle = 0;
    private int sizeX = 20;
    private int sizeY = 20;
    private int TurtleCount = 2;
    private char [][]CellState = new char [sizeX][sizeY];
    public void GetCommand(String[] ins){
        boolean flag = false;
        if (ins.length == 0 || ins[0].isEmpty()) {
            throw new IllegalArgumentException("No commands to execute were provided. Please, try again.");
        }
        switch (ins[0]) {

            case "exit":
                System.exit(0);
                break;
            case "turn-right":
                this.TurnCurrTurtleRight();
                flag = true;
                break;
            case "turn-left":
                this.TurnCurrTurtleLeft();
                flag = true;
                break;
            case "pen-up":
                this.PenCurrTurtleUp();
                flag = true;
                break;
            case "pen-down":
                this.PenCurrTurtleDown();
                flag = true;
                break;
            case "display":
                this.Display();
                flag = true;
                break;
            case "move":
                flag = true;
                if(ins.length==1){
                    throw new IllegalArgumentException("The number of steps was not provided. Please, try again.");
                }
                if (ins.length > 2) {
                    throw new IllegalArgumentException("More arguments than necessary were provided for the \"move\" command. Please, try again.");
                } else {
                    int val = 0;
                    try {
                        val = Integer.parseInt(ins[1]);
                    }
                    catch (IllegalArgumentException ex) {
                        throw new IllegalArgumentException("The number of steps is not valid. Please, try again.");
                    }
                    if(val<0){
                        throw new IllegalArgumentException("The number of steps can't be negative. Please, try again.");
                    }
                    this.MoveCurrTurtle(val, this);
                }
                break;
            case "select":
                flag = true;
                if(ins.length==1){
                    throw new IllegalArgumentException("The turtle number was not provided. Please, try again.");
                }
                if (ins.length > 2) {
                    throw new IllegalArgumentException("More arguments than necessary were provided for the \"select\" command. Please, try again.");
                }
                else {
                    int val = 0;
                    try {
                        val = Integer.parseInt(ins[1]);
                    }
                    catch (IllegalArgumentException ex) {
                        throw new IllegalArgumentException("The turtle number is not valid. Please, try again.");
                    }
                    if(val<0 || val>this.TurtleCount){
                        throw new IllegalArgumentException("There is no turtle with the number "+val+". Please, try again.");
                    }
                    this.SetCurrTurtle(val);
                    flag = true;

                }
                break;
        }
        if (flag == false) {
            throw new IllegalArgumentException("Unknown command. Please, try again.");
        }
    }
    private Turtle[] TurtleList = new Turtle[TurtleCount];
    public int GetTurtleCount(){return TurtleCount;}
    public void MoveCurrTurtle(int val,Field field){TurtleList[currTurtle].Move(val,field);}
    public void TurnCurrTurtleLeft(){TurtleList[currTurtle].TurnLeft();}
    public int GetSize(char Cord) {
        boolean flag = false;
        if(Cord=='x') {
            flag = true;
            return sizeX;
        }
        if(Cord=='y'){
            flag = true;
            return sizeY;
        }
        if(flag == false) {
            throw new IllegalArgumentException("Invalid request argument");
        }
        return 1;
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
            CellState[TurtleList[i].GetCord('y')][TurtleList[i].GetCord('x')]='T';
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
        CellState[TurtleList[currTurtle].GetCord('y')][TurtleList[currTurtle].GetCord('x')]='T';
    }
    public void EditCell(int posX,int posY,char NewChar){
        CellState[posY][posX]=NewChar;
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