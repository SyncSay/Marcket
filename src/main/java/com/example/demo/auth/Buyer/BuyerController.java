package com.example.demo.auth.Buyer;

import com.example.demo.Entity.EntryRepo;
import com.example.demo.auth.User.UserController;
import com.example.demo.auth.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/buyers")
@Controller
public class BuyerController extends UserController<Buyer> {
    @Autowired
    private final BuyerRepo BuyerRepo;

    protected BuyerController(EntryRepo entryRepo, UserRepo userRepo, BuyerRepo buyerRepo) {
        super(entryRepo, userRepo);
        BuyerRepo = buyerRepo;
    }
}
