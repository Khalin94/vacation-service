package com.github.khalin.vacationservice.vacation.presentation.request;

import com.github.khalin.vacationservice.vacation.domain.VacationApply;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class VacationRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isHalfDayOff;
    private String reason;

    public VacationApply toModel(String email) {
        return VacationApply.builder()
                            .email(email)
                            .startDate(startDate)
                            .endDate(endDate)
                            .isHalfDayOff(isHalfDayOff)
                            .reason(reason)
                            .build();
    }

}
