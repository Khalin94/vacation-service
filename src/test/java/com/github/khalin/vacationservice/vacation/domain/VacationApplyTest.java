package com.github.khalin.vacationservice.vacation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VacationApplyTest {


    @DisplayName("반차 사용 시 휴가 시작날짜와 휴가 끝 날짜가 다를경우 예외가 발생한다.")
    @Test
    void isHalfDayOffExceptionTest() {

        VacationApply vacationApply = VacationApply.builder()
                                                   .startDate(LocalDate.of(2024, 11, 26))
                                                   .endDate(LocalDate.of(2024, 11, 27))
                                                   .isHalfDayOff(true)
                                                   .reason("Half day off")
                                                   .build();

        assertThrows(IllegalArgumentException.class, vacationApply::isHalfDayOff);
    }

    @DisplayName("휴가 취소 시 vacation의 isCanceled가 true로 변경된다.")
    @Test
    public void cancelVacationTest() {
        //given
        VacationApply vacationApply = VacationApply.builder()
                                                   .id(1L)
                                                   .isCanceled(false)
                                                   .email("test@gmail.com")
                                                   .isHalfDayOff(false)
                                                   .reason("test")
                                                   .startDate(LocalDate.of(2024, 11, 26))
                                                   .endDate(LocalDate.of(2024, 11, 27))
                                                   .build();

        //when
        vacationApply.cancelVacation();

        //then
        assertThat(vacationApply.getIsCanceled()).isTrue();
    }

}