package christmas;

import christmas.domain.GiftMenuInfo;
import christmas.domain.OrderInfo;
import christmas.domain.User.UserBenefitInfo;
import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.service.BusinessService;
import christmas.service.util.DDayCheck;
import christmas.service.util.GiftCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DomainEntityManagerTest {
    private DomainEntityManager domainEntityManager;
    private BusinessService businessService;
    private UserOrderInfo userOrderInfo;
    private UserVisitDay userVisitDay;
    private OrderInfo orderInfo;
    private GiftMenuInfo giftMenuInfo;
    private GiftCheck giftCheck;
    private UserBenefitInfo userBenefitInfo;
    private DDayCheck dDayCheck;

    private int visitDay;
    private String orderInfos;
    @BeforeEach
    void setup(){
        visitDay = 15;
        orderInfos = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        userVisitDay = new UserVisitDay(visitDay);
        userOrderInfo = new UserOrderInfo(orderInfos);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);
        orderInfo = new OrderInfo();
        giftMenuInfo = new GiftMenuInfo();
        giftCheck = new GiftCheck(domainEntityManager);
        userBenefitInfo = new UserBenefitInfo();
        dDayCheck = new DDayCheck(domainEntityManager);
    }

    @DisplayName("도메인 엔티티 매니저가 방문일을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveVisitDayTest(){
        Assertions.assertEquals(domainEntityManager.getUserVisitDay().visitDay()
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

    @DisplayName("도메인 엔티티 매니저가 할인 전 총 주문금액이 12만원 이상일때, 증정 메뉴 정보를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveGiftMenuTest1(){
        //given
        businessService.orderInfoSaveUtil();

        //when
        businessService.giftCheckUtil();

        //then
        Assertions.assertEquals(domainEntityManager.getGiftMenuInfo().getName(),"샴페인");
        Assertions.assertEquals(domainEntityManager.getGiftMenuInfo().getCounts(),1);
    }

    @DisplayName("도메인 엔티티 매니저가 할인 전 총 주문금액이 12만원을 이하일때, 증정 메뉴 정보를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveGiftMenuTest2(){
        //given
        orderInfo.setBeforeOrderAmount(2000);

        //when
        businessService.giftCheckUtil();

        //then
        Assertions.assertEquals(domainEntityManager.getGiftMenuInfo().getName(),"없음");
        Assertions.assertEquals(domainEntityManager.getGiftMenuInfo().getCounts(),0);
    }

    @DisplayName("도메인 엔티티 매니저가 크리스마스 디데이 할인 정보를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveDdayInfoTest1(){
        //given
        businessService.orderInfoSaveUtil();
        //when
        businessService.dDayCheckUtil();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("크리스마스 디데이 할인"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(2400));
    }


    @DisplayName("도메인 엔티티 매니저가 크리스마스 디데이 할인 정보를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveDdayInfoTest2(){
        //given
        visitDay = 26;
        userVisitDay = new UserVisitDay(visitDay);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);
        dDayCheck = new DDayCheck(domainEntityManager);

        //when
        businessService.dDayCheckUtil();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("없음"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(0));
    }

    @DisplayName("도메인 엔티티 매니저가 평일 할인 정보를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveWeekDayDiscounts(){
        //given

        //when
        businessService.weekCategoryCheckUtil();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("주말 할인"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(4046));
    }

    @DisplayName("도메인 엔티티 매니저가 주말 할인 정보를 잘 저장하는가")
    @Test
    void domainEntityManagerSaveWeekendDayDiscounts(){
        //given
        visitDay = 26;
        userVisitDay = new UserVisitDay(visitDay);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);

        //when
        businessService.weekCategoryCheckUtil();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("평일 할인"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(4046));

    }

    @DisplayName("도메인 엔티티 매니저가 특별 할인을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveStarDiscounts1(){
        //given

        //when
        businessService.starCheckUtil();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("없음"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(0));
    }

    @DisplayName("도메인 엔티티 매니저가 특별 할인을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveStarDiscounts2(){
        //given
        visitDay = 25;
        userVisitDay = new UserVisitDay(visitDay);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);
        businessService.orderInfoSaveUtil();
        //when
        businessService.starCheckUtil();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("특별 할인"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(1000));
    }

    @DisplayName("도메인 엔티티 매니저가 증정 이벤트 내역을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveGiftInfo(){
        //given

        //when
        businessService.BusinessServiceProgress();

        //then
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsName().contains("증정 이벤트"));
        Assertions.assertTrue(domainEntityManager.getBenefitInfo().getBenefitsAmounts().contains(25000));
    }

    @DisplayName("도메인 엔티티 매니저가 총 혜택 금액을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveTotalBenefitsAmounts(){
        //given
        visitDay = 3;
        userVisitDay = new UserVisitDay(visitDay);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);

        //when
        businessService.BusinessServiceProgress();

        //then
        Assertions.assertEquals(domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts(), 31246);
    }

    @DisplayName("도메인 엔티티 매니저가 할인 후 예상 결제 금액을 잘 저장하는가")
    @Test
    void domainEntityManagerSaveAfterDiscountAmount(){
        //given
        visitDay = 3;
        userVisitDay = new UserVisitDay(visitDay);
        domainEntityManager = new DomainEntityManager(userVisitDay, userOrderInfo);
        businessService = new BusinessService(domainEntityManager);


        //when
        businessService.BusinessServiceProgress();

        //then
        Assertions.assertEquals(domainEntityManager.getBenefitInfo().getAfterDiscountAmounts(), 135754);
    }

    @DisplayName("도메인 엔티티 매니저가 12월 이벤트 배지를 잘 저장하는가")
    @Test
    void domainEntityMangerSaveEventBadge1(){
        //given

        //when
        businessService.BusinessServiceProgress();

        //then
        Assertions.assertEquals(domainEntityManager.getEventBadge().getEventBadge(),"산타");
    }

    @DisplayName("도메인 엔티티 매니저가 12월 이벤트 배지를 잘 저장하는가")
    @Test
    void domainEntityMangerSaveEventBadge2(){
        //given
        domainEntityManager.getBenefitInfo().setTotalBenefitsAmounts(10000);

        //when
        businessService.eventBadgeCheckUtil();

        //then
        Assertions.assertEquals(domainEntityManager.getEventBadge().getEventBadge(),"트리");
    }

    @DisplayName("도메인 엔티티 매니저가 12월 이벤트 배지를 잘 저장하는가")
    @Test
    void domainEntityMangerSaveEventBadge3(){
        //given
        domainEntityManager.getBenefitInfo().setTotalBenefitsAmounts(5000);

        //when
        businessService.eventBadgeCheckUtil();

        //then
        Assertions.assertEquals(domainEntityManager.getEventBadge().getEventBadge(),"별");
    }


    @DisplayName("도메인 엔티티 매니저가 12월 이벤트 배지를 잘 저장하는가")
    @Test
    void domainEntityMangerSaveEventBadge4(){
        //given
        domainEntityManager.getBenefitInfo().setTotalBenefitsAmounts(4999);

        //when
        businessService.eventBadgeCheckUtil();

        //then
        Assertions.assertEquals(domainEntityManager.getEventBadge().getEventBadge(),"없음");
    }

    @DisplayName("도메인 엔티티 매니저가 만원 미만으로 주문할 때, 혜택 미적용을 잘 반영하는가?")
    @Test
    void domainEntityManagerNoneBenefits(){
        //given
        domainEntityManager.getOrderInfo().setBeforeOrderAmount(9000);

        //when
        businessService.orderInfoSaveUtil();
        businessService.calculateBenefitsUtil();

        //then
        Assertions.assertEquals(domainEntityManager.getBenefitInfo().getTotalBenefitsAmounts(),0);

    }

}