package com.github.khalin.vacationservice.vacation.presentation;

import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;

public interface VacationService {

    void requestVacation(VacationRequest vacationRequest, String email);

    void cancelVacation(String email, Long vacationId);
}
