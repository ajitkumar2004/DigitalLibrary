package io.reflectoring.DigitaLibraries.Repositories;

import io.reflectoring.DigitaLibraries.Model.BookIssueEntity;
import io.reflectoring.DigitaLibraries.Model.Books;
import io.reflectoring.DigitaLibraries.Model.user;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookIssueRepo extends JpaRepository<BookIssueEntity,Long> {
    List<BookIssueEntity> findByUserEntity(user u1);

      @Query("SELECT b.bookEntity FROM BookIssueEntity b " +
                "GROUP BY b.bookEntity " +
                "ORDER BY COUNT(b.bookEntity) DESC")
        List<Books> findTopIssuedBooks(org.springframework.data.domain.Pageable pageable);
    }


