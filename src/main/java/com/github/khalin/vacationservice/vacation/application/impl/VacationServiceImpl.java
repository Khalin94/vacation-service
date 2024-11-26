package com.github.khalin.vacationservice.vacation.application.impl;

import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.domain.Vacation;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import com.github.khalin.vacationservice.vacation.presentation.VacationService;
import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Builder
@RequiredArgsConstructor
@Service
public class VacationServiceImpl implements VacationService {

    private final VacationRepository vacationRepository;

    @Override
    public void requestVacation(VacationRequest vacationRequest, String email) {

        Vacation vacation = vacationRequest.toModel(email);
        vacation.isHalfDayOff();

        vacationRepository.save(VacationEntity.from(vacation));

    }

    @Override
    public Vacation cancelVacation(Long id) {

        VacationEntity vacationEntity = vacationRepository.findById(id);
        Vacation vacation = vacationEntity.toModel()
                                          .cancelVacation();
        return vacationRepository.update(VacationEntity.from(vacation)).toModel();

    }

}
