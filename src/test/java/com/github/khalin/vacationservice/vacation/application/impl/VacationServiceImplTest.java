package com.github.khalin.vacationservice.vacation.application.impl;

import com.github.khalin.vacationservice.vacation.presentation.VacationService;
import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacationServiceImplTest {

    VacationService service = new VacationServiceImpl();

    @DisplayName("반차 사용 시 휴가 시작날짜와 휴가 끝 날짜가 다를경우 예외가 발생한다.")
    @Test
    public void requestVacationExceptionTest() throws Exception {
        //given
        VacationRequest request = VacationRequest.builder()
                .startDate(LocalDate.of(2024, 11, 26))
                .endDate(LocalDate.of(2024, 11, 27))
                .isHalfDayOff(true)
                .reason("Half day off")
                .build();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            service.requestVacation(request, "test@gmail.com");
        });

    }


}