package com.example.Library_management_system.Entities;

import com.example.Library_management_system.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Date issueDate;

    private Date returnDate;

    private Integer fineAmount;

    @JoinColumn
    @ManyToOne
    private LibraryCard card;

    @JoinColumn
    @ManyToOne
    private Book book;


}
