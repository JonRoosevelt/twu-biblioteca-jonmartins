package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class ReleaseOneTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void customer_View_A_Welcome_Message_Test() {
        BibliotecaApp.main(new String[0]);
        var welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        var consoleOutput = getOutput().trim();
        var consoleOutputFirstLine = consoleOutput.substring(0, consoleOutput.indexOf("\n"));
        assertEquals(welcomeMessage, consoleOutputFirstLine);
    }

    @Test
    public void customer_View_A_List_Of_All_Books() {
        BibliotecaApp.main(new String[0]);
        var consoleOutput = getOutput().trim();
        var consoleOutputAfterClearing = consoleOutput.substring(
                consoleOutput.indexOf("1")
        );
        var listOfBooks = "1 - The Boy in the Striped Pajamas\n2 - Lord of the Rings\n3 - The Chronicles of Narnia";
        assertEquals(listOfBooks, consoleOutputAfterClearing);
    }
}
