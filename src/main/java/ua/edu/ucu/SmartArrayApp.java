package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyByTwo(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object ob, Object obj) {
                return ((Integer) ob) - ((Integer) obj);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
        //sa = new MapDecorator(new SortDecorator
        // (new FilterDecorator(sa, pr), cmp), func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNames(Student[] students) {
        final double GPA = 4;
        MyPredicate secondYearandGPA = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2
                        && ((Student) t).getgPA() >= GPA;
            }
        };

        MyFunction getNameandSurname = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " "
                        + ((Student) t).getName();
            }
        };
        MyComparator compareBySurname = new MyComparator() {
            @Override
            public int compare(Object ob, Object obj) {
                return ((Student) ob).getSurname().compareTo
                        (((Student) obj).getSurname());
            }
        };
        SmartArray smartStudents = new BaseArray(students);
        smartStudents = new DistinctDecorator(smartStudents);
        smartStudents = new FilterDecorator
                (smartStudents, secondYearandGPA); // Result: [2, 1, 3];
        smartStudents = new SortDecorator
                (smartStudents, compareBySurname); // Result: [1, 2, 3]
        smartStudents = new MapDecorator(smartStudents, getNameandSurname);
        //smartStudents = new MapDecorator(new SortDecorator
        // (new FilterDecorator(smartStudents, secondYearandGPA),
        // compareBySurname), getNameandSurname);
        Object[] result = smartStudents.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}