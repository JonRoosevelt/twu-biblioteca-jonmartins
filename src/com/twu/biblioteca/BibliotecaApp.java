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
        var listOfBooks = "1 - The Boy in the Striped Pajamas\n2 - Lord of the Rings\n3 - The Chronicles of Narnia";
        System.out.print(listOfBooks);
    }

    private static void clear() throws IOException, InterruptedException {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }
}
