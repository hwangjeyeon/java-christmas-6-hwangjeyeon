package christmas;

import christmas.domain.OrderInfo;
import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.service.BusinessService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DomainEntityManagerTest {
    private DomainEntityManager domainEntityManager;
    private BusinessService businessService;
    UserOrderInfo userOrderInfo;
    UserVisitDay userVisitDay;
    OrderInfo orderInfo;
    int visitDay;
    String orderInfos;
    @BeforeEach
    void setup(){
        visitDay = 15;
        orderInfos = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        userVisitDay = new UserVisitDay(visitDay);
        userOrderInfo = new UserOrderInfo(orderInfos);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);
        orderInfo = new OrderInfo();
    }

    @DisplayName("도메인 엔티티 매니저가 방문일을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveVisitDayTest(){
        Assertions.assertEquals(domainEntityManager.getUserVisitDay().getVisitDay()
                , visitDay);

    }

    @DisplayName("도메인 엔티티 매니저가 주문 메뉴를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveMenuTest(){
        Assertions.assertEquals(domainEntityManager.getUserOrderInfo().getMenu()
                , userOrderInfo.getMenu());
    }

    @DisplayName("도메인 엔티티 매니저가 주문 개수를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveCountsTest(){
        Assertions.assertEquals(domainEntityManager.getUserOrderInfo().getCounts()
                , userOrderInfo.getCounts());
    }

    @DisplayName("도메인 엔티티 매니저가 주문 총 개수를 잘 계산하는가")
    @Test
    void domainEntityManagerCalOrderCountsTest(){
        Assertions.assertEquals(domainEntityManager.getUserOrderInfo().calculateOrderCounts()
                , userOrderInfo.calculateOrderCounts());
    }

    @DisplayName("도메인 엔티티 매니저가 할인 정 총 주문 금액을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveBeforeOrderAmountTest(){
        //given
        businessService.orderInfoSaveUtil();

        //when
        orderInfo.setBeforeOrderAmount(142000);

        //then
        Assertions.assertEquals(domainEntityManager.getOrderInfo().getBeforeOrderAmount()
                , orderInfo.getBeforeOrderAmount());
    }




}