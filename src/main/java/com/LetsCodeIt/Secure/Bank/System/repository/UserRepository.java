package com.LetsCodeIt.Secure.Bank.System.repository;

import com.LetsCodeIt.Secure.Bank.System.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
