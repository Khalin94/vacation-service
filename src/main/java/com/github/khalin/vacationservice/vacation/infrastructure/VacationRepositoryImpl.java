package com.github.khalin.vacationservice.vacation.infrastructure;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class VacationRepositoryImpl implements VacationRepository {

    private final VacationJpaRepository vacationRepository;


    @Override
    public VacationApplyEntity findById(Long id) {

        return vacationRepository.findById(id)
                                 .orElseThrow(() -> new NotFoundException("can not found vacation id : " + id));
    }

    @Override
    public void save(VacationApplyEntity vacationApplyEntity) {
        vacationRepository.save(vacationApplyEntity);

    }

    @Override
    public VacationApplyEntity update(VacationApplyEntity vacationApplyEntity) {
        return vacationRepository.save(vacationApplyEntity);
    }
}
