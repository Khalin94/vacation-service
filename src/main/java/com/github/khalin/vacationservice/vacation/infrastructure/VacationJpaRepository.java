package com.github.khalin.vacationservice.vacation.infrastructure;

import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationJpaRepository extends JpaRepository<VacationApplyEntity, Long> {
}
