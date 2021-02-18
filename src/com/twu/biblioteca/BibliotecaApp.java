package com.twu.biblioteca;

import java.text.MessageFormat;
import java.util.List;
import com.twu.biblioteca.models.*;

public class BibliotecaApp {
    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listAllBooks(List<Book> books) {
        var headerOfListOfBooks = "Title........................................................................|Author........|Year|\n";
        StringBuilder listOfBooks = new StringBuilder();
        int titlePlaceHolderSize = 77;
        int authorPlaceHolderSize = 14;
        int bookNumber = 1;
        for (var book: books) {
            listOfBooks.append(
                    String.join("",
                            formatLine(
                                    Integer.toString(bookNumber),
                                book.getTitle(),
                                book.getAuthor(),
                                titlePlaceHolderSize,
                                authorPlaceHolderSize,
                                book.getYear()
                            )
                    )
            );
            bookNumber += 1;
        }
        listOfBooks = new StringBuilder(headerOfListOfBooks + listOfBooks);
        System.out.println(listOfBooks);
    }

    private String formatLine(
            String bookNumber,
            String title,
            String author,
            int titlePlaceHolderSize,
            int authorPlaceHolderSize,
            String year) {
        return MessageFormat.format(
                "{0} - {1}{2}|{3}{4}|{5}|\n",
                bookNumber,
                title, ".".repeat(titlePlaceHolderSize - title.length() - bookNumber.length() - 3),
                author, ".".repeat(authorPlaceHolderSize - author.length()),
                year);
    }
}
