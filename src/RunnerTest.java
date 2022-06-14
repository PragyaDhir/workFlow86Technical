import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {


    @Test
    void mainTest1() throws Exception {
        String data = "A" +
                "\nB C D"
                +"\nY"
                +"\nC"
                +"\nE F G"
                +"\nY"
                +"\nG"
                +"\nH I"
                +"\nN"
                +"\nG"
                +"\nY"
                +"\nC"
                +"\nY"
                +"\nA"
                +"\nN";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Scanner scanner = new Scanner(System.in);
        Runner.main(null);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("H");
        expectedList.add("I");
        assertEquals(expectedList, Runner.getDependencies("G"));

        expectedList = new ArrayList<>();
        expectedList.add("E");
        expectedList.add("F");
        expectedList.add("H");
        expectedList.add("I");
        expectedList.add("G");

        assertEquals(expectedList, Runner.getDependencies("C"));

        expectedList = new ArrayList<>();
        expectedList.add("B");
        expectedList.add("E");
        expectedList.add("F");
        expectedList.add("H");
        expectedList.add("I");
        expectedList.add("G");
        expectedList.add("C");
        expectedList.add("D");

        assertEquals(expectedList, Runner.getDependencies("A"));
    }
    @Test
    void mainTest2() throws Exception {
        String data = "A" +
                "\nB C D"
                +"\nY"
                +"\nC"
                +"\nE F G E"
                +"\nY"
                +"\nG"
                +"\nH I"
                +"\nY"
                +"\nI"
                +"\nD"
                +"\nN"
                +"\nG"
                +"\nY"
                +"\nC"
                +"\nY"
                +"\nA"
                +"\nN";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Scanner scanner = new Scanner(System.in);
        Runner.main(null);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("H");
        expectedList.add("D");
        expectedList.add("I");
        assertEquals(expectedList, Runner.getDependencies("G"));

        expectedList = new ArrayList<>();
        expectedList.add("E");
        expectedList.add("F");
        expectedList.add("H");
        expectedList.add("D");
        expectedList.add("I");
        expectedList.add("G");

        assertEquals(expectedList, Runner.getDependencies("C"));

        expectedList = new ArrayList<>();
        expectedList.add("B");
        expectedList.add("E");
        expectedList.add("F");
        expectedList.add("H");
        expectedList.add("D");
        expectedList.add("I");
        expectedList.add("G");
        expectedList.add("C");
        expectedList.add("D");

        assertEquals(expectedList, Runner.getDependencies("A"));
    }
    @Test
    void mainTest3() {
        String data = "A" +
                "\nB C D"
                +"\nY"
                +"\nC"
                +"\nE F G E"
                +"\nY"
                +"\nG"
                +"\nH I"
                +"\nY"
                +"\nI"
                +"\nC"
                +"\nN"
                +"\nG"
                +"\nY"
                +"\nC"
                +"\nY"
                +"\nA"
                +"\nN";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Scanner scanner = new Scanner(System.in);
        Runner.main(null);

        assertThrowsExactly(Exception.class ,() -> Runner.getDependencies("G"));
        assertThrowsExactly(Exception.class ,() -> Runner.getDependencies("C"));
        assertThrowsExactly(Exception.class ,() -> Runner.getDependencies("A"));

    }
}