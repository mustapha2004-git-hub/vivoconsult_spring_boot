package com.vivoconsult.vivoconsultWebsite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    IndexRepository IndexRep;

    public List<IndexContent> getAllInexContent() {
        return IndexRep.findAll();
    }


    public IndexContent getIndexContent(int theid) {
        return IndexRep.findById(theid).get();
    }


    
    

    public String updateIndexContent(IndexContent indexContent) {
        Optional<IndexContent> IndexContentOptional = IndexRep.findById(indexContent.getId());
        if (IndexContentOptional.isPresent()) {
        IndexRep.save(indexContent);
        return "IndexContent updated successfully";
        } 
        return "Indexcontent not found";
        }
}
