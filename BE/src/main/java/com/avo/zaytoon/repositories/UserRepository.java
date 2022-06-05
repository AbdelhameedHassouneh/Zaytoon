package com.avo.zaytoon.repositories;

import com.avo.zaytoon.utils.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findById(long id);
    User findByEmail(String email);
}
