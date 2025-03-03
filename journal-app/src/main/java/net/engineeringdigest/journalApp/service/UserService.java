package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.UserEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import net.engineeringdigest.journalApp.repository.UserEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    private UserEntryRepo userEntryRepo;

    public void saveEntry(UserEntry userEntry){
        userEntryRepo.save(userEntry);
    }

    public List<UserEntry> getAll(){
        return userEntryRepo.findAll();
    }

    public Optional<UserEntry> findById(ObjectId id){
        return userEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userEntryRepo.deleteById(id);
    }

    public UserEntry findByUsername(@RequestBody String username){
        return userEntryRepo.findByUserName(username);
    }


}
