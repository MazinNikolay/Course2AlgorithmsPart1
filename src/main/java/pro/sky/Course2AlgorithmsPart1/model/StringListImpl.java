package pro.sky.Course2AlgorithmsPart1.model;

import pro.sky.Course2AlgorithmsPart1.exceptions.NoAddedException;
import pro.sky.Course2AlgorithmsPart1.interfaces.StringList;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] arrayList;
    private int actualSize;

    public StringListImpl(int arraySize) {
        arrayList = new String[arraySize];
        actualSize = 0;
    }

    public String[] getArrayList() {
        return arrayList;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setArrayList(String[] arrayList) {
        this.arrayList = arrayList;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }

    @Override
    public String add(String item) {
        arrayList[indexOf(null)] = item;
        actualSize++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        boolean isEndOfList = index == arrayList.length - 1 && arrayList[index] != null;
        boolean endOfListNull = arrayList[index] != null && arrayList[arrayList.length - 1] == null;
        boolean endOfListNoNull = arrayList[index] != null && arrayList[arrayList.length - 1] != null;
        if (endOfListNull) {
            for (int i = actualSize; i > index; i--) {
                arrayList[i] = arrayList[i - 1];
            }
        }
        if (isEndOfList || endOfListNoNull) {
            throw new NoAddedException();
        }
        arrayList[index] = item;
        actualSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        arrayList[index] = null;
        actualSize--;
        for (int i = index; i < actualSize; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[actualSize] = null;
        return item;
    }

    @Override
    public String remove(int index) {
        String item = get(index);
        arrayList[index] = null;
        actualSize--;
        for (int i = index; i < actualSize; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[actualSize] = null;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return lastIndexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayList.length; i++) {
            if (item == null && arrayList[i] != null) {
                continue;
            } else if (item == null && arrayList[i] == null) {
                return i;
            }
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = actualSize - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
            return arrayList[index];
        }

    @Override
    public boolean equals(StringList otherList) {
        return this == otherList && this.hashCode() == otherList.hashCode();
    }

    @Override
    public int size() {
        return actualSize;
    }

    @Override
    public boolean isEmpty() {
        for (String s : arrayList) {
            if (s != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] array = getArrayList();
        return array;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(actualSize);
        result = 31 * result + Arrays.hashCode(arrayList);
        return result;
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }
}
