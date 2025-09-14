package io.reflectoring.DigitaLibraries.Services;

import io.reflectoring.DigitaLibraries.Model.Books;
import io.reflectoring.DigitaLibraries.Repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
@Autowired
    BookRepo repo;

    public void add(Books books) {
        repo.save(books);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }

    public List<Books> getallbooks() {
       return repo.findAll();
    }

    public Books update(Books books) {
        Books book=repo.findById(books.getId()).orElse(null);
        book.setIsbn(books.getIsbn());
        book.setName(books.getName());
        book.setPrice(books.getPrice());
        book.setAuthor(books.getAuthor());
        repo.save(book);
        return book;
    }

    public List<Books> searchName(String title) {
    return repo.findByName(title);
    }
}
