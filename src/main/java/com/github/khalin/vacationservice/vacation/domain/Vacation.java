package com.github.khalin.vacationservice.vacation.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Vacation {

    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isHalfDayOff;
    private String reason;

    public void isHalfDayOff() {
        if(isHalfDayOff) {
            if(!this.startDate.isEqual(this.endDate)){
                throw new IllegalArgumentException("Half day off can be only for one day");
            }
        }

    }
}
