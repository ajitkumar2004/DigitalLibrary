package io.reflectoring.DigitaLibraries.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookIssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_entity_id")
    private user userEntity;
    @ManyToOne
    @JoinColumn(name="book_entity_id")
    private Books bookEntity;
    @Column(name="issue_date",nullable = false)
    private LocalDate issueDate =LocalDate.now();
    @Column(name="expiry_date",nullable=false)
    private LocalDate expireDate;
}
