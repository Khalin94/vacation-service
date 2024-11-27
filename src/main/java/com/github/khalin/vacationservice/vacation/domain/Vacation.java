package com.github.khalin.vacationservice.vacation.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Vacation {

    private Long id;
    private String email;
    private Long vacationRemainingDays;

    public Vacation decrementVacationDays(Long days) {
        if(vacationRemainingDays < days || vacationRemainingDays <= 0) {
            throw new IllegalArgumentException("Not enough vacation days");
        }
        this.vacationRemainingDays -= days;
        return this;
    }
}
