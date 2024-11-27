package com.github.khalin.vacationservice.vacation.application.impl;

import com.github.khalin.vacationservice.vacation.application.VacationRepository;
import com.github.khalin.vacationservice.vacation.domain.VacationApply;
import com.github.khalin.vacationservice.vacation.fake.FakeVacationRepository;
import com.github.khalin.vacationservice.vacation.infrastructure.entity.VacationEntity;
import com.github.khalin.vacationservice.vacation.presentation.VacationService;
import com.github.khalin.vacationservice.vacation.presentation.request.VacationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VacationServiceImplTest {

    @DisplayName("반차 사용 시 휴가 시작날짜와 휴가 끝 날짜가 다를경우 예외가 발생한다.")
    @Test
    public void requestVacationExceptionTest() {
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
            VacationService service = VacationServiceImpl.builder()
                                                         .vacationRepository(new FakeVacationRepository())
                                                         .build();
            service.requestVacation(request, "test@gmail.com");
        });
    }

    @DisplayName("휴가 취소 시 isCanceled 값이 true로 변경된다.")
    @Test
    public void cancelVacationTest() {
        //given
        VacationEntity entity = VacationEntity.builder()
                                              .id(1L)
                                              .email("test@gmail.com")
                                              .isCanceled(false)
                                              .isHalfDayOff(false)
                                              .startDate(LocalDate.of(2024, 11, 20))
                                              .endDate(LocalDate.of(2024, 11, 22))
                                              .reason("test")
                                              .build();

        VacationRepository repository = new FakeVacationRepository();
        repository.save(entity);

        VacationService service = new VacationServiceImpl(repository);

        //when
        VacationApply vacationApply = service.cancelVacation(entity.getId());

        //then
        assertThat(vacationApply.getIsCanceled()).isTrue();
    }
}