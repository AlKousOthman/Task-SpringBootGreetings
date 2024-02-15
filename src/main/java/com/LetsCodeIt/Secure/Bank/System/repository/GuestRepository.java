package com.LetsCodeIt.Secure.Bank.System.repository;

import com.LetsCodeIt.Secure.Bank.System.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
    @Query(value = "SELECT * FROM guest_entity r where r.status = 'CREATE'",nativeQuery = true)
    Optional<List<GuestEntity>> findAllCreatedSuggestions();

    @Query(value = "SELECT * FROM guest_entity r where r.status = 'REMOVE'",nativeQuery = true)
    Optional<List<GuestEntity>> findAllRemovedSuggestions();
}
