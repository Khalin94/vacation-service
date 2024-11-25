package com.github.khalin.vacationservice.vacation.web.request;

import com.github.khalin.vacationservice.vacation.domain.Vacation;
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

    public Vacation toModel(String email) {
        return Vacation.builder()
                .email(email)
                .startDate(startDate)
                .endDate(endDate)
                .isHalfDayOff(isHalfDayOff)
                .reason(reason)
                .build();
    }

}
