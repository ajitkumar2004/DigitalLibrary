package io.reflectoring.DigitaLibraries.Services;
import io.reflectoring.DigitaLibraries.Model.user;
import io.reflectoring.DigitaLibraries.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class Serviced {
    @Autowired
    private UserRepo repo;

    public void add(user user) {
         String email= user.getEmail();
         if(repo.existsByEmail(email))
         {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The Email is already exist");
         }
         else {
             repo.save(user);
         }
    }
}
