package com.example.demo.auth.Sayler;

import com.example.demo.Entity.EntryRepo;
import com.example.demo.auth.User.UserController;
import com.example.demo.auth.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/saylers")
@Controller
public class SaylerController extends UserController<Sayler> {

    @Autowired
    private final SaylerRepo SaylerRepository;

    protected SaylerController(EntryRepo entryRepo, UserRepo userRepo, SaylerRepo saylerRepository) {
        super(entryRepo, userRepo);
        SaylerRepository = saylerRepository;
    }
}
