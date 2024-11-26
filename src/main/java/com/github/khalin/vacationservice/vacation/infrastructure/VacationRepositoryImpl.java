package com.github.khalin.vacationservice.vacation.infrastructure;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class VacationRepositoryImpl implements VacationRepository {

    private final VacationJpaRepository vacationRepository;


    @Override
    public VacationEntity findById(Long id) {

        return vacationRepository.findById(id)
                                 .orElseThrow(() -> new NotFoundException("can not found vacation id : " + id));
    }

    @Override
    public void save(VacationEntity vacationEntity) {
        vacationRepository.save(vacationEntity);

    }

    @Override
    public VacationEntity update(VacationEntity vacationEntity) {
        return vacationRepository.save(vacationEntity);
    }
}
