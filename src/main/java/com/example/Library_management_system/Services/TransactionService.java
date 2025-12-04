package com.example.Library_management_system.Services;

import com.example.Library_management_system.Entities.Book;
import com.example.Library_management_system.Entities.LibraryCard;
import com.example.Library_management_system.Entities.Transaction;
import com.example.Library_management_system.Enums.TransactionStatus;
import com.example.Library_management_system.Repositories.BookRepository;
import com.example.Library_management_system.Repositories.CardRepository;
import com.example.Library_management_system.Repositories.TransactionRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.MidiFileFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class TransactionService  {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public static Integer MAX_NO_OF_ISSUED_BOOKS = 3;

    public String issueBook(Integer bookId, Integer cardId) throws Exception{

        //Find book and card from repositories

        //Create the transaction Object
        //set the relevant attributes of transactionObject

        //Change the attributes of Card and book entity

        //1.Book and Librarycard should be valid:
       // Book book = bookRepository.findById(bookId).get();
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
             throw new Exception("BookId entered is incorrect");
        }
        Book book = bookOptional.get();

        //2.LibraryCard should be valid
        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw new Exception("CradId entered is incorrect");
        }
        LibraryCard card = optionalLibraryCard.get();


        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionStatus(TransactionStatus.PENDING);


        //3.Book should not be already issued
        if(book.getIsIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            return "Book is already issued to cardId"+card.getCardNo();
        }

        //4.Limit of card
        if (card.getNoOfBooksIssued()>MAX_NO_OF_ISSUED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            return "Max limit of this card has exceeded";
        }

        //5.Check for if the card has expired its validity
       LocalDate currentDate = LocalDate.now();
        if(currentDate.isAfter(card.getValidity())){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            return "The card has been expired";
        }


        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        book.setIsIssued(true);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        //Rule is whatever is modified: should be saved?
        cardRepository.save(card);
        bookRepository.save(book);
        transactionRepository.save(transaction);

        return "The transaction has been completed with transactionId" +transaction.getTransactionId();
    }
}
