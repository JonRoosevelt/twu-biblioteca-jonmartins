package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ReleaseOneTest {
    private final List<Book> booksList = new ArrayList<Book>() {{
        add(new Book("The Boy in the Striped Pajamas", "John Boyne", "2006"));
        add(new Book("Lord of the Rings", "J.R. Tolkien", "1954"));
        add(new Book("The Chronicles of Narnia - The Lion, the Witch and the Wardrobe", "C.S. Lewis", "1950"));
    }};
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
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
        var bibliotecaApp = new BibliotecaApp(booksList);
        bibliotecaApp.printWelcomeMessage();
        var welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        var consoleOutput = getOutput().trim();
        assertEquals(welcomeMessage, consoleOutput);
    }

    @Test
    public void customer_View_A_List_Of_All_Books() {
        var bibliotecaApp = new BibliotecaApp(booksList);
        var expectedOutput = String.join("\n",
                "Title........................................................................|Author........|Year|",
                "1 - The Boy in the Striped Pajamas...........................................|John Boyne....|2006|",
                "2 - Lord of the Rings........................................................|J.R. Tolkien..|1954|",
                "3 - The Chronicles of Narnia - The Lion, the Witch and the Wardrobe..........|C.S. Lewis....|1950|");

        bibliotecaApp.listAllBooks();
        var consoleOutput = getOutput().trim();

        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    public void customer_View_A_Main_Menu_Of_Options() {
        var bibliotecaApp = new BibliotecaApp(booksList);
        var expectedOutput = "[1] List of Books";

        bibliotecaApp.viewMainMenuOfOptions();

        var consoleOutput = getOutput().trim();

        assertEquals(expectedOutput, consoleOutput);
    }

    @Test
    public void menu_Calls_List_Of_Books_When_Option_1_Is_Chosen() {
        var bibliotecaApp = new BibliotecaApp(booksList);
        var menuOption = 1;
        var expectedOutput = String.join("\n",
                "Title........................................................................|Author........|Year|",
                "1 - The Boy in the Striped Pajamas...........................................|John Boyne....|2006|",
                "2 - Lord of the Rings........................................................|J.R. Tolkien..|1954|",
                "3 - The Chronicles of Narnia - The Lion, the Witch and the Wardrobe..........|C.S. Lewis....|1950|");

        bibliotecaApp.chooseMenuOption(menuOption);

        var consoleOutput = getOutput().trim();
        assertEquals(expectedOutput, consoleOutput);
    }
}
