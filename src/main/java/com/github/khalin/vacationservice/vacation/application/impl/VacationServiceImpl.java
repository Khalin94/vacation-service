package com.github.khalin.vacationservice.vacation.application.impl;

import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.domain.VacationApply;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;
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

        vacationRepository.save(VacationApplyEntity.from(vacationApply));

    }

    @Override
    public VacationApply cancelVacation(Long id) {

        VacationApplyEntity vacationApplyEntity = vacationRepository.findById(id);
        VacationApply vacationApply = vacationApplyEntity.toModel()
                                                         .cancelVacation();
        return vacationRepository.update(VacationApplyEntity.from(vacationApply)).toModel();

    }

}
