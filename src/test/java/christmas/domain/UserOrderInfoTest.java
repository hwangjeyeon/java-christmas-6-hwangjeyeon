package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

class UserOrderInfoTest {





    @ParameterizedTest
    @DisplayName("주문받은 메뉴명이 리스트에 잘 저장되는가")
    @MethodSource("expectedMenuListSource")
    void userOrderMenuFunctionTest(List<String> expectedMenuList){
        //given
        String orderInfo = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        //when
        UserOrderInfo userOrderInfo = new UserOrderInfo(orderInfo);

        //then
        Assertions.assertEquals(expectedMenuList, userOrderInfo.getMenu());
    }

    @ParameterizedTest
    @DisplayName("주문받은 메뉴 개수가 리스트에 잘 저장되는가")
    @MethodSource("expectedMenuCountsSource")
    void userOrderCountFunctionTest(List<Integer> expectedCountsList){
        //given
        String orderInfo = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        //when
        UserOrderInfo userOrderInfo = new UserOrderInfo(orderInfo);

        //then
        Assertions.assertEquals(expectedCountsList, userOrderInfo.getCounts());
    }



    private static Stream<List<String>> expectedMenuListSource() {
        return Stream.of(
                List.of("티본스테이크", "바비큐립", "초코케이크", "제로콜라")
        );
    }

    private static Stream<List<Integer>> expectedMenuCountsSource() {
        return Stream.of(
                List.of(1,1,2,1)
        );
    }


}