package io.reflectoring.DigitaLibraries.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookIssueDTO {
    private Long userId;
    private Long bookId;
    private LocalDate localDate=LocalDate.now();

}
