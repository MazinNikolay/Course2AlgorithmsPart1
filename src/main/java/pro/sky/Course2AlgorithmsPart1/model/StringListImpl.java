package pro.sky.Course2AlgorithmsPart1.model;

import pro.sky.Course2AlgorithmsPart1.exceptions.*;
import pro.sky.Course2AlgorithmsPart1.interfaces.StringList;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private final String[] arrayList;
    private int actualSize;

    public StringListImpl(int arraySize) {
        arrayList = new String[arraySize];
        actualSize = 0;
    }

    public int getActualSize() {
        return actualSize;
    }

    public String[] getArrayList() {
        return arrayList;
    }

    @Override
    public String add(String item) {
        isValidArgument(item);
        isInBound();
        arrayList[actualSize++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        isValidArgument(item);
        isInBound();
        isIndexInRange(index);
        if (index == actualSize) {
            arrayList[actualSize++] = item;
            return item;
        }
        System.arraycopy(arrayList, index, arrayList, index + 1, actualSize - index);
        arrayList[index] = item;
        actualSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        isValidArgument(item);
        isIndexInRange(index);
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        isValidArgument(item);
        isExistElement(item);
        int index = indexOf(item);
        isIndexInRange(index);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        isIndexInRange(index);
        String item = get(index);
        if (index != actualSize) {
            System.arraycopy(arrayList, index + 1, arrayList, index, actualSize - index);
            return item;
        }
        arrayList[actualSize--] = null;
        return item;
    }

    @Override
    public boolean contains(String item) {
        isValidArgument(item);
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        isValidArgument(item);
        for (int i = 0; i < actualSize; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        isValidArgument(item);
        for (int i = actualSize - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        isIndexInRange(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        isValidArgument(otherList);
        return this == otherList && this.hashCode() == otherList.hashCode() && Arrays.equals(this.toArray(), otherList.toArray());
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
        Arrays.fill(arrayList, null);
        actualSize = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = Arrays.copyOf(arrayList, actualSize);
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

    private void isValidArgument(String arg) {
        boolean isNull = arg == null;
        boolean isEmpty = false;
        if (!isNull) {
            isEmpty = arg.isEmpty();
        }
        if (isNull || isEmpty) {
            throw new InvalidArgException();
        }
    }

    private void isValidArgument(StringList arg) {
        if (arg == null) {
            throw new InvalidArgException();
        }
    }

    private void isIndexInRange(int index) {
        if (index < 0 || index >= actualSize) {
            throw new IndexOutOfRangeException();
        }
    }

    private void isInBound() {
        if (actualSize >= arrayList.length) {
            throw new OutOfBoundsExceptions();
        }
    }

    private void isExistElement(String arg) {
        if (indexOf(arg) < 0) {
            throw new NotFoundException();
        }
    }
}