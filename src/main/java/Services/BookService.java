package Services;

import DAO.BookDAOImpl;
import Models.Book;

import java.util.List;

public class BookService {

    private BookDAOImpl bookDAO = new BookDAOImpl();

    public BookService(){}

    public Book findBookById(int id){
        return  bookDAO.findBookById(id);
    }

    public void saveBook(Book book){
        bookDAO.save(book);
    }

    public void deleteBook(Book book){
        bookDAO.delete(book);
    }

    public void updateBook(Book book){
        bookDAO.update(book);
    }

    public List<Book> findBookByName(String name){
        return bookDAO.findBookByName(name);
    }

    public List<Book> findBookByAuthor(String author){
        return bookDAO.findBookByAuthor(author);
    }

    public List<Book> findAll(){
        return bookDAO.findAll();
    }
}
