package com.github.khalin.vacationservice.vacation.fake;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationApplyRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationApplyEntity;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class FakeVacationApplyRepository implements VacationApplyRepository {

    private final AtomicLong id = new AtomicLong(0);
//    private final List<VacationEntity> vacations = new ArrayList<>();
    private final Map<Long, Optional<VacationApplyEntity>> vacationApples = new HashMap<>();

    @Override
    public VacationApplyEntity findById(Long id) {
        return vacationApples.get(id).orElseThrow(() -> new NotFoundException("Vacation not found"));
    }

    @Override
    public void save(VacationApplyEntity vacationApplyEntity) {

        vacationApples.put(id.addAndGet(1), Optional.of(vacationApplyEntity));
    }

    @Override
    public VacationApplyEntity update(VacationApplyEntity vacationApplyEntity) {

        if(vacationApples.get(vacationApplyEntity.getId()).isPresent()) {
            vacationApples.remove(vacationApplyEntity.getId());
        }

        vacationApples.put(vacationApplyEntity.getId(), Optional.of(vacationApplyEntity));

        return vacationApples.get(vacationApplyEntity.getId()).get();
    }
}
