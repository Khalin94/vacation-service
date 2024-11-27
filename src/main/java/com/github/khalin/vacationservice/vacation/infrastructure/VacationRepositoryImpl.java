package com.github.khalin.vacationservice.vacation.infrastructure;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class VacationRepositoryImpl implements VacationRepository {

    private final VacationJpaRepository vacationJpaRepository;

    @Override
    public VacationEntity findById(Long id) {
        return vacationJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("can not found vacation id : " + id));
    }

    @Override
    public void save(VacationEntity vacationEntity) {
        vacationJpaRepository.save(vacationEntity);

    }

    @Override
    public VacationEntity findByEmail(String email) {
        return vacationJpaRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("can not found vacation email : " + email));
    }

}
