package pro.sky.Course2AlgorithmsPart1.service;

import org.springframework.stereotype.Service;
import pro.sky.Course2AlgorithmsPart1.exceptions.*;
import pro.sky.Course2AlgorithmsPart1.interfaces.StringList;
import pro.sky.Course2AlgorithmsPart1.model.StringListImpl;

@Service
public class StringListService {
    private StringListImpl stringList;

    public StringListService() {
    }

    public void createStringList(String size) {
        isValidArgument(size);
        int intSize = Integer.parseInt(size);
        if (intSize < 1) {
            throw new IncorrectSizeInput();
        }
        this.stringList = new StringListImpl(intSize);
    }

    public String add(String index, String item) {
        isExistList(stringList);
        isValidArgument(item);
        isInBound();
        if (index == null) {
            return stringList.add(item);
        } else {
            int intIndex = Integer.parseInt(index);
            isIndexCorrect(intIndex, true);
            return stringList.add(intIndex, item);
        }
    }

    public String set(String index, String item) {
        isExistList(stringList);
        isValidArgument(index, item);
        int intIndex = Integer.parseInt(index);
        isIndexCorrect(intIndex);
        return stringList.set(intIndex, item);
    }

    public String remove(String item) {
        isExistList(stringList);
        isValidArgument(item);
        isExistElement(item);
        return stringList.remove(item);
    }


    public String remove(int index) {
        isExistList(stringList);
        isIndexCorrect(index);
        return stringList.remove(index);
    }

    public boolean contains(String item) {
        return false;
    }

    public int indexOf(String item) {
        isExistList(stringList);
        isValidArgument(item);
        return stringList.indexOf(item);
    }

    public int lastIndexOf(String item) {
        isExistList(stringList);
        isValidArgument(item);
        return stringList.lastIndexOf(item);
    }

    public String get(String index) {
        isExistList(stringList);
        isValidArgument(index);
        int intIndex = Integer.parseInt(index);
        isIndexCorrect(intIndex);
        return stringList.get(intIndex);
    }

    public boolean equals(StringList otherList) {
        return false;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {

    }

    public String[] toArray() {
        return new String[0];
    }

    public String printArray() {
        isExistList(stringList);
        return stringList.toString();
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

    private void isValidArgument(String arg1, String arg2) {
        boolean isNull = arg1 == null || arg2 == null;
        boolean isEmpty = false;
        if (!isNull) {
            isEmpty = arg1.isEmpty() || arg2.isEmpty();
        }
        if (isNull || isEmpty) {
            throw new InvalidArgException();
        }
    }

    private void isExistList(StringListImpl stringList) {
        if (stringList == null) {
            throw new NoExistListException();
        }
    }

    private void isIndexCorrect(int index, boolean isAddMethod) {
        if (index >= stringList.getArrayList().length || index > stringList.getActualSize()) {
            throw new IndexOutOfRangeException();
        }
    }

    private void isIndexCorrect(int index) {
        if (index >= stringList.getArrayList().length || index >= stringList.getActualSize()) {
            throw new IndexOutOfRangeException();
        }
    }

    private void isInBound() {
        if (stringList.getActualSize() >= stringList.getArrayList().length) {
            throw new OutOfBoundsExceptions();
        }
    }

    private void isExistElement(String arg) {
        if (stringList.indexOf(arg) < 0) {
            throw new NotFoundException();
        }
    }
}
