package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.List;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    public MapDecorator(SmartArray smartArray, MyFunction f) {
        super(smartArray);
        List<Object> list = new ArrayList<Object>();
        for (Object el : smartArray.toArray()) {
            list.add(f.apply(el));
        }
        this.setarray(list.toArray());
    }

    @Override
    public String operationDescription() {
        return "Applies my function to every element of array.";
    }

}