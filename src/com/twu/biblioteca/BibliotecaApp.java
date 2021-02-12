package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) {
        try {
            welcomeMessage();
            Thread.sleep(3000);
            clear();
            listBooks();
        }
        catch (InterruptedException | IOException exception) {
            exception.printStackTrace();
        }

    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void listBooks() throws InterruptedException {
        String listOfBooks;
        String listOfBooksHeader = "Title........................................................................|Author........|Year|";
        var book1 = "1 - The Boy in the Striped Pajamas...........................................|John Boyne....|2006|";
        var book2 = "2 - Lord of the Rings........................................................|J.R. Tolkien..|1954|";
        var book3 = "3 - The Chronicles of Narnia - The Lion, the Witch and the Wardrobe..........|C.S. Lewis....|1950|";
        listOfBooks = String.join("\n", listOfBooksHeader, book1, book2, book3);
        System.out.print(listOfBooks);
    }

    private static void clear() throws IOException, InterruptedException {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }
}
