package com.lincy.retroboard;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Adam Linczmayer
 */

@RepositoryRestResource(exported = false)
public interface UserRepository extends Repository<Users, Long> {

    Users save(Users users);

    Users findByName(String name);

}

