package DAO;

import Models.Book;
import Utiles.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class BookDAOImpl implements BookDAO {
    @Override
    public Book findBookById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class,id);
    }

    @Override
    public void save(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(book);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(book);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(book);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Book> findBookByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String hql = "FROM Book where name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<Book> books = query.list();
        tx1.commit();
        session.close();
        return books;
    }

    @Override
    public List<Book> findBookByAuthor(String Author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String hql = "FROM Book where author = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", Author);
        List<Book> books = query.list();
        tx1.commit();
        session.close();
        return books;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = (List<Book>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Book").list();
        return books;

    }
}
