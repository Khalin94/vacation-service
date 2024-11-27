package com.github.khalin.vacationservice.vacation.fake;

import com.github.khalin.vacationservice.exception.NotFoundException;
import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeVacationRepository implements VacationRepository {

    private final AtomicLong id = new AtomicLong(0);
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
    public VacationEntity findByEmail(String email) {

        return vacations.values().stream()
                .filter(vacationEntity -> vacationEntity.get().getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Vacation not found"))
                .get();

    }
}
