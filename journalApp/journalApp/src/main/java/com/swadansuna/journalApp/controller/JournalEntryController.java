package com.swadansuna.journalApp.controller;

import com.swadansuna.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>(); // we have no database so we take a hash map,a kind of table isme add krnge journal entry like id 1 uske crosponding journal entry and same id 2 ...


@GetMapping
public List<JournalEntry> getAll() { // localhost:8080/journal :GET

    return new ArrayList<>(journalEntries.values()); // just return the journal entries and usko ArrayList me convert kr k print kra diya
}
// note: Methods inside a Controller class should be public so that they can be assessed and invoked by the Spring Framework or Extternal HTTP Requests.

@PostMapping // post ki mapping hai it means , hume ek resource or entry create krni hogi , to kaha denge, to postman m v de skte hai body k andr
public boolean createEntry(@RequestBody JournalEntry myEntry){ // localhost:8080/journal :POST
    journalEntries.put(myEntry.getId(), myEntry);
    return true;

}

@GetMapping("id/{myId}")
public JournalEntry getJournalEntryById(@PathVariable Long myId){
    return journalEntries.get(myId);
}

@DeleteMapping("id/{myId}")
public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
    return journalEntries.remove(myId);
}

@PutMapping("/id/{id}")
public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
    return journalEntries.put(id, myEntry);
}
}


/*
Controller: it is a special types of classes or components jo ki handle krte hai humare http requests ko
 */