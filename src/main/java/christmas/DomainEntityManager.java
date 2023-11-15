package christmas;

import christmas.domain.EventBadgeInfo;
import christmas.domain.GiftMenuInfo;
import christmas.domain.OrderInfo;
import christmas.domain.User.UserBenefitInfo;
import christmas.domain.User.UserOrderInfo;
import christmas.domain.User.UserVisitDay;

/**
 * DomainEntityManager는 도메인 객체들을 관리하는 곳입니다.
 */
public class DomainEntityManager {

    private final UserOrderInfo userOrderInfo;
    private final UserVisitDay userVisitDay;
    private final OrderInfo orderInfo;
    private final GiftMenuInfo giftMenuInfo;
    private final UserBenefitInfo benefitInfo;
    private final EventBadgeInfo eventBadgeInfo;



    public DomainEntityManager(UserVisitDay userVisitDay, UserOrderInfo userOrderInfo) {
        this.userVisitDay = userVisitDay;
        this.userOrderInfo = userOrderInfo;
        this.orderInfo = new OrderInfo();
        this.giftMenuInfo = new GiftMenuInfo();
        this.benefitInfo = new UserBenefitInfo();
        this.eventBadgeInfo = new EventBadgeInfo();
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

    public EventBadgeInfo getEventBadge() {
        return eventBadgeInfo;
    }
}
