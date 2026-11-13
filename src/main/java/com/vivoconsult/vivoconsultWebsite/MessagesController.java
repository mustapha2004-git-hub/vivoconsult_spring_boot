package com.vivoconsult.vivoconsultWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getMessages(Model model) {
        model.addAttribute("usermessages", userService.getAllMessages());
        model.addAttribute("messagescount",userService.MessagesCounter());
        model.addAttribute("unreadmessages",userService.UnreadMessagesCounter());
        return "adminPages/messagespage";
    }

    @PostMapping("/add")
    public String addMessage(@ModelAttribute UserMessage msg, HttpServletRequest request) throws Exception {
        String str = userService.createMessage(msg);
        String referrer = request.getHeader("referer");
        return "redirect:" + referrer;
    }


    @GetMapping("/delete")
    public String MessageDelete(@RequestParam(name = "id") int id) {
        userService.removeMessage(id);
        return "redirect:/messages";
    }

    @GetMapping("/star")
    public String MessageStar(@RequestParam(name="id") int id){
        userService.MakeMessageStared(id);
        return "redirect:/messages";
    }

    @GetMapping("/read")
    public String MessageIsRead(@RequestParam(name="id") int id){
        userService.markMessagesAsRead(id);
        return "redirect:/messages";
    }
}