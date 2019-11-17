package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


import static org.junit.Assert.*;

public class SmartArrayDecoratorsTest {
    private SmartArray smartArr;

    @Before
    public void SetUp() {
        smartArr = new BaseArray(new Object[]{5, 6, 7, 8, 9, 9, 9, 4, 3, 2, 1});
    }

    @Test
    public void testBaseArray() {
        assertArrayEquals(smartArr.toArray(), new Object[]{5, 6, 7, 8, 9, 9, 9, 4, 3, 2, 1});
        assertEquals(smartArr.size(), 11);
        assertEquals(smartArr.operationDescription(), "No operation");
    }

    @Test
    public void testDistinctDecorator() {
        SmartArray distinctArr = new DistinctDecorator(smartArr);
        assertArrayEquals(distinctArr.toArray(), new Object[]{5, 6, 7, 8, 9, 4, 3, 2, 1});
        assertEquals(distinctArr.size(), 9);
        assertEquals(distinctArr.operationDescription(), "Removes all the same elements from the array.");
    }

    @Test
    public void testFilterDecorator() {
        MyPredicate mypred = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (int) t >= 5;
            }
        };
        SmartArray filteredArr = new FilterDecorator(smartArr, mypred);
        assertArrayEquals(filteredArr.toArray(), new Object[]{5, 6, 7, 8, 9, 9, 9});
        assertEquals(filteredArr.size(), 7);
        assertEquals(filteredArr.operationDescription(), "Filters an array depending on MyPredicate");
    }

    ;

    @Test
    public void testMapDecorator() {
        MyFunction myfunc = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return (int) t - 5;
            }

            ;
        };
        SmartArray mappedArr = new MapDecorator(smartArr, myfunc);
        assertArrayEquals(mappedArr.toArray(), new Object[]{0, 1, 2, 3, 4, 4, 4, -1, -2, -3, -4});
        assertEquals(mappedArr.size(), 11);
        assertEquals(mappedArr.operationDescription(), "Applies my function to every element of array.");
    }

    @Test
    public void testSortDecorator() {
        MyComparator mycompar = new MyComparator() {
            @Override
            public int compare(Object t1, Object t2) {
                return (int) t1 - (int) t2;
            }
        };
        SmartArray sortedArr = new SortDecorator(smartArr, mycompar);
        assertArrayEquals(sortedArr.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9});
        assertEquals(sortedArr.size(), 11);
        assertEquals(sortedArr.operationDescription(), "Sorts an array according to some special function.");
    }
}