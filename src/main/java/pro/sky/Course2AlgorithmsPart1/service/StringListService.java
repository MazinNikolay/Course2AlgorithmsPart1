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
        if (index == null) {
            return stringList.add(item);
        } else {
            int intIndex = Integer.parseInt(index);
            return stringList.add(intIndex, item);
        }
    }

    public String set(String index, String item) {
        isExistList(stringList);
        int intIndex = Integer.parseInt(index);
        return stringList.set(intIndex, item);
    }

    public String remove(String item) {
        isExistList(stringList);
        return stringList.remove(item);
    }


    public String remove(int index) {
        isExistList(stringList);
        return stringList.remove(index);
    }

    public boolean contains(String item) {
        isExistList(stringList);
        return stringList.contains(item);
    }

    public int indexOf(String item) {
        isExistList(stringList);
        return stringList.indexOf(item);
    }

    public int lastIndexOf(String item) {
        isExistList(stringList);
        return stringList.lastIndexOf(item);
    }

    public String get(String index) {
        isExistList(stringList);
        int intIndex = Integer.parseInt(index);
        return stringList.get(intIndex);
    }

    public boolean equals(String otherList) {
        isExistList(stringList);
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
        isExistList(stringList);
        return stringList.isEmpty();
    }

    public void clear() {
        isExistList(stringList);
        stringList.clear();
    }

    public String[] toArray() {
        isExistList(stringList);
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

    private void isExistList(StringListImpl stringList) {
        if (stringList == null) {
            throw new NoExistListException();
        }
    }
}
