package com.github.khalin.vacationservice.vacation.repository;

import com.github.khalin.vacationservice.vacation.repository.entity.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVacationRepository extends JpaRepository<VacationEntity, Long> {
}
