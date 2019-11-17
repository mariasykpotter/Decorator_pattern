package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        List<Object> list = new ArrayList<Object>();
        for (Object el : smartArray.toArray()) {
            if (pr.test(el)) {
                list.add(el);
            }
        }
        this.setarray(list.toArray());
    }

    @Override
    public String operationDescription() {
        return "Filters an array depending on MyPredicate";
    }

}