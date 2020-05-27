package com.listy.shopforeu4.repository;

import com.listy.shopforeu4.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public interface DatabaseUserRepository extends UserRepository, JpaRepository<User,String> {

}
