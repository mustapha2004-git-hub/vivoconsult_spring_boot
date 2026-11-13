package com.vivoconsult.vivoconsultWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
    
    @Autowired
    UserService userS;

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("unreadmessages",userS.UnreadMessagesCounter());
        return "adminPages/admin";
    }
}
