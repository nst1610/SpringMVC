package ru.semenova.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.semenova.spring.models.Book;
import ru.semenova.spring.models.Person;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT id, title, author, year_of_production FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT id, title, author, year_of_production FROM book WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public Person getReader(int id){
        return jdbcTemplate.query("SELECT full_name FROM Book JOIN Person ON Person.id=Book.person_id WHERE Book.id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void freeBook(int id){
        jdbcTemplate.update("UPDATE  book SET person_id=null WHERE id=?", id);
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO book (title, author, year_of_production) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYearOfProduction());
    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year_of_production=? WHERE id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYearOfProduction(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

    public void selectReader(int bookId, Person person){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", person.getId(), bookId);
    }
}
