package org.example.tpo_04_02.repo;

import jakarta.transaction.Transactional;
import org.example.tpo_04_02.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u")
    List<User> listALLUsers();

    @Query("SELECT u.email FROM User u WHERE u.email LIKE :first_letter%")
    List<String> listAllEmailsStartsWithGivenParameter(char first_letter);

    @Query("SELECT u FROM User u ORDER BY u.email ASC")
    List<User> listAllUsersWithTheirEmailsLexicographically();

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.email = :email")
    void deleteUserByItsEmail(String email);
}
