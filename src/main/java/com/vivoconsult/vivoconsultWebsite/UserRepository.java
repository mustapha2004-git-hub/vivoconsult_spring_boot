package com.vivoconsult.vivoconsultWebsite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMessage,Integer>{

}
