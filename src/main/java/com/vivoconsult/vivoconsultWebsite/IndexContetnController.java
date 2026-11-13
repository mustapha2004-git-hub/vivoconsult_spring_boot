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
@RequestMapping("/indexContent")
public class IndexContetnController {
    
    @Autowired
    IndexService indexS;

    @Autowired
    UserService userS;

    @GetMapping
    public String getContent(Model model) {
        model.addAttribute("indexcontent", indexS.getIndexContent(1));
        model.addAttribute("unreadmessages",userS.UnreadMessagesCounter());
        return "adminPages/indexC";
    }

    @GetMapping("/viewindex")
    public String getIndexContent(Model model) {
        model.addAttribute("indexcontent1", indexS.getIndexContent(1));
        return "adminPages/modifyIndex";
    }



    @PostMapping("/updateindex")
    public String putIndexContent(IndexContent indexContent, @RequestPart("imagefile") MultipartFile imageFile) throws Exception {
        if (!imageFile.isEmpty())
            indexContent.setAboutPhoto(imageFile.getBytes());
        else
            indexContent.setAboutPhoto(indexS.getIndexContent(indexContent.getId()).getAboutPhoto());
        String str = indexS.updateIndexContent(indexContent);
        return "redirect:/indexContent";
    }

}




