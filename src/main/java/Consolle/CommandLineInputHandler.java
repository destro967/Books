package Consolle;

import Models.Book;
import Services.BookService;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class CommandLineInputHandler {

    private BookService bookService = new BookService();
    private static final Scanner in = new Scanner(System.in);

    public static void printOptions(){
        System.out.println("\n--- Books Library Aplication ---");
        System.out.println("Please make a choise:");
        System.out.println("1) All Book");
        System.out.println("2) Find book by name");
        System.out.println("3) Find book by author");
        System.out.println("4) Add a new book");
        System.out.println("5) Change an existing book");
        System.out.println("6) Delete an existing book");
        System.out.println("7) Exit");
    }

    public String readInput(){
        System.out.print("> ");
        return in.nextLine();
    }

    public void processInput(CommandLineInput input){
        if(input == null){
            handleUnknowInput();
        }else{
            switch (input){
                case FIND_ALL:
                    printAllBooks();
                    break;
                case FIND_BY_NAME:
                    printBookByName();
                    break;
                case FIND_BY_AUTHOR:
                    printBookByAuthor();
                    break;
                case ADD:
                    addBook();
                    break;
                case CHANGE:
                    updateBook();
                    break;
                case DELETE:
                    deleteBook();
                    break;
                case EXIT:
                    break;
                default:
                    handleUnknowInput();
            }
        }
    }

    private String askForBookName(){
        System.out.println("please enter the Book name: \n> ");
        String input = readInput();
        return input;
    }

    private Book askForNewBook(){
        System.out.println("Please enter the name of the book:");
        String name = readInput();
        System.out.println("Please enter the author of the book:");
        Book book = new Book(name,readInput());
        return book;
    }

    private void printAllBooks(){
        Collection<Book> books = bookService.findAll();

        if(books.isEmpty()){
            System.out.println("No books in the list.");
        }else{
            for (Book book : books){
                System.out.println(book);
            }
        }
    }

    private void printBookByName(){
        List<Book> books = findBookByName();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private List<Book> findBookByName(){
        String name = askForBookName();
        return bookService.findBookByName(name);
    }

    private List<Book> findBookByAuthor(){
        String author = askForBookByAuthor();
        return bookService.findBookByAuthor(author);
    }

    private void printBookByAuthor(){
        List<Book> books = findBookByAuthor();
        for (Book book: books ) {
            System.out.println(book);
        }
    }

    private String askForBookByAuthor(){
        System.out.println("Please enter the author of the book:");
        String author = in.nextLine();
        return author;
    }

    private int askForBookID(){
        System.out.println("Please enter the ID of the book:");
        String id = readInput();
        return Integer.parseInt(id);
    }

    private Book findBookByID(){
        int id = askForBookID();
        Book book = bookService.findBookById(id);

        if(book == null){
            System.err.println("To do item with ID " + id + " could not be found.");
        }
        return book;
    }



    private void addBook(){
        Book book = askForNewBook();
        bookService.saveBook(book);
        System.out.println("Successfully inserted book.");

    }

    private void updateBook(){
        Book book = findBookByID();

        if(book != null){
            System.out.println(book);

            System.out.println("Please enter the name of the book:");
            book.setName(readInput());
            System.out.println("Please enter the author of the book:");
            book.setAuthor(readInput());
            bookService.updateBook(book);
            System.out.println("Successfully updated book");
        }
    }

    private void deleteBook(){
        Book book = findBookByID();

        if(book != null){
            bookService.deleteBook(book);
            System.out.println("Successfully deleted book");
        }
    }

    private void handleUnknowInput() {
        System.out.println("Please select a valid option.");
    }


}
