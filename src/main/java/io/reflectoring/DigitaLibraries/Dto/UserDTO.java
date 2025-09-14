package io.reflectoring.DigitaLibraries.Dto;

import io.reflectoring.DigitaLibraries.Enums.Subscription;
import io.reflectoring.DigitaLibraries.Model.user;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String dateofbirth;
    private String subscriptionType;
    public user toAdd() {
        return user.builder()
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .date(this.dateofbirth)
                .subscriptionType( Subscription.valueOf(subscriptionType.toUpperCase()))
                .build();
    }
}
