package com.github.khalin.vacationservice.vacation.fake;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class FakeVacationRepository implements VacationRepository {

    private final AtomicLong id = new AtomicLong(0);
//    private final List<VacationEntity> vacations = new ArrayList<>();
    private final Map<Long, Optional<VacationEntity>> vacations = new HashMap<>();

    @Override
    public VacationEntity findById(Long id) {
        return vacations.get(id).orElseThrow(() -> new NotFoundException("Vacation not found"));
    }

    @Override
    public void save(VacationEntity vacationEntity) {

        vacations.put(id.addAndGet(1), Optional.of(vacationEntity));
    }

    @Override
    public VacationEntity update(VacationEntity vacationEntity) {

        if(vacations.get(vacationEntity.getId()).isPresent()) {
            vacations.remove(vacationEntity.getId());
        }

        vacations.put(vacationEntity.getId(), Optional.of(vacationEntity));

        return vacations.get(vacationEntity.getId()).get();
    }
}
