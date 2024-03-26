package pro.sky.Course2AlgorithmsPart1.service;

import org.springframework.stereotype.Service;
import pro.sky.Course2AlgorithmsPart1.exceptions.*;
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
        if (!stringList.contains(item)) {
            throw new NotFoundException();
        }
        return stringList.remove(item);
    }


    public String remove(int index) {
        isExistList(stringList);
        isIndexCorrect(index);
        if (stringList.get(index) == null) {
            throw new NotFoundException();
        }
        return stringList.remove(index);
    }

    public boolean contains(String item) {
        isExistList(stringList);
        isValidArgument(item);
        return stringList.contains(item);
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

    public boolean equals(String otherList) {
        isExistList(stringList);
        isValidArgument(otherList);
        StringListImpl resultList;
        switch (otherList) {
            case "first":
                resultList = new StringListImpl(10);
                break;
            case "second":
                resultList = stringList;
                break;
            default:
                throw new InvalidArgException();
        }
        return stringList.equals(resultList);
    }

    public int size() {
        return stringList.size();
    }

    public boolean isEmpty() {
        return stringList.isEmpty();
    }

    public void clear() {
        stringList.clear();
    }

    public String[] toArray() {
        return stringList.toArray();
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
        if (stringList.lastIndexOf(arg) < 0) {
            throw new NotFoundException();
        }
    }
}
