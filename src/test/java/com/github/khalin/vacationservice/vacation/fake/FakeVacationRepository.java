package com.github.khalin.vacationservice.vacation.fake;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class FakeVacationRepository implements VacationRepository {

    private final AtomicLong id = new AtomicLong(0);
//    private final List<VacationEntity> vacations = new ArrayList<>();
    private final Map<Long, Optional<VacationApplyEntity>> vacations = new HashMap<>();

    @Override
    public VacationApplyEntity findById(Long id) {
        return vacations.get(id).orElseThrow(() -> new NotFoundException("Vacation not found"));
    }

    @Override
    public void save(VacationApplyEntity vacationApplyEntity) {

        vacations.put(id.addAndGet(1), Optional.of(vacationApplyEntity));
    }

    @Override
    public VacationApplyEntity update(VacationApplyEntity vacationApplyEntity) {

        if(vacations.get(vacationApplyEntity.getId()).isPresent()) {
            vacations.remove(vacationApplyEntity.getId());
        }

        vacations.put(vacationApplyEntity.getId(), Optional.of(vacationApplyEntity));

        return vacations.get(vacationApplyEntity.getId()).get();
    }
}
