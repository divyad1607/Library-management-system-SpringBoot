package com.example.Library_management_system.Controllers;

import com.example.Library_management_system.Services.TransactionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("issueBook")
    public String issueBook(@RequestParam("cardId")Integer cardId,
                                    @RequestParam("bookId")Integer bookId){

        try {
            String result = transactionService.issueBook(bookId,cardId);
            return result;
        }catch (Exception e) {
            return e.getMessage();
        }

    }

    @PutMapping("/returnBook")
    public String returnBook(@RequestParam("cardId")Integer cardId,
                             @RequestParam("bookId")Integer bookId){

        String result = transactionService.returnBook(bookId,cardId);
        return result;
    }
}
