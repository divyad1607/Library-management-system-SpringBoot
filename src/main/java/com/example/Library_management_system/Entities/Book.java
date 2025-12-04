package com.example.Library_management_system.Entities;

import com.example.Library_management_system.Enums.Genre;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(unique = true)
    private String title;

    private Integer noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer price;

    @JoinColumn
    @ManyToOne
    private Author author;


}
