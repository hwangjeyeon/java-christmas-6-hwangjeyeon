package christmas;

import christmas.domain.EventBadge;
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
    private final GiftMenuInfo giftMenuInfo;
    private final UserBenefitInfo benefitInfo;
    private final EventBadge eventBadge;



    public DomainEntityManager(UserVisitDay userVisitDay, UserOrderInfo userOrderInfo) {
        this.userVisitDay = userVisitDay;
        this.userOrderInfo = userOrderInfo;
        this.orderInfo = new OrderInfo();
        this.giftMenuInfo = new GiftMenuInfo();
        this.benefitInfo = new UserBenefitInfo();
        this.eventBadge = new EventBadge();
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

    public GiftMenuInfo getGiftMenuInfo() {
        return giftMenuInfo;
    }

    public UserBenefitInfo getBenefitInfo() {
        return benefitInfo;
    }

    public EventBadge getEventBadge() {
        return eventBadge;
    }
}
