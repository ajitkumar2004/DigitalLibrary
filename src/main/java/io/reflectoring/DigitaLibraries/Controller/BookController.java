package io.reflectoring.DigitaLibraries.Controller;

import io.reflectoring.DigitaLibraries.Model.Books;
import io.reflectoring.DigitaLibraries.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService service;
    @PostMapping("/add")
    public void addBook(@RequestBody Books books)
    {
        service.add(books);
    }
    @PostMapping("/update")
    public Books update(@RequestBody Books books)
    {
    Books book = service.update(books);
    return book;
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        service.remove(id);
    }
    @GetMapping("/showbooks")
    public List<Books> allbooks()
    {
        return service.getallbooks();
    }
     @GetMapping("/name")
     public List<Books> searchByAuthor(@RequestParam("name") String name)
     {
    return service.searchName(name);
}



}
