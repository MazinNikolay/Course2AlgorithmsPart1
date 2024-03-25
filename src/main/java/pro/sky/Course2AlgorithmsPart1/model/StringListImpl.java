package pro.sky.Course2AlgorithmsPart1.model;

import pro.sky.Course2AlgorithmsPart1.interfaces.StringList;

public class StringListImpl implements StringList {
    private String[] arrayList;
    private int actualSize;

    public StringListImpl(int arraySize) {
        if (arraySize < 1) {

        }
        arrayList = new String[arraySize];
        actualSize = 0;
    }

    @Override
    public String add(String item) {
        arrayList[actualSize] = item;
        actualSize++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
