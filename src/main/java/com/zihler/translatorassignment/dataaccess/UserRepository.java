package com.zihler.translatorassignment.dataaccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Long, User> {
    User findByUsername(String user);
}
