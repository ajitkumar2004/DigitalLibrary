package io.reflectoring.DigitaLibraries.Services;

import io.reflectoring.DigitaLibraries.Model.BookIssueEntity;
import io.reflectoring.DigitaLibraries.Model.Books;
import io.reflectoring.DigitaLibraries.Model.user;
import io.reflectoring.DigitaLibraries.Repositories.BookIssueRepo;
import io.reflectoring.DigitaLibraries.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookIssueService {
    @Autowired
    BookIssueRepo repo;
    public void add(BookIssueEntity entity) {
    repo.save(entity);
    }

    public List<BookIssueEntity> displayAll() {
        return repo.findAll();
    }
    @Autowired
    private UserRepo userRepo;

    public List<BookIssueEntity> getBooksByUser(Long userId) {
        user u1 = userRepo.findById(userId).orElse(null);
        if (u1 == null) {
            throw new RuntimeException("User not found");
        }
        return repo.findByUserEntity(u1);
    }

    public List<Books> getTop5IssuedBooks(int id) {
        return repo.findTopIssuedBooks(PageRequest.of(0, id ));
    }

}
