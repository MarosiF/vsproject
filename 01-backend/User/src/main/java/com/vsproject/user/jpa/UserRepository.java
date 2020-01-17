package com.vsproject.user.jpa;

import com.vsproject.user.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
