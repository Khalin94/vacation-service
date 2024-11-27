package com.github.khalin.vacationservice.vacation.infrastructure;

import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacationJpaRepository extends JpaRepository<VacationEntity, Long> {
    Optional<VacationEntity> findByEmail(String email);
}
