import java.util.Arrays;

public class Problem03 {
    public static void main(String args[]){
        int[] integers = {
                8, 2, 6, 5, 1, 9, 3
        };

// ...

        Student[] students = {
                new Student("StudentD", 2.5, 1998),
                new Student("StudentA", 4.0, 2001),
                new Student("StudentB", 3.0, 2001),
                new Student("StudentC", 3.5, 2000)
        };

// ...

        BigRational[] rationals = {
                BigRational.parseBigRational("5/7"),
                BigRational.parseBigRational("1/2"),
                BigRational.parseBigRational("7/2"),
                BigRational.parseBigRational("1/3")
        };

        System.out.println("Sorting integers");
        System.out.println("Before:");
        System.out.println(Arrays.toString(integers));
        System.out.println("After:");
        MyArrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println("Sorting students by name");

        System.out.println("Before: ");
        System.out.println(Arrays.toString(students));
        MyArrays.sort(students,(a,b)->((Student)a).getName().compareTo(((Student)b).getName()));
        System.out.println("After: ");
        System.out.println(Arrays.toString(students));

        System.out.println("Sorting rationals");
        System.out.println("Before:");
        System.out.println(Arrays.toString(rationals));
        System.out.println("After:");
        MyArrays.sort(rationals);
        System.out.println(Arrays.toString(rationals));
    }
}
