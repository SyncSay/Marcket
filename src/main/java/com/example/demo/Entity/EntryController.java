package com.example.demo.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class EntryController<T extends Entry>{
    @Autowired
     private final EntryRepo EntryRepo;

    protected EntryController(EntryRepo entryRepo) {
        EntryRepo = entryRepo;
    }

    @GetMapping
    public List<Entry> Get() {
        return EntryRepo.findAll();
    }

    @GetMapping("/{id}/")
    public Entry Get(@PathVariable Long id) {
        return EntryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PostMapping
    public Entry Post(@RequestBody T entry) {
        return EntryRepo.save(entry);
    }

    @DeleteMapping("/{id}/")
    public void Delete(@PathVariable Long id) {
        EntryRepo.deleteById(id);
    }

}
