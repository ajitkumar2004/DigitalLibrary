package io.reflectoring.DigitaLibraries.Controller;

import io.reflectoring.DigitaLibraries.Dto.BookIssueDTO;
import io.reflectoring.DigitaLibraries.Dto.BookIssueDTOMapper;
import io.reflectoring.DigitaLibraries.Model.BookIssueEntity;
import io.reflectoring.DigitaLibraries.Model.Books;
import io.reflectoring.DigitaLibraries.Services.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class BookIssueController {
@Autowired
BookIssueService bookIssueService;
@Autowired
    BookIssueDTOMapper mapper;
@PostMapping("/issueBooks")
    public void issueBook(@RequestBody BookIssueDTO dto)
{
    BookIssueEntity entity = mapper.toEntity(dto);
    bookIssueService.add(entity);
}
@GetMapping("/displayAll")
    public List<BookIssueEntity> issueBook()
{
       return bookIssueService.displayAll();
    }
    @GetMapping("/display/{id}")
    public List<BookIssueEntity> issuedBooks(@PathVariable Long id)
    {
        return bookIssueService.getBooksByUser(id);
    }
    @GetMapping("/top/{id}")
    public List<Books> top5(@PathVariable int id)
    {
       return bookIssueService.getTop5IssuedBooks(id);
    }
}
