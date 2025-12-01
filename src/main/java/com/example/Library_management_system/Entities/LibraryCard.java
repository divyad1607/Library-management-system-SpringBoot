package com.example.Library_management_system.Entities;


import com.example.Library_management_system.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "card_info")
@Getter
@Setter
@AllArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    private CardStatus cardStatus;

    private int noOfBooksIssued;

    private Date validity;

}
