import java.util.Random;

public class Apple {
    private int row;
    private int col;
    private Random generator;
    public Apple(int minRow,int maxRow,int minCol,int maxCol,int seed){
        generator = new Random(seed);
        changeLocation(minRow,maxRow,minCol,maxCol);
    }
    public void changeLocation(int minRow,int maxRow, int minCol,int maxCol){
        this.row = generator.nextInt(minRow,maxRow);
        this.col = generator.nextInt(minRow,maxRow);
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
}
