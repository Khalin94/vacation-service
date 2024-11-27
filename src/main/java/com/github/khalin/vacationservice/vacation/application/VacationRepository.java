package com.github.khalin.vacationservice.vacation.application;

import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;

public interface VacationRepository {

    VacationEntity findById(Long id);

    void save(VacationEntity vacationEntity);

    VacationEntity findByEmail(String email);

}
