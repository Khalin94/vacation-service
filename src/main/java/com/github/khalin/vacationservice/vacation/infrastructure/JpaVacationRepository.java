package com.github.khalin.vacationservice.vacation.infrastructure;

import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVacationRepository extends JpaRepository<VacationEntity, Long> {
}