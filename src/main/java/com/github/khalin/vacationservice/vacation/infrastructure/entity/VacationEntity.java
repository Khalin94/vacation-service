package com.github.khalin.vacationservice.vacation.infrastructure.entity;

import com.github.khalin.vacationservice.vacation.domain.Vacation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class VacationEntity {

    @Id
    private Long id;
    private String email;
    private Long vacationRemainingDays;

    @Builder
    public VacationEntity(Long id, String email, Long vacationRemainingDays) {
        this.id = id;
        this.email = email;
        this.vacationRemainingDays = vacationRemainingDays;
    }

    public Vacation toModel() {
        return Vacation.builder()
                .id(id)
                .email(email)
                .vacationRemainingDays(vacationRemainingDays)
                .build();
    }

    public static VacationEntity from(Vacation vacation) {
        return VacationEntity.builder()
                .id(vacation.getId())
                .email(vacation.getEmail())
                .vacationRemainingDays(vacation.getVacationRemainingDays())
                .build();
    }
}
