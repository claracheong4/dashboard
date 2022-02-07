package com.dashboard.repository;

import com.dashboard.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Visit v WHERE v.customer.id = ?1")
    void deleteByCustomerId(Integer customerId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Visit v WHERE v.ibx.id = ?1")
    void deleteByIbxId(Integer ibxId);
}
