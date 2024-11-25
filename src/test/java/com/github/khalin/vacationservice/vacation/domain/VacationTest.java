package com.github.khalin.vacationservice.vacation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VacationTest {



    @DisplayName("반차 사용 시 휴가 시작날짜와 휴가 끝 날짜가 다를경우 예외가 발생한다.")
    @Test
    void isHalfDayOffExceptionTest() {

        Vacation vacation = Vacation.builder()
                                    .startDate(LocalDate.of(2024, 11, 26))
                                    .endDate(LocalDate.of(2024, 11, 27))
                                    .isHalfDayOff(true)
                                    .reason("Half day off")
                                    .build();

        assertThrows(IllegalArgumentException.class, vacation::isHalfDayOff);
    }

}