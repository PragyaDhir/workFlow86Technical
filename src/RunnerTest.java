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
    }
    @Test
    void mainTest2() {
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
    }
}