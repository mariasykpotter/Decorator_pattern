package ua.edu.ucu.smartarr;
import java.util.ArrayList;
import java.util.List;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < smartArray.toArray().length; i++) {
            if (!list.contains(smartArray.toArray()[i])) {
                list.add(smartArray.toArray()[i]);
            }
        }
        this.setarray(list.toArray());
    }

    @Override
    public String operationDescription() {
        return "Removes all the same elements from the array.";
    }

}