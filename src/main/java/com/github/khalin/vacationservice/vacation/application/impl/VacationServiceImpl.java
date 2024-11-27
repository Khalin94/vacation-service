package com.github.khalin.vacationservice.vacation.application.impl;

import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.domain.VacationApply;
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

        VacationApply vacationApply = vacationRequest.toModel(email);
        vacationApply.isHalfDayOff();

        vacationRepository.save(VacationEntity.from(vacationApply));

    }

    @Override
    public VacationApply cancelVacation(Long id) {

        VacationEntity vacationEntity = vacationRepository.findById(id);
        VacationApply vacationApply = vacationEntity.toModel()
                                                    .cancelVacation();
        return vacationRepository.update(VacationEntity.from(vacationApply)).toModel();

    }

}
