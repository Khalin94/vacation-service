package com.github.khalin.vacationservice.vacation.infrastructure.entity;

import com.github.khalin.vacationservice.vacation.domain.VacationApply;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private Boolean isCanceled;

    @Builder
    public VacationEntity(Long id, String email, LocalDate startDate, LocalDate endDate, Boolean isHalfDayOff, String reason, Boolean isCanceled) {
        this.id = id;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isHalfDayOff = isHalfDayOff;
        this.reason = reason;
        this.isCanceled = isCanceled;
    }

    public VacationApply toModel() {
        return VacationApply.builder()
                            .id(this.getId())
                            .email(this.email)
                            .startDate(this.startDate)
                            .endDate(this.endDate)
                            .reason(this.reason)
                            .isHalfDayOff(this.isHalfDayOff)
                            .isCanceled(this.isCanceled)
                            .build();
    }

    public static VacationEntity from(VacationApply vacationApply) {
        return VacationEntity.builder()
                             .id(vacationApply.getId())
                             .email(vacationApply.getEmail())
                             .startDate(vacationApply.getStartDate())
                             .endDate(vacationApply.getEndDate())
                             .reason(vacationApply.getReason())
                             .isHalfDayOff(vacationApply.getIsHalfDayOff())
                             .isCanceled(vacationApply.getIsCanceled())
                             .build();
    }

}
