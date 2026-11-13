package com.vivoconsult.vivoconsultWebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("aboutcontent")
public class AboutController {

    @Autowired
    AboutService aboutS;

    @Autowired
    UserService userS;

    @GetMapping
    public String getContent(Model model) {
        model.addAttribute("aboutcontent", aboutS.getAboutContent(1));
        model.addAttribute("unreadmessages",userS.UnreadMessagesCounter());
        return "adminPages/aboutC";
    }

    @GetMapping("/viewabout")
    public String getAboutContent(Model model) {
        model.addAttribute("aboutcontent1", aboutS.getAboutContent(1));
        return "adminPages/modifyAbout";
    }

    @PostMapping("/updateabout")
    public String putAboutContent(AboutContent aboutContent, @RequestPart("imagefile") MultipartFile imageFile) throws Exception {
        if (!imageFile.isEmpty())
            aboutContent.setAboutPagePhoto(imageFile.getBytes());
        else
            aboutContent.setAboutPagePhoto(aboutS.getAboutContent(aboutContent.getId()).getAboutPagePhoto());
        String str = aboutS.UpdateAboutContent(aboutContent);
        return "redirect:/aboutcontent";
    }



}
