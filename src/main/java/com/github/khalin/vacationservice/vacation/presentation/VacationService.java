package com.github.khalin.vacationservice.vacation.presentation;

import com.github.khalin.vacationservice.vacation.domain.VacationApply;
import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;

public interface VacationService {

    void requestVacation(VacationRequest vacationRequest, String email);

    VacationApply cancelVacation(Long Id);
}
