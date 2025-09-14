package io.reflectoring.DigitaLibraries.Dto;

import io.reflectoring.DigitaLibraries.Enums.Subscription;
import io.reflectoring.DigitaLibraries.Model.BookIssueEntity;
import io.reflectoring.DigitaLibraries.Model.Books;
import io.reflectoring.DigitaLibraries.Model.user;
import io.reflectoring.DigitaLibraries.Repositories.BookRepo;
import io.reflectoring.DigitaLibraries.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static io.reflectoring.DigitaLibraries.Enums.Subscription.*;

@Component
public class BookIssueDTOMapper {
    @Autowired
    private BookRepo bookRepo;
   @Autowired
    private UserRepo userRepo;
public BookIssueEntity toEntity(BookIssueDTO bookIssueDTO)
{
    Long id = bookIssueDTO.getBookId();
    Long id1= bookIssueDTO.getUserId();
    user u1=userRepo.findById(id1).orElse(null);
    Books books=bookRepo.findById(id).orElse(null);
    Subscription subscription = u1.getSubscriptionType();
    LocalDate expireDate;
    if(subscription.equals(FREE)) {
        expireDate = bookIssueDTO.getLocalDate().plus(14, ChronoUnit.DAYS);
    }
    else if(subscription.equals(BASIC))
    {
        expireDate = bookIssueDTO.getLocalDate().plus(20, ChronoUnit.DAYS);
    }
    else if(subscription.equals(PREMIUM))
    {
        expireDate = bookIssueDTO.getLocalDate().plus(28, ChronoUnit.DAYS);
    }
    else if(subscription.equals(GOLD))
    {
         expireDate = bookIssueDTO.getLocalDate().plus(38, ChronoUnit.DAYS);
    }
    else
    {
         expireDate = bookIssueDTO.getLocalDate().plus(68, ChronoUnit.DAYS);
    }
    return BookIssueEntity.builder().userEntity(u1).bookEntity(books).issueDate(bookIssueDTO.getLocalDate()).expireDate(expireDate).build();
}

}
