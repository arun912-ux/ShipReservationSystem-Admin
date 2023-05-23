package com.example.shipreservationsystem.repos;

import com.example.shipreservationsystem.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface AdminUserRepo extends JpaRepository<UserCredentials, Long> {


    @Modifying
    @Query(value = "UPDATE users " +
                "SET password = ?1 " +
                "WHERE username = 'admin'",
        nativeQuery = true
    )
    public void changePassword(String password);


    @Query(value = "select password from users where username='admin'", nativeQuery = true)
    public String getPassword();


}
