package io.reflectoring.DigitaLibraries.Model;

import io.reflectoring.DigitaLibraries.Enums.Subscription;
import jakarta.persistence.*;
import jdk.jshell.JShell;
import lombok.*;

import static io.reflectoring.DigitaLibraries.Enums.Subscription.FREE;

@Builder
@Entity
@Table(name = "users")   // avoid reserved keyword conflict
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String date;
    private Subscription subscriptionType;

}
