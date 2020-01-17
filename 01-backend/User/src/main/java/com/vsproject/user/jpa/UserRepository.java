package com.vsproject.user.jpa;

import com.vsproject.user.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends CrudRepository<User, Long> {
}
