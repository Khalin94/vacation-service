package com.github.khalin.vacationservice.vacation.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VacationTest {

    @DisplayName("휴가 사용 시 휴가 남은 일수가 감소한다.")
    @Test
    void decrementVacationDaysTest() {
        //given
        Vacation vacation = Vacation.builder()
                                    .id(1L)
                                    .email("test@gmail.com")
                                    .vacationRemainingDays(10L)
                                    .build();

        //when
        vacation.decrementVacationDays(4L);

        //then
        assertThat(vacation.getVacationRemainingDays()).isEqualTo(6L);
    }

    @DisplayName("남은 일수가 0일 때 휴가 사용 시 예외가 발생한다.")
    @Test
    public void decrementVacationDaysExceptionTest() {
        //given
        Vacation vacation = Vacation.builder()
                                    .id(1L)
                                    .email("test@gmail.com")
                                    .vacationRemainingDays(0L)
                                    .build();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            vacation.decrementVacationDays(1L);
        });

    }


    @DisplayName("남은 일수보다 더 많은 일수를 사용하려고 할 때 예외가 발생한다.")
    @Test
    public void decrementVacationDaysExceptionTest2() {
        //given
        Vacation vacation = Vacation.builder()
                                    .id(1L)
                                    .email("test@gmail.com")
                                    .vacationRemainingDays(2L)
                                    .build();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            vacation.decrementVacationDays(3L);
        });

    }

}