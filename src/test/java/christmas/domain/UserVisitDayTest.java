package christmas.domain;

import christmas.domain.User.UserVisitDay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class UserVisitDayTest {

    @ParameterizedTest
    @DisplayName("사용자가 입력한 방문 날짜가 도메인에 잘 저장되는가")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31})
    void userVisitDayFunctionTest(int expectedVisitDay){
        UserVisitDay userVisitDay = new UserVisitDay(expectedVisitDay);
        Assertions.assertEquals(expectedVisitDay, userVisitDay.visitDay());
    }


}