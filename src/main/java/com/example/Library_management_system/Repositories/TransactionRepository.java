package com.example.Library_management_system.Repositories;

import com.example.Library_management_system.Entities.Transaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
