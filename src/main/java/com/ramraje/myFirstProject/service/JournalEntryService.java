package com.ramraje.myFirstProject.service;

import com.ramraje.myFirstProject.entity.JournalEntry;
import com.ramraje.myFirstProject.entity.User;
import com.ramraje.myFirstProject.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;



    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        try {
            User user=userService.findByUsername(username);
            journalEntry.setDate(LocalDateTime.now());
           JournalEntry saved= journalEntryRepository.save(journalEntry);
           user.getJournalEntries().add(saved);
           userService.saveUser(user);
        } catch (Exception e) {
            log.error("Exception",e);
        }
    }
    public void saveEntry(JournalEntry journalEntry) {
        try {
            journalEntryRepository.save(journalEntry);
        } catch (Exception e) {
            log.error("Exception",e);
        }
    }
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id) {
       return journalEntryRepository.findById(id);
    }
    @Transactional
    public boolean deleteById(ObjectId id, String username) {
        boolean removed=false;
        try {
            User user=userService.findByUsername(username);
             removed= user.getJournalEntries().removeIf(x->x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            log.error("Error");
            throw new RuntimeException("An arror occurred while deleting  the entry .",e);
        }

        return removed;

    }
}
