package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    private Object[] array;

    private SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public Object[] getarray() {
        return array;
    }

    public void setarray(Object[] value) {
        array = value;
    }

    public SmartArray getsmartArray() {
        return smartArray;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public int size() {
        return array.length;
    }
}