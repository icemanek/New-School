package com.motorcycleschool.school.repository;

import com.motorcycleschool.school.util.ConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {


    ConfirmationToken findByConfirmationToken(String confirmationToken);


    @Modifying
    @Query(value = "delete from ConfirmationToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
}
