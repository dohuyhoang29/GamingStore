package com.gamingstore.repositories;

import com.gamingstore.model.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountRepositories extends CrudRepository<Account, Integer> {
    @Query(value = "SELECT a FROM Account a WHERE a.email = (:email)  AND a.password = (:password) ")
    Optional<Account> findAccountByEmailAndUsername(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query("UPDATE Account a SET a.status = 'Lock' WHERE a.id = :id")
    void lockAccountById(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE Account a SET a.status = 'Un-Lock' WHERE a.id = :id")
    void unLockAccountById(@Param("id") Integer id);
}
