package org.example.tpo_04_02.repo;

import jakarta.transaction.Transactional;
import org.example.tpo_04_02.entity.Role;
import org.example.tpo_04_02.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRoleRepository extends CrudRepository<Role, Long> {
    @Query("SELECT r FROM Role r")
    List<Role> listAllRoles();

    @Query("SELECT r.name FROM Role r")
    List<String> listAllRolesNames();

    @Query("SELECT r.name FROM Role r WHERE r.id = :id")
    String findRoleNameById(Long id);

    @Query("SELECT r.id FROM Role r where  r.name = :name")
    Long findRoleIdByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Role r WHERE r.name = :name")
    void deleteRoleByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Role r WHERE r.id = :id")
    void deleteRoleById(Long id);
}
