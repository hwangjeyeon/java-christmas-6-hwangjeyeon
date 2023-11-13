package christmas;

import christmas.domain.GiftMenuInfo;
import christmas.domain.OrderInfo;
import christmas.domain.User.UserBenefitInfo;
import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;
import christmas.domain.calendar.December;
import christmas.domain.menu.MenuInfo;

import java.util.Calendar;
import java.util.EnumMap;


public class DomainEntityManager {

    private final UserOrderInfo userOrderInfo;
    private final UserVisitDay userVisitDay;
    private final OrderInfo orderInfo;
    private final EnumMap<MenuInfo, Integer> orderPrice;
    private final GiftMenuInfo giftMenuInfo;
    private final EnumMap<December, Integer> calender;
    private final UserBenefitInfo benefitInfo;



    public DomainEntityManager(UserVisitDay userVisitDay, UserOrderInfo userOrderInfo) {
        this.userVisitDay = userVisitDay;
        this.userOrderInfo = userOrderInfo;
        this.orderInfo = new OrderInfo();
        this.orderPrice = new EnumMap<>(MenuInfo.class);
        this.giftMenuInfo = new GiftMenuInfo();
        this.calender = new EnumMap<>(December.class);
        this.benefitInfo = new UserBenefitInfo();
    }

    public UserOrderInfo getUserOrderInfo() {
        return userOrderInfo;
    }

    public UserVisitDay getUserVisitDay() {
        return userVisitDay;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public EnumMap<MenuInfo, Integer> getOrderPrice() {
        return orderPrice;
    }

    public GiftMenuInfo getGiftMenuInfo() {
        return giftMenuInfo;
    }

    public EnumMap<December, Integer> getCalender() {
        return calender;
    }

    public UserBenefitInfo getBenefitInfo() {
        return benefitInfo;
    }
}
