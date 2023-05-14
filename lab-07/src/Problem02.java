import java.util.Arrays;
import java.util.Comparator;
class Student implements MyComparable<Student> {
    private String name;
    private double GPA;
    private int birthYear;
    Student(String name,double GPA,int birthYear){
        this.name = name;
        this.GPA = GPA;
        this.birthYear = birthYear;
    }
    public String getName(){
        return this.name;
    }
    public double getGPA(){
        return this.GPA;
    }
    public int getYear(){
        return this.birthYear;
    }
    @Override
    public String toString(){
        return "Student{name='"+name+"', GPA="+GPA+", birthYear="+birthYear+"}";
    }
    @Override
    public int compareTo( Student a) {
        return a.getName().compareTo(this.name);
    }
}
public class Problem02 {
    public static class CompareByName implements Comparator<Student> {
        @Override
        public int compare(Student first, Student second){
            return first.getName().compareTo(second.getName());
        }
    }
    public static class CompareByGPA implements Comparator<Student> {
        @Override
        public int compare(Student first, Student second){
            return Double.compare(first.getGPA(),second.getGPA());
        }
    }

    public static void main(String args[]){
        Student[] students = {
                new Student("StudentD", 2.5, 1998),
                new Student("StudentA", 4.0, 2001),
                new Student("StudentB", 3.0, 2001),
                new Student("StudentC", 3.5, 2000)
        };
        System.out.println("Sorting students by name");

        System.out.println("Before: ");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students,new CompareByName());
        System.out.println("After: ");
        System.out.println(Arrays.toString(students));

        System.out.println("Sorting students by GPA");

        System.out.println("Before: ");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students,new CompareByGPA());
        System.out.println("After: ");
        System.out.println(Arrays.toString(students));

        System.out.println("Sorting students by birth year");

        System.out.println("Before: ");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students,(a,b)->a.getYear()-b.getYear());
        System.out.println("After: ");
        System.out.println(Arrays.toString(students));
    }
}
