package com.github.khalin.vacationservice.vacation.presentation;

import com.github.khalin.vacationservice.vacation.domain.Vacation;
import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;

public interface VacationService {

    void requestVacation(VacationRequest vacationRequest, String email);

    Vacation cancelVacation(Long Id);
}
