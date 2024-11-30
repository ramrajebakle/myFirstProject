//package com.ramraje.myFirstProject.controller;
//
//import com.ramraje.myFirstProject.entity.JournalEntry;
//import com.ramraje.myFirstProject.service.JournalEntryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping()
//    public List<JournalEntry> getAll(){
//
//        return new ArrayList<>(journalEntries.values());
//    }
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        //journalEntryService.saveEntry(myEntry);
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//    @GetMapping("id/{myId}")
//    public JournalEntry getEntry(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalEntry(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//    }
//    @PutMapping("/id/{id}")
//    public JournalEntry updateJournalByEntry(@PathVariable Long id, @RequestBody JournalEntry myEntry){
//        return journalEntries.put(id,myEntry);
//    }
//
//
//}


//package com.ramraje.myFirstProject.controller;
//
//import com.ramraje.myFirstProject.entity.JournalEntry;
//import com.ramraje.myFirstProject.service.JournalEntryService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV2 {
//
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//
//    @GetMapping()
//    public ResponseEntity<?> getAll(){
//        List<JournalEntry> all= journalEntryService.getAll();
//        if(all!=null && all.isEmpty()){
//            return new ResponseEntity<>(all,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @PostMapping
//    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
//        try {
//            journalEntryService.saveEntry(myEntry);
//            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
//
//        Optional<JournalEntry> journalEntry= journalEntryService.findById(myId);
//        if (journalEntry.isPresent()){
//            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @DeleteMapping("id/{myId}")
//    public ResponseEntity<?> deleteJournalEntry(@PathVariable ObjectId myId){
//        journalEntryService.deleteById(myId);
//        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    @PutMapping("/id/{id}")
//    public ResponseEntity<?> updateJournalByEntry(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
//        JournalEntry old = journalEntryService.findById(id).orElse(null);
//        if(old != null) {
//            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
//            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
//            return new ResponseEntity<>(old, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//}
