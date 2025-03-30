package org.example.tpo_04_02.repo;

import org.example.tpo_04_02.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
}
