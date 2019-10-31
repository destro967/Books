package DAO;

import Models.Book;

import java.util.List;


public interface BookDAO {

    Book findBookById(int id);

    void save(Book book);

    void update(Book book);

    void delete(Book book);

    List<Book> findBookByName(String name);

    List<Book> findBookByAuthor(String Author);

    List<Book> findAll();
}
