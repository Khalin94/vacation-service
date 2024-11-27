package com.github.khalin.vacationservice.vacation.application.impl;

import com.github.khalin.vacationservice.vacation.application.VacationApplyRepository;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.domain.Vacation;
import com.github.khalin.vacationservice.vacation.domain.VacationApply;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import com.github.khalin.vacationservice.vacation.presentation.VacationService;
import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Builder
@RequiredArgsConstructor
@Service
public class VacationServiceImpl implements VacationService {

    private final VacationApplyRepository vacationApplyRepository;
    private final VacationRepository vacationRepository;

    @Transactional
    @Override
    public void requestVacation(VacationRequest vacationRequest, String email) {

        VacationApply vacationApply = vacationRequest.toModel(email);
        vacationApply.isHalfDayOff();
        vacationApplyRepository.save(VacationApplyEntity.from(vacationApply));

        Vacation vacation = vacationRepository.findByEmail(email).toModel();
        vacation.decrementVacationDays(vacationApply.vacationDays());
        vacationRepository.save(VacationEntity.from(vacation));

    }

    @Override
    public VacationApply cancelVacation(Long id) {

        VacationApplyEntity vacationApplyEntity = vacationApplyRepository.findById(id);
        VacationApply vacationApply = vacationApplyEntity.toModel()
                                                         .cancelVacation();
        return vacationApplyRepository.update(VacationApplyEntity.from(vacationApply)).toModel();

    }

}
