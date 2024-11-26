package com.github.khalin.vacationservice.vacation.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class VacationEntity {

    @Id
    private Long id;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isHalfDayOff;
    private String reason;

}
