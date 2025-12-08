package com.example.Library_management_system.Repositories;

import com.example.Library_management_system.Entities.Book;
import com.example.Library_management_system.Entities.LibraryCard;
import com.example.Library_management_system.Entities.Transaction;
import com.example.Library_management_system.Enums.TransactionStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTransactionByBookAndCardAndTransactionStatus(Book book,LibraryCard card,TransactionStatus transactionStatus);
}
