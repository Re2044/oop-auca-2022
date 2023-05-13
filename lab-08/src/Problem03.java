class InvalidRadiusException extends Exception {
    private double radius;
    public InvalidRadiusException(double radius) {
        super("Invalid radius " + radius);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
}
class CustomCircle{
    private double radius;

    private static int numberOfObjects = 0;

    public CustomCircle()  throws InvalidRadiusException {
        this(1.0);
    }
    public CustomCircle(double newRadius) throws InvalidRadiusException {
        setRadius(newRadius);
        numberOfObjects++;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double newRadius) throws InvalidRadiusException {
        if (newRadius >= 0)
            radius = newRadius;
        else
            throw new InvalidRadiusException(newRadius);
    }
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }
    public double findArea() {
        return radius * radius * Math.PI;
    }
}
public class Problem03 {
    public static void main(String args[]){
        try {
            CustomCircle c1 = new CustomCircle(5);
            CustomCircle c2 = new CustomCircle(-5);
            CustomCircle c3 = new CustomCircle(0);
        }
        catch (InvalidRadiusException ex) {
            System.out.println(ex);
        }
        System.out.println("Number of objects created: " +
                CustomCircle.getNumberOfObjects());
    }
}
