import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain1() {
        String data = "1\n2\n4.5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Main.main(null);
        Double expected = 13.5;
        String result = outContent.toString().replaceAll("[\\r\\n]", "");
        Double actual = Double.parseDouble(result);
        assertEquals(expected, actual);
    }

    @Test
    public void testMain2() {
        String data = "82\n7162\n20.7836";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Main.main(null);
        Double expected = 150556.39;
        String result = outContent.toString().replaceAll("[\\r\\n]", "");
        Double actual = Double.parseDouble(result);
        assertEquals(expected, actual);
    }

    @Test
    public void testMain3() {
        String data = "240\n4260\n42.2751";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Main.main(null);
        Double expected = 190237.95;
        String result = outContent.toString().replaceAll("[\\r\\n]", "");
        Double actual = Double.parseDouble(result);
        assertEquals(expected, actual);
    }

    @Test
    public void testMain4() {
        String data = "955\n19202\n64.9732";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Main.main(null);
        Double expected = 1309664.8;
        String result = outContent.toString().replaceAll("[\\r\\n]", "");
        Double actual = Double.parseDouble(result);
        assertEquals(expected, actual);
    }

    @Test
    public void testMain5() {
        String data = "423\n-232312\n-3322.2421";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Main.main(null);
        Double expected = 7.7039142E8;
        String result = outContent.toString().replaceAll("[\\r\\n]", "");
        Double actual = Double.parseDouble(result);
        assertEquals(expected, actual);
    }


}