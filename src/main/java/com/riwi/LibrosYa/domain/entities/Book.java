package com.riwi.LibrosYa.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 11, nullable = false)
    private int publicationYear;

    @Column(length = 50, nullable = false)
    private String gerent;

    @Column(length = 20, nullable = false)
    private String isbn;

    // Loan
    @OneToMany(

        fetch = FetchType.LAZY,
        mappedBy = "bookId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loans;

    // Reservastion
    @OneToMany(

        fetch = FetchType.LAZY,
        mappedBy = "bookId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Reservation> reservations;
}
