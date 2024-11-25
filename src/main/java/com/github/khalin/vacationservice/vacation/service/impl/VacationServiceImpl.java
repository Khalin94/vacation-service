package com.github.khalin.vacationservice.vacation.service.impl;

import com.github.khalin.vacationservice.vacation.domain.Vacation;
import com.github.khalin.vacationservice.vacation.web.VacationService;
import com.github.khalin.vacationservice.vacation.web.request.VacationRequest;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationService {

    @Override
    public void requestVacation(VacationRequest vacationRequest, String email) {

        Vacation vacation = vacationRequest.toModel(email);
        vacation.isHalfDayOff();

    }

}
