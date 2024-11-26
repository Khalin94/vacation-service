package com.github.khalin.vacationservice.vacation.web;

import com.github.khalin.vacationservice.vacation.web.request.VacationRequest;

public interface VacationService {

    void requestVacation(VacationRequest vacationRequest, String email);

    void cancelVacation(String email, Long vacationId);
}
