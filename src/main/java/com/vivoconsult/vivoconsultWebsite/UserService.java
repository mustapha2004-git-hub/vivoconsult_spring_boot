package com.vivoconsult.vivoconsultWebsite;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRep;

    public List<UserMessage> getAllMessages() {
        return userRep.findAll(Sort.by(Sort.Direction.DESC, "messageDate"));
    }

    public String createMessage(UserMessage msg) {
        userRep.save(msg);
        return "User added successfully";
    }

    public void removeMessage(int id) {
        userRep.deleteById(id);
    }

    public void markMessagesAsRead(int id) {
        UserMessage message = userRep.findById(id).get();
        if(!message.isRead()){
            message.setRead(true);
        }
        userRep.save(message);
    }

    public int UnreadMessagesCounter() {
        int unreadmessages = 0;
        List<UserMessage> messages = userRep.findAll();

        for (UserMessage message : messages) {
            if (!message.isRead()) {
                unreadmessages++;
            }
        }
        return unreadmessages;
    }

    public long MessagesCounter() {
        return userRep.count();
    }

    public void MakeMessageStared(int id) {
        UserMessage message = userRep.findById(id).get();

        if (message.isStared()) {
            message.setStared(false);
        } else {
            message.setStared(true);
        }
        userRep.save(message);

    }

}
