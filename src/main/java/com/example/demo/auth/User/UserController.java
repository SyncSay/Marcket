package com.example.demo.auth.User;

import com.example.demo.Entity.EntryController;
import com.example.demo.Entity.EntryRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public abstract class UserController<T extends User> extends EntryController<T> {
    @Autowired
    private final UserRepo UserRepo;

    protected UserController(EntryRepo entryRepo, UserRepo userRepo) {
        super(entryRepo);
        UserRepo = userRepo;
    }
}
