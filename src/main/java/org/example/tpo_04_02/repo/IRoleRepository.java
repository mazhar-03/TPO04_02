package org.example.tpo_04_02.repo;

import org.example.tpo_04_02.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Long> {
}
