package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        Object[] arr = smartArray.toArray();
        Arrays.sort(arr, comp);
        this.setarray(arr);
    }

    @Override
    public String operationDescription() {
        return "Sorts an array according to some special function.";
    }
}