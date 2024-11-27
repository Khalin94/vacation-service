package com.github.khalin.vacationservice.vacation.application;

import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;

public interface VacationApplyRepository {

    VacationApplyEntity findById(Long id);

    void save(VacationApplyEntity vacationApplyEntity);

    VacationApplyEntity update(VacationApplyEntity vacationApplyEntity);
}
