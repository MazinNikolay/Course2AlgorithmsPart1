package pro.sky.Course2AlgorithmsPart1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Course2AlgorithmsPart1.exceptions.IndexOutOfRangeException;
import pro.sky.Course2AlgorithmsPart1.exceptions.InvalidArgException;
import pro.sky.Course2AlgorithmsPart1.exceptions.NotFoundException;
import pro.sky.Course2AlgorithmsPart1.exceptions.OutOfBoundsExceptions;
import pro.sky.Course2AlgorithmsPart1.interfaces.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringList out;

    @BeforeEach
    public void initVariable() {
        out = new StringListImpl(5);
    }

    @Test
    void addCorrect() {
        String expected = "addedArg";
        String actual = out.add("addedArg");
        assertEquals(expected, actual);
    }

    @Test
    void checkEmptyArgMethod() {
        assertThrows(InvalidArgException.class, () -> out.add(null));
    }

    @Test
    void checkOutOfBoundMethod() {
        out.add("111");
        out.add("22");
        out.add("333");
        out.add("444");
        out.add("555");
        assertThrows(OutOfBoundsExceptions.class, () -> out.add("666"));
    }

    @Test
    void addToPositionCorrect() {
        String expectedAdded = "added";
        String expectedMoved = "moved";
        out.add("moved");
        String actualAdded = out.add(0, "added");
        String actualMoved = out.get(1);
        assertEquals(expectedAdded, actualAdded);
        assertEquals(expectedMoved, actualMoved);
    }

    @Test
    void checkIndexOutOfRangeMethod() {
        out.add("111");
        assertThrows(IndexOutOfRangeException.class, () -> out.add(2, "666"));
    }

    @Test
    void setCorrect() {
        out.add("111");
        String expected = "setArg";
        String actual = out.set(0, "setArg");
        assertEquals(expected, actual);
    }

    @Test
    void checkNotFoundItemMethod() {
        out.add("111");
        assertThrows(NotFoundException.class, () -> out.remove("222"));
    }

    @Test
    void removeWithItemCorrect() {
        out.add("111");
        out.add("222");
        out.add("333");
        String expectedRemoved = "222";
        String expectedMoved = "333";
        String actualRemoved = out.remove("222");
        String actualMoved = out.get(1);
        assertEquals(expectedRemoved, actualRemoved);
        assertEquals(expectedMoved, actualMoved);
    }

    @Test
    void containsCorrect() {
        out.add("111");
        boolean expected = true;
        boolean actual = out.contains("111");
        assertEquals(expected, actual);
    }

    @Test
    void indexOfCorrect() {
        out.add("111");
        int expected = 0;
        int actual = out.indexOf("111");
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOfCorrect() {
        out.add("111");
        out.add("222");
        out.add("111");
        int expected = 2;
        int actual = out.lastIndexOf("111");
        assertEquals(expected, actual);
    }

    @Test
    void getCorrect() {
        out.add("111");
        out.add("222");
        out.add("333");
        String expected = "222";
        String actual = out.get(1);
        assertEquals(expected, actual);
    }

    @Test
    void EqualsCorrect() {
        out.add("111");
        out.add("222");
        out.add("333");
        StringList otherList = new StringListImpl(4);
        StringList copyList = out;
        boolean expectedCopy = true;
        boolean expectedOther = false;
        boolean actualCopy = out.equals(copyList);
        boolean actualOther = out.equals(otherList);
        assertEquals(expectedCopy, actualCopy);
        assertEquals(expectedOther, actualOther);
    }

    @Test
    void sizeCorrect() {
        out.add("111");
        out.add("222");
        out.add("111");
        int expected = 3;
        int actual = out.size();
        assertEquals(expected, actual);
    }

    @Test
    void isEmptyCorrect() {
        boolean expected = true;
        boolean actual = out.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void clearCorrect() {
        out.add("111");
        out.add("222");
        out.add("333");
        out.clear();
        boolean expected = true;
        boolean actual = out.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void toArrayCorrect() {
        out.add("111");
        out.add("222");
        out.add("333");
        String[] expected = {"111", "222", "333"};
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }
}